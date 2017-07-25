package desview.scheduler;

import desview.controller.ReadingControl;
import desview.controller.TaskControl;
import desview.controller.snmp.SNMPFacade;
import desview.model.entities.Reading;
import desview.model.entities.Task;
import desview.model.entities.Variable;
import desview.model.enums.TaskStatus;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * This class represents the scheduler job.
 * Here the readings go to the database.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 20/04/2010.
 * @version 1.0
 */
public class InsertJob implements Job {

    private ReadingControl controleLeitura;
    private TaskControl controleTarefa;

    /**
     * Constructor of the class.
     */
    public InsertJob() {
        controleTarefa = new TaskControl();
    }

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        List<Task> listaTarefas = controleTarefa.getTasks();
        for (Task tarefa : listaTarefas) {
            List<Variable> lista = tarefa.getVariables();
            String inicioString = tarefa.getEstimatedStartDate();
            String fimString = tarefa.getEstimatedEndDate();
            String IPEquipamento = tarefa.getEquipment().getIP();
            String comunidadeLeitura = tarefa.getEquipment().getReadCommunity();
            Date inicio = new Date();
            Date fim = new Date();
            TaskStatus status = tarefa.getStatus();
            Calendar start = new GregorianCalendar();
            Calendar end = new GregorianCalendar();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            try {
                inicio = formatoData.parse(inicioString);
                start.setTime(inicio);
                if (fimString != null) {
                    fim = formatoData.parse(fimString);
                    end.setTime(fim);
                } else {
                    fim = null;
                }

                Calendar hoje = Calendar.getInstance();
                String today = formatoData.format(hoje.getTime());
                String freq = tarefa.getVolatileFrequency();
                Integer frequency = Integer.parseInt(freq);
                //se deve executar a tarefa
                if (hoje.after(start) && hoje.before(end)) {
                    if (frequency == 5) {
                        if (status.equals(TaskStatus.RUNNING)) {
                            executaLeitura(lista, tarefa, IPEquipamento, comunidadeLeitura);
                            if (tarefa.getEffectiveStartDate() == null) {
                                tarefa.setEffectiveStartDate(today);
                            }
                            tarefa.setVolatileFrequency(tarefa.getFrequencyAuxiliary());
                            atualizaTarefa(tarefa);
                        } else if (status.equals(TaskStatus.WAITING) || status.equals(TaskStatus.FINISHED)) {
                            tarefa.setStatus(TaskStatus.RUNNING);
                            tarefa.setVolatileFrequency(tarefa.getFrequencyAuxiliary());
                            if (tarefa.getEffectiveStartDate() == null) {
                                tarefa.setEffectiveStartDate(today);
                            }
                            atualizaTarefa(tarefa);
                            executaLeitura(lista, tarefa, IPEquipamento, comunidadeLeitura);
                        }
                    } else {
                        tarefa.setVolatileFrequency(String.valueOf((frequency - 5)));
                        atualizaTarefa(tarefa);
                    }
                } else {//terminou o tempo de execucao
                    if (status.equals(TaskStatus.RUNNING) || status.equals(TaskStatus.WAITING)) {
                        tarefa.setStatus(TaskStatus.FINISHED);
                        tarefa.setEffectiveEndDate(today);
                        atualizaTarefa(tarefa);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizaTarefa(Task tarefa) {
        controleTarefa.setTask(tarefa);
        controleTarefa.update();
    }

    private void executaLeitura(List<Variable> lista, Task tarefa, String ip, String comunidade) {
        controleLeitura = new ReadingControl();
        for (int i = 0; i < lista.size(); i++) {
            String oid = lista.get(i).getOid();
            String nome = lista.get(i).getLabel();
            String valor = SNMPFacade.snmpGet(oid, ip, comunidade);
            Reading leituraEfetuada = new Reading();
            Date dataLeitura = new Date();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            leituraEfetuada.setReadTime(formatoData.format(dataLeitura));
            leituraEfetuada.setVariable(lista.get(i));
            leituraEfetuada.setReadValue(valor);
            leituraEfetuada.setTask(tarefa);
            leituraEfetuada.setOid(oid);
            leituraEfetuada.setVariableName(nome);
            controleLeitura.setReading(leituraEfetuada);
            controleLeitura.insert();
        }
    }
}
