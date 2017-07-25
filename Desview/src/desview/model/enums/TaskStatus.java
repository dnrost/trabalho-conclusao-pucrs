package desview.model.enums;

/**
 * Enumeration that represents a task state.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 11/04/2010.
 */
public enum TaskStatus {

    /**
     * The task is waiting to start.<br>
     * Code 0 in database.
     */
    WAITING,
    /**
     * The task is running.<br>
     * Code 1 in database.
     */
    RUNNING,
    /**
     * The task is stopped.<br>
     * Code 2 in database.
     */
    STOPPED,
    /**
     * The task has finished its execution.<br>
     * Code 3 in database.
     */
    FINISHED,
    /**
     * The task is invisible.<br>
     * Code 4 in database.
     */
    INVISIBLE,
    /**
     * An error occured. The task is in error state.<br>
     * Code 5 in database.
     */
    ERROR,
}
