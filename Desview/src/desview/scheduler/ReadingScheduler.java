package desview.scheduler;

import java.util.Date;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

/**
 * This class is the scheduler of the reading system.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 21/04/2010.
 * @version 1.0
 */
public class ReadingScheduler {

    /**
     * Constructor of the class.
     */
    public ReadingScheduler() {
    }

    /**
     * This is the scheduler of the reading system.
     * @param today this is the time to start the scheduling (now).
     * @param time the repetition time in seconds
     * @throws Exception exception.
     */
    @SuppressWarnings("deprecation")
    public void schedule(Date today, long time) throws Exception {

        // obtemos a referência para o escalonador.
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler schedule = sf.getScheduler();
        System.out.println("------- Scheduler started succesfully -----------");
        AnnualCalendar calendario = new AnnualCalendar();

        schedule.addCalendar("calendar", calendario, false, false);

        // escalona a tarefa para executar
        Date dataExecucao = TriggerUtils.getDateOf(today.getSeconds(), today.getMinutes(), today.getHours(), today.getDate(), (today.getMonth() + 1), (today.getYear() + 1900));
        JobDetail job1 = new JobDetail("task1", "group1", InsertJob.class);
        SimpleTrigger trigger1 = new SimpleTrigger("trigger1", "group1",
                dataExecucao,
                null,
                SimpleTrigger.REPEAT_INDEFINITELY,
                time * 1000L);
        // informa ao trigger para obedecer o calendário!
        trigger1.setCalendarName("calendar");


        JobDetail job2 = new JobDetail("task2", "group2", CleanerJob.class);
        SimpleTrigger trigger2 = new SimpleTrigger("trigger2", "group2",
                dataExecucao,
                null,
                SimpleTrigger.REPEAT_INDEFINITELY,
                time * 1000L);
        // informa ao trigger para obedecer o calendário!
        trigger2.setCalendarName("calendar");

        // escalona a tarefa.
        schedule.scheduleJob(job1, trigger1);
        schedule.scheduleJob(job2, trigger2);

        // as tarefas foram adicionadas para o escalonador, mas nenhuma executará até que o escalonador seja iniciado.

        schedule.start();

        SchedulerMetaData metaData = schedule.getMetaData();
        System.out.println("Executed " + metaData.getNumberOfJobsExecuted() + " tasks.");
    }
}
