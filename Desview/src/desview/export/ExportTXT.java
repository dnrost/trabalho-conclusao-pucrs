package desview.export;

import desview.util.Message;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is a class for TXT export.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 12/06/2010.
 * @version 1.0
 */
public class ExportTXT {

    private String name;

    public void export(String conteudo) {

        boolean problem = false;
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(name + ".txt"));
            pw.write(conteudo);
            pw.flush();
            pw.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            ioe.printStackTrace();
            Message.error(null, "Problem", "No output.");
            problem = true;
        }
        if (!problem) {
            StringBuilder s = new StringBuilder();
            s.append("File ").append(name).append(".txt exported  successfully!");
            Message.information(null, "Output", s.toString());
        }
    }

    public ExportTXT(String name) {
        this.name = name;
    }
}
