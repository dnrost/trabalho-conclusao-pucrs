package desview.model.enums;

/**
 * Enumeracao that represents the types of a variable.
 * @author Diones Rossetto
 * @author Luiz Mello
 * @version 1.0
 * @since 18/04/2010
 */
public enum VariableType {

    /**
     * INTEGER (UNIVERSAL 2);
     */
    INTEGER,
    /**
     * OCTET STRING (UNIVERSAL 4);
     */
    OCTETSTRING,
    /**
     * NULL (UNIVERSAL 5);
     */
    NULL,
    /**
     * OBJECT IDENTIFIER (UNIVERSAL 6);
     */
    IDENTIFIER,
    /**
     * SEQUENCE, SEQUENCE OF (UNIVERSAL 16);
     */
    SEQUENCE
}
