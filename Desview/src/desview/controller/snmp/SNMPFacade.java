package desview.controller.snmp;

import desview.util.Message;
import desview.util.Util;
import java.net.InetAddress;
import java.util.Vector;
import snmp.SNMPObject;
import snmp.SNMPObjectIdentifier;
import snmp.SNMPOctetString;
import snmp.SNMPSequence;
import snmp.SNMPVarBindList;
import snmp.SNMPv1CommunicationInterface;

/**
 * This method is the facade to SNMP functions (get, set, etc).
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 10/04/2010.
 */
public class SNMPFacade {

    /**
     * Constructor of the class.
     */
    private static String error = "Error!";
    private static String exception = "Exception processing ";
    private static int version = Util.SNMP_VERSION;

    public SNMPFacade() {
    }

    /**
     * This is the <i>set</i> method of SNMP.
     * @param newValue the new value.
     * @param oid the oid.
     * @param ip the IP address.
     * @param writeCommunity the community of writing.
     * @return true if the command results success or false, otherwise returns false.
     */
    public static boolean snmpSet(String newValue, String oid, String ip, String writeCommunity) {
        InetAddress ipAddress;
        SNMPv1CommunicationInterface communicationInterface;
        try {
            ipAddress = InetAddress.getByName(ip);// Recupera o inetAddress
            communicationInterface = new SNMPv1CommunicationInterface(version, ipAddress, writeCommunity);
            SNMPOctetString novoValor = new SNMPOctetString(newValue);
            communicationInterface.setMIBEntry(oid, novoValor);
            return true;
        } catch (Exception e) {
            StringBuffer b = new StringBuffer();
            b.append(exception).append("SNMP SET operation: ").append(e.getMessage());
            System.out.println("[SNMP] " + b.toString());
            if (Util.SHOW_SNMP_TIMEOUT_ERROR) {
                Message.error(null, error, b.toString());
            }
            return false;
        }
    }

    /**
     * This is the <i>get</i> method of SNMP.
     * @param oid the oid.
     * @param ip the IP address.
     * @param readCommunity the community of reading.
     * @return String with the value read.
     */
    public static String snmpGet(String oid, String ip, String readCommunity) {
        InetAddress ipAddress;
        SNMPv1CommunicationInterface communicationInterface;
        try {
            ipAddress = InetAddress.getByName(ip);// Recupera o inetAddress
            communicationInterface = new SNMPv1CommunicationInterface(version, ipAddress, readCommunity);
            SNMPVarBindList varbinds = communicationInterface.getMIBEntry(oid);
            SNMPSequence sequencia = (SNMPSequence) (varbinds.getSNMPObjectAt(0));
            SNMPObject snmpValor = sequencia.getSNMPObjectAt(1);
            String tipo = snmpValor.getClass().getName();
            if (tipo.equals("snmp.SNMPOctetString")) {
                String snmp = snmpValor.toString();
                int fim = snmp.indexOf('\0');
                if (fim >= 0) {
                    snmp = snmp.substring(0, fim);
                }
                StringBuffer b = new StringBuffer();
                b.append(snmp);
                return b.toString();
            } else {
                StringBuffer b = new StringBuffer();
                b.append(snmpValor);
                return b.toString();
            }
        } catch (Exception e) {
            StringBuffer b = new StringBuffer();
            b.append(exception).append("SNMP GET operation: ").append(e.getMessage());
            System.out.println("[SNMP] " + b.toString());
            if (Util.SHOW_SNMP_TIMEOUT_ERROR) {
                Message.error(null, error, b.toString());
            }
            return null;
        }
    }

    /**
     * This is the <i>getNext</i> method of SNMP.
     * @param oid the oid.
     * @param ip the IP address.
     * @param readCommunity the community of reading.
     * @return Vector with the values read.
     */
    public static Vector<String> snmpGetNext(String oid, String ip, String readCommunity) {
        SNMPv1CommunicationInterface communicationInterface;
        InetAddress ipAddress;
        Vector<String> result = new Vector<String>();
        try {
            ipAddress = InetAddress.getByName(ip);// Recupera o inetAddress
            communicationInterface = new SNMPv1CommunicationInterface(version, ipAddress, readCommunity);
            SNMPVarBindList varbinds = communicationInterface.getNextMIBEntry(oid);
            SNMPSequence sequencia = (SNMPSequence) (varbinds.getSNMPObjectAt(0));
            SNMPObjectIdentifier snmpOID = (SNMPObjectIdentifier) sequencia.getSNMPObjectAt(0);
            SNMPObject snmpValor = sequencia.getSNMPObjectAt(1);
            result.add(0, snmpOID.toString());
            String tipo = snmpValor.getClass().getName();
            if (tipo.equals("snmp.SNMPOctetString")) {
                String snmp = snmpValor.toString();
                int fim = snmp.indexOf('\0');
                if (fim >= 0) {
                    snmp = snmp.substring(0, fim);
                }
                StringBuffer b = new StringBuffer();
                b.append("OID: ").append(snmpOID).append("  value: ").append(snmp).append("\n");

                result.add(1, b.toString());
                return result;
            } else {
                StringBuffer b = new StringBuffer();
                b.append("OID: ").append(snmpOID).append("  value: ").append(snmpValor).append("\n");
                result.add(1, b.toString());
                return result;
            }
        } catch (Exception e) {
            StringBuffer b = new StringBuffer();
            b.append(exception).append("SNMP GETNEXT operation: ").append(e.getMessage());
            System.out.println("[SNMP] " + b.toString());
            if (Util.SHOW_SNMP_TIMEOUT_ERROR) {
                Message.error(null, error, b.toString());
            }
        }
        return result;
    }

    /**
     * This is the <i>walk</i> method of SNMP.
     * @param oid the oid.
     * @param ip the IP address.
     * @param readCommunity the community of reading.
     * @return String with the value read.
     */
    public static String snmpWalk(String oid, String ip, String readCommunity) {
        SNMPv1CommunicationInterface communicationInterface;
        InetAddress ipAddress;
        StringBuffer table = new StringBuffer();
        try {
            ipAddress = InetAddress.getByName(ip);// Recupera o inetAddress
            communicationInterface = new SNMPv1CommunicationInterface(version, ipAddress, readCommunity);
            SNMPVarBindList varbinds = communicationInterface.retrieveMIBTable(oid);

            for (int i = 0; i < varbinds.size(); i++) {
                SNMPSequence sequencia = (SNMPSequence) (varbinds.getSNMPObjectAt(i));
                SNMPObjectIdentifier snmpOID = (SNMPObjectIdentifier) sequencia.getSNMPObjectAt(0);
                SNMPObject snmpValor = sequencia.getSNMPObjectAt(1);
                String tipo = snmpValor.getClass().getName();

                if (tipo.equals("snmp.SNMPOctetString")) {
                    String snmp = snmpValor.toString();
                    int fim = snmp.indexOf('\0');
                    if (fim >= 0) {
                        snmp = snmp.substring(0, fim);
                    }
                    StringBuffer b = new StringBuffer();
                    b.append("OID:").append(snmpOID).append(";  type:").append(tipo).append(";  value:").append(snmp).append("\n");
                    table.append(table).append(b);
                } else {
                    StringBuffer b = new StringBuffer();
                    b.append("OID:").append(snmpOID).append(";  type:").append(tipo).append(";  value:").append(snmpValor).append("\n");
                    table.append(table).append(b);
                }
            }
        } catch (Exception n) {
            StringBuffer b = new StringBuffer();
            b.append(exception).append("SNMP WALK operation: ").append(n.getMessage());
            System.out.println("[SNMP] " + b.toString());
            if (Util.SHOW_SNMP_TIMEOUT_ERROR) {
                Message.error(null, error, b.toString());
            }
        }
        return table.toString();
    }
}
