package desview.model.enums;

/**
 * Enumeration that represents the access types of a variable.
 * @author Diones Rossetto
 * @author Luiz Mello
 * @version 1.0
 * @since 18/04/2010
 */
public enum VariableAccessType {

    /**
     * The variable is read-only
     */
    READ_ONLY,
    /**
     * The variable is read-write.
     */
    READ_WRITE,
    /**
     * The variable is write-only.
     */
    WRITE_ONLY,
    /**
     * The variable there is not access.
     */
    NOT_AVAILABLE
}
