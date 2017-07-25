package desview.scheduler;

import desview.util.Util;
import java.util.Date;

/**
 * Class that represents a <i>Thread</i> of reading.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 25/04/2010.
 * @version 1.0
 */
public class Reader extends Thread {

    /**
     * Constructor of the class.
     */
    public Reader() {
    }

    @Override
    public void run() {
        ReadingScheduler scheduler = new ReadingScheduler();
        try {
            Date now = new Date();
            //alterar para ler do banco.
            scheduler.schedule(now, Util.INTERVAL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
