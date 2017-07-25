package desview.model.entities;

import desview.model.enums.TaskStatus;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class that represents a task.
 * @author Luiz Mello.
 * @author Diones Rossetto.
 * @since 27/03/2010.
 * @version 1.0
 */
@Entity
@Table(name = "Task")
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findById", query = "SELECT t FROM Task t WHERE t.id = :id"),
    @NamedQuery(name = "Task.findByEffectiveEndDate", query = "SELECT t FROM Task t WHERE t.effectiveEndDate = :effectiveEndDate"),
    @NamedQuery(name = "Task.findByEffectiveStartDate", query = "SELECT t FROM Task t WHERE t.effectiveStartDate = :effectiveStartDate"),
    @NamedQuery(name = "Task.findByEstimatedEndDate", query = "SELECT t FROM Task t WHERE t.estimatedEndDate = :estimatedEndDate"),
    @NamedQuery(name = "Task.findByEstimatedStartDate", query = "SELECT t FROM Task t WHERE t.estimatedStartDate = :estimatedStartDate"),
    @NamedQuery(name = "Task.findByFrequency", query = "SELECT t FROM Task t WHERE t.frequency = :frequency"),
    @NamedQuery(name = "Task.findByFrequencyAuxiliary", query = "SELECT t FROM Task t WHERE t.frequencyAuxiliary = :frequencyAuxiliary"),
    @NamedQuery(name = "Task.findByFrequencyVolatile", query = "SELECT t FROM Task t WHERE t.frequencyVolatile = :frequencyVolatile"),
    @NamedQuery(name = "Task.findByStatus", query = "SELECT t FROM Task t WHERE t.status = :status"),
    @NamedQuery(name = "Task.findByTaskName", query = "SELECT t FROM Task t WHERE t.taskName = :taskName")})
public class Task implements Serializable {

    private static final long serialVersionUID = -6490891L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name", nullable = false, length = 250)
    private String taskName;
    @Column(name = "estimated_start_date", nullable = true)
    private String estimatedStartDate;
    @Column(name = "estimated_end_date", nullable = true)
    private String estimatedEndDate;
    @Column(name = "effective_start_date", nullable = true)
    private String effectiveStartDate;
    @Column(name = "effective_end_date", nullable = true)
    private String effectiveEndDate;
    @Column(name = "status", nullable = false)
    private TaskStatus status;
    @Column(name = "frequency", nullable = true)
    private String frequency;
    @Column(name = "frequency_auxiliary", nullable = true)
    private String frequencyAuxiliary;
    @Column(name = "frequency_volatile", nullable = true)
    private String frequencyVolatile;
    @OneToOne
    private Equipment equipment;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Variable> variables;

    /**
     * Construtor da classe Tarefa.
     * @param nomeTarefa o nome da tarefa.
     * @param dataInicioProgramado a data de início programado.
     * @param dataFimProgramado a data de fim programado.
     * @param dataInicioEfetivo a data de início efetivo.
     * @param dataFimEfetivo a data de fim efetivo
     * @param status o status da tarefa.
     * @param frequencia a frequência.
     * @param equipamento o equipamento.
     * @see TaskStatus
     * @see Equipment
     */
    public Task(String nomeTarefa, String dataInicioProgramado, String dataFimProgramado, String dataInicioEfetivo, String dataFimEfetivo, TaskStatus status, String frequencia, Equipment equipamento) {
        setNameTask(nomeTarefa);
        setEstimatedStartDate(dataInicioProgramado);
        setEstimatedEndDate(dataFimProgramado);
        setEffectiveStartDate(dataInicioEfetivo);
        setEffectiveEndDate(dataFimEfetivo);
        setStatus(status);
        setFrequency(frequencia);
        setEquipment(equipamento);
    }

    /**
     * Construtor <i>default</i>.
     * Apenas seta o status da tarefa para <code>TaskStatus.WAITING</code>.<br>
     * Outros métodos precisam ser setados via respectivos <i>sets</i>.
     * @see TaskStatus
     */
    public Task() {
        setStatus(TaskStatus.WAITING);
    }

    /**
     * Retorna o equipamento da tarefa.
     * @return o equipamento.
     * @see Equipment
     */
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * Altera o equipamento da tarefa.
     * @param equipamento novo equipamento.
     * @see Equipment
     */
    public void setEquipment(Equipment equipamento) {
        this.equipment = equipamento;
    }

    /**
     * Retorna data de fim efetivo.
     * @return data de fim efetivo.
     */
    public String getEffectiveEndDate() {
        return effectiveEndDate;
    }

    /**
     * Altera a data de fim efetivo.
     * @param effectiveEndDate nova data de fim efetivo.
     */
    public void setEffectiveEndDate(String effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    /**
     * Retorna a data de fim programado.
     * @return data de fim programado.
     */
    public String getEstimatedEndDate() {
        return estimatedEndDate;
    }

    /**
     * Altera a data de início efetivo.
     * @param dataFimProgramado nova data de fim programado.
     */
    public void setEstimatedEndDate(String dataFimProgramado) {
        this.estimatedEndDate = dataFimProgramado;
    }

    /**
     * Retorna a data de início efetivo.
     * @return data de início efetivo.
     */
    public String getEffectiveStartDate() {
        return effectiveStartDate;
    }

    /**
     * Altera a data de início efetivo.
     * @param dataInicioEfetivo nova data de início efetivo.
     */
    public void setEffectiveStartDate(String dataInicioEfetivo) {
        this.effectiveStartDate = dataInicioEfetivo;
    }

    /**
     * Retorna a data de início programado da tarefa.
     * @return data de início efetivo.
     */
    public String getEstimatedStartDate() {
        return estimatedStartDate;
    }

    /**
     * Altera a data de início programado da tarefa.
     * @param dataInicioProgramado nova data de início programado da tarefa.
     */
    public void setEstimatedStartDate(String dataInicioProgramado) {
        this.estimatedStartDate = dataInicioProgramado;
    }

    /**
     * Sets task frequency.
     * @return task frequency.
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * Sets the frequency of a task.
     * @param frequency the new frequency.
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    /**
     * Retorna o nome da Tarefa
     * @return nome tarefa
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Altera o nome da tarefa.
     * Se o nome da tarefa for nula será setada para <b>Tarefa + id</b>.
     * @param nomeTarefa nome da tarefa.
     */
    public void setNameTask(String nomeTarefa) {
        if (nomeTarefa == null) {
            StringBuffer b = new StringBuffer();
            b.append("Task").append(this.getId());
            this.taskName = b.toString();
        } else {
            this.taskName = nomeTarefa;
        }
    }

    /**
     * Retorna o status da tarefa.
     * @see TaskStatus
     * @return status da tarefa
     */
    public TaskStatus getStatus() {
        return status;
    }

    /**
     * Altera o status da tarefa.
     * @see TaskStatus
     * @param status novo status da tarefa
     */
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    /**
     * Retorna o <i>id</i>.
     * @return o <i>id</i> da tarefa.
     */
    public Long getId() {
        return id;
    }

    public String getFrequencyAuxiliary() {
        return frequencyAuxiliary;
    }

    public void setFrequencyAuxiliary(String auxiliarFrequencia) {
        this.frequencyAuxiliary = auxiliarFrequencia;
    }

    public String getVolatileFrequency() {
        return frequencyVolatile;
    }

    public void setVolatileFrequency(String auxiliarFrequenciaVolatil) {
        this.frequencyVolatile = auxiliarFrequenciaVolatil;
    }

    /**
     * Altera o <i>id</i> da tarefa.
     * @param id novo <i>id</i>.
     */
    public void setId(Long id) {
        this.id = id;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variaveis) {
        this.variables = variaveis;
    }

    public Long getIdEquipment() {
        return equipment.getId();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Task: [name = " + taskName);
        s.append(", equipment =  " + equipment.getId());
        s.append("]");
        return s.toString();
    }

    public String toStringCompleto() {
        StringBuffer s = new StringBuffer();
        s.append("Task: [name = " + taskName);
        s.append(", equipment =  " + equipment.getId());
        if (frequency != null) {
            s.append(", frequencia =  " + frequency);
        }
        if (estimatedStartDate != null) {
            s.append(", estimated start date =  " + estimatedStartDate);
        }
        if (estimatedEndDate != null) {
            s.append(", estimated end date =  " + estimatedEndDate);
        }
        if (effectiveStartDate != null) {
            s.append(", effective start date =  " + effectiveStartDate);
        }
        if (effectiveEndDate != null) {
            s.append(", effective end date =  " + effectiveEndDate);
        }
        if (status != null) {
            s.append(", status =  " + status);
        }
        s.append("]");
        return s.toString();
    }
}
