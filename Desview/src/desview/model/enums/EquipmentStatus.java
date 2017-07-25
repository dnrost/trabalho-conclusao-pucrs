package desview.model.enums;

/**
 * Enumeration that represents an equipment state.
 * @author Diones Rossetto
 * @author Luiz Mello
 * @version 1.0
 * @since 12/04/2010
 */
public enum EquipmentStatus {

    /**
     * Equipment is up and replying SNMP requisitions.
     */
    UP,
    /**
    Equipment is probably down and it is not replying SNMP requisitions.
     */
    DOWN
}
