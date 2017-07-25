package desview.scheduler;

import desview.controller.HistoricControl;
import desview.controller.ReadingControl;
import desview.model.entities.Historic;
import desview.model.entities.Reading;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * This class represents the scheduler job.
 * Here the readings go to the historic table.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 20/04/2010.
 * @version 1.0
 */
public class CleanerJob implements Job {

    private ReadingControl readingControl;
    private HistoricControl historicControl;

    /**
     * Constructor of the class.
     */
    public CleanerJob() {
    }

    @Override
    @SuppressWarnings("deprecation")
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        readingControl = new ReadingControl();
        List<Reading> removableReadings = new ArrayList<Reading>();
        List<Reading> leituras = readingControl.getReadings();
        for (int i = 0; i < leituras.size(); i++) {
            Reading reading = leituras.get(i);
            Date time = new Date();
            Calendar calendarioTime = new GregorianCalendar();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            try {
                time = formatoData.parse(reading.getReadTime());
                calendarioTime.setTime(time);
            } catch (ParseException ex) {
                ex.printStackTrace();
                calendarioTime.setTime(time);
            }
            Calendar hoje = Calendar.getInstance();
            //se já se passaram 5 minutos
            calendarioTime.set(GregorianCalendar.MINUTE, (calendarioTime.get(GregorianCalendar.MINUTE) + 5));
            if (hoje.after(calendarioTime)) {
                removableReadings.add(reading);
            }
        }
        if (removableReadings.size() > 0) {
            historicControl = new HistoricControl();
            for (int i = 0; i < removableReadings.size(); i++) {
                try {
                    Reading reading = removableReadings.get(i);
                    Historic historic = new Historic();
                    historic.setId(reading.getId());
                    historic.setOid(reading.getOid());
                    String readT = reading.getReadTime();
                    Date r = new Date();
                    GregorianCalendar readTime = new GregorianCalendar();
                    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    r = formatoData.parse(readT);

                    readTime.setTime(r);

                    int day = r.getDate();
                    historic.setReadTimeDay(String.valueOf(day));
                    int month = r.getMonth() + 1;
                    historic.setReadTimeMonth(String.valueOf(month));
                    int year = r.getYear() + 1900;
                    historic.setReadTimeYear(String.valueOf(year));
                    double rv = Double.parseDouble(reading.getReadValue());
                    historic.setReadValue(rv);
                    historic.setTask(reading.getTask());
                    historic.setVariable(reading.getVariable());
                    historic.setVariableName(reading.getVariableName());
                    historicControl.insert(historic);
                    Long id = reading.getId();
                    readingControl.delete(id);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
