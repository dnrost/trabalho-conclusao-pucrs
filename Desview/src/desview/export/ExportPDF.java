package desview.export;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import desview.util.Message;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is a class for PDF export.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 12/06/2010.
 * @version 1.0
 */
public class ExportPDF {

    private String name;

    public void export(ArrayList<String> lista) {
        Document document = new Document();
        boolean problem = false;
        try {
            PdfWriter.getInstance(document, new FileOutputStream(name + ".pdf"));
            document.open();

            // adicionando um paragrafo ao documento
            StringBuilder s = new StringBuilder();
            s.append("Exporting ").append(name).append(".");
            document.add(new Paragraph(s.toString()));
            for (String string : lista) {
                document.add(new Paragraph(string));
            }
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
            de.printStackTrace();
            Message.error(null, "Problem", "No PDF output.");
            problem = true;
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            ioe.printStackTrace();
            Message.error(null, "Problem", "No PDF output.");
            problem = true;
        }
        if (!problem) {
            StringBuilder s = new StringBuilder();
            s.append("File ").append(name).append(".pdf exported successfully!");
            Message.information(null, "Output", s.toString());
        }
        document.close();
    }

    public ExportPDF(String name) {
        this.name = name;
    }
}
