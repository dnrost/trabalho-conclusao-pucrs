package desview.model.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class that represents the reading historic.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 02/05/2010.
 * @version 1.0
 */
@Entity
@Table(name = "Historic")
public class Historic implements Serializable {

    private static final long serialVersionUID = 8607908L;
    @Id
    private Long id;//id comes from reading table.
    @Column(name = "read_value", nullable = true)
    private double readValue;
    @Column(name = "oid", nullable = true)
    private String oid;
    @Column(name = "variable_name", nullable = true)
    private String variableName;
    @Column(name = "day", nullable = false)
    private String day;
    @Column(name = "month", nullable = false)
    private String month;
    @Column(name = "year", nullable = false)
    private String year;
    @JoinColumn(nullable = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Variable variable;
    @JoinColumn(nullable = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Task task;

    /**
     * Constructor of the class;
     * @param oid the variable oid.
     * @param readValue the read value of a reading.
     * @param variableName the variable name of a reading.
     * @param day the day of a reading.
     * @param month the month of a reading.
     * @param year the year of a reading.
     * @param variable the variable of the reading.
     * @param task the task that is associated with the reading.
     */
    public Historic(String oid, String variableName, double readValue, String day, String month, String year, Variable variable, Task task) {
        setOid(oid);
        setVariableName(variableName);
        setReadValue(readValue);
        setReadTimeDay(day);
        setReadTimeMonth(month);
        setReadTimeYear(year);
        setVariable(variable);
        setTask(task);
    }

    /**
     *Constructor default of class.
     */
    public Historic() {
    }

    /**
     * Returns the id.
     * @return id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     * @param id new id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the read time (day).
     * @return read time.
     */
    public String getReadTimeDay() {
        return day;
    }

    /**
     * Sets the read time(day).
     * @param day new read time.
     */
    public void setReadTimeDay(String day) {
        this.day = day;
    }

    /**
     * Returns the read time (month).
     * @return read time.
     */
    public String getReadTimeMonth() {
        return month;
    }

    /**
     * Sets the read time(month).
     * @param month new read time.
     */
    public void setReadTimeMonth(String month) {
        this.month = month;
    }

    /**
     * Returns the read time (yeary).
     * @return read time.
     */
    public String getReadTimeYear() {
        return year;
    }

    /**
     * Sets the read time(year).
     * @param year new read time.
     */
    public void setReadTimeYear(String year) {
        this.year = year;
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
     * Returns the task.
     * @return task.
     */
    public Task getTask() {
        return task;
    }

    /**
     * Sets the task.
     * @param task new task.
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * Returns the oid.
     * @return oid.
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets oid.
     * @param oid new oid.
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * Returns the read value.
     * @return read value.
     */
    public double getReadValue() {
        return readValue;
    }

    /**
     * Sets read value.
     * @param readValue new read value.
     */
    public void setReadValue(double readValue) {
        this.readValue = readValue;
    }

    /**
     * Returns the variable.
     * @return variable.
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
     * Sets the variable.
     * @param variable new variable.
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
        if (!(object instanceof Historic)) {
            return false;
        }
        Historic other = (Historic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Reading: [oid = ").append(variable.getOid());
        s.append(", Time =  ").append(day);
        s.append("/").append(month).append("/").append(year);
        s.append(", value =  ").append(readValue);
        s.append(", task =  ").append(task.getTaskName());
        s.append("]");
        return s.toString();
    }
}
