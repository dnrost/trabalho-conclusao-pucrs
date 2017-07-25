package desview.util;

/**
 * System utilities class.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 11/04/2010.
 */
public class Util {

    public static final String RELEASE_DATE = new StringBuilder("10/07/2010").toString();
    public static final String VENDOR = new StringBuilder(System.getProperty("java.vendor")).toString();
    public static final String OS = new StringBuilder(System.getProperty("os.name")).toString();
    public static final String FILE_SEPARATOR = new StringBuilder(System.getProperty("file.separator")).toString();
    public static final String JAVA_VERSION = new StringBuilder(System.getProperty("java.version")).toString();
    public static final String LINE_SEPARATOR = new StringBuilder(System.getProperty("line.separator")).toString();
    public static final String USER_DIR = new StringBuilder(System.getProperty("user.dir")).toString();
    public static final Boolean SHOW_SNMP_TIMEOUT_ERROR = false;
    public static final Integer INTERVAL = new Integer(5);
    public static final Integer SNMP_VERSION = new Integer(1); //0 is v1, 1 is v2c and 2 is v3.
    public static final String DESVIEW_VERSION = new StringBuilder("1.0").toString();

    /*
     * Private constructor.
     */
    private Util() {
    }
}

