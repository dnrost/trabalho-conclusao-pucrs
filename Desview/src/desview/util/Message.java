package desview.util;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * Classe that provides personalized messages.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 11/04/2010.
 * @version 1.0
 */
public class Message {

    /**
     * Constructor of class.
     */
    private Message() {
    }

    /**
     * Shows an error message.
     * @param component the component, it can be null.
     * @param title the window title.
     * @param text window text.
     */
    public static void error(JComponent component, String title, String text) {
        JOptionPane.showMessageDialog(component, new StringBuilder(text).toString(), new StringBuilder(title).toString(), JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows an information message.
     * @param component the component, it can be null.
     * @param title the window title.
     * @param text window text.
     */
    public static void information(JComponent component, String title, String text) {
        JOptionPane.showMessageDialog(component, new StringBuilder(text).toString(), new StringBuilder(title).toString(), JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Shows a warning message.
     * @param component the component, it can be null.
     * @param title the window title.
     * @param text window text.
     */
    public static void warning(JComponent component, String title, String text) {
        JOptionPane.showMessageDialog(component, new StringBuilder(text).toString(), new StringBuilder(title).toString(), JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Shows a question message.
     * @param component the component, it can be null.
     * @param title the window title.
     * @param text window text.
     * @return true if yes was pressed, false otherwise.
     */
    public static boolean question(JComponent component, String title, String text) {
        int i = JOptionPane.showConfirmDialog(component, new StringBuilder(text).toString(), new StringBuilder(title).toString(), JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.OK_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Shows a prompt message.
     * @param component the component, it can be null.
     * @param title the window title.
     * @param text window text.
     * @return the inserted string.
     */
    public static String prompt(JComponent component, String title, String text) {
        StringBuilder valor = new StringBuilder(JOptionPane.showInputDialog(component, new StringBuilder(text).toString(), new StringBuilder(title).toString(), JOptionPane.QUESTION_MESSAGE));
        return valor.toString();
    }
}
