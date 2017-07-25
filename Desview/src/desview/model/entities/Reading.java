package desview.model.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Class that represents a reading.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 28/03/2010.
 * @version 1.0
 */
@Entity
@Table(name = "Reading")
@NamedQueries({
    @NamedQuery(name = "Reading.findAll", query = "select r from Reading r"),
    @NamedQuery(name = "Reading.findById", query = "select r from Reading r where r.id = :id"),
    @NamedQuery(name = "Reading.findByOid", query = "select r from Reading r where r.oid = :oid"),
    @NamedQuery(name = "Reading.findByReadTime", query = "select r from Reading r where r.readTime = :readTime"),
    @NamedQuery(name = "Reading.findByReadValue", query = "select r from Reading r where r.readValue = :readValue"),
    @NamedQuery(name = "Reading.findByVariableName", query = "select r from Reading r where r.variableName = :variableName"),
    @NamedQuery(name = "Reading.findDistinct", query = "select distinct oid, variableName, task  from Reading r where r.oid = :oid and r.task = :task"),
    @NamedQuery(name = "Reading.findDistinctReading", query = "select distinct r from Reading r where r.oid = :oid and r.task = :task")
})
public class Reading implements Serializable {

    private static final long serialVersionUID = 7909017L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//???????
    private Long id;
    @Column(name = "read_value", nullable = true)
    private String readValue;
    @Column(name = "oid", nullable = true)
    private String oid;
    @Column(name = "variable_name", nullable = true)
    private String variableName;
    @Column(name = "read_time", nullable = false)
    private String readTime;
    @JoinColumn(nullable = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Variable variable;
    @JoinColumn(nullable = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Task task;

    /**
     * Constructor of a Reading.
     * @param oid the variable oid.
     * @param readValue the read value of a reading.
     * @param variableName the variable name of a reading.
     * @param readTime the time of a reading.
     * @param variable the variable of the reading.
     * @param task the task that is associated with the reading.
     */
    public Reading(String oid, String variableName, String readValue, String readTime, Variable variable, Task task) {
        setOid(oid);
        setVariableName(variableName);
        setReadValue(readValue);
        setReadTime(readTime);
        setVariable(variable);
        setTask(task);
    }

    /**
     * Construtor <i>default</i> da classe.<br>
     * Valor, data de leitura, variável e tarefa devem ser informados através de seus respectivos <i>sets</i>.
     */
    public Reading() {
    }

    /**
     * Retorna o <i>id</id> da leitura.
     * @return  <i>id</id>.
     */
    public Long getId() {
        return id;
    }

    /**
     * Retorna <i>id</i> da leitura.
     * @param id novo <i>id</id>.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna a data de leitura.
     * @return data de leitura.
     */
    public String getReadTime() {
        return readTime;
    }

    /**
     * Altera a data de leitura.
     * @param readTime nova data de leitura.
     */
    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    /**
     * Returns the variable name.
     * @return the variable name.
     */
    public String getVariableName() {
        return variableName;
    }

    /**
     * Sets the variable name of a reading.
     * @param variableName the new variable name.
     */
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    /**
     * Retorna a tarefa a qual pertence a leitura.
     * @return tarefa da leitura.
     */
    public Task getTask() {
        return task;
    }

    /**
     * Altera a tarefa da leitura.
     * @param task nova tarefa.
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * Retorna o oid da leitura.
     * @return oid da leitura.
     */
    public String getOid() {
        return oid;
    }

    /**
     * Altera o oid lido.
     * @param oid novo oid lido.
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * Retorna o valor da leitura.
     * @return valor da leitura.
     */
    public String getReadValue() {
        return readValue;
    }

    /**
     * Altera o valor lido.
     * @param readValue novo valor lido.
     */
    public void setReadValue(String readValue) {
        this.readValue = readValue;
    }

    /**
     * Retorna a variável sendo lida.
     * @return variável da leitura.
     */
    public Variable getVariable() {
        return variable;
    }

    /**
     * Returns the variable id of the reading.
     * @return variable id.
     */
    public Long getVariableID() {
        return variable.getId();
    }

    /**
     * Returns the task id of the reading.
     * @return variable id.
     */
    public Long getTaskID() {
        return task.getId();
    }

    /**
     * Altera variável de leitura.
     * @param variable nova variável de leitura.
     */
    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Reading)) {
            return false;
        }
        Reading other = (Reading) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Reading: [oid = ").append(variable.getOid());
        s.append(", date =  ").append(readTime);
        s.append(", value =  ").append(readValue);
        s.append(", task =  ").append(task.getTaskName());
        s.append("]");
        return s.toString();
    }
}
