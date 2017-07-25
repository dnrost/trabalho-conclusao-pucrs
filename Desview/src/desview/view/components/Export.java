package desview.view.components;

import desview.controller.HistoricControl;
import desview.export.ExportPDF;
import desview.export.ExportTXT;
import desview.model.entities.Historic;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.jdesktop.swingx.JXFrame;

/**
 * This is a class for export.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 12/06/2010.
 * @version 1.0
 */
public class Export extends JXFrame {

    private static final long serialVersionUID = 86725420254L;
    private HistoricControl historicControl;

    /**
     * Constructor of class.
     * @param title title of window.
     */
    public Export(String title) {
        super(title);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        btSave = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        inutil = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        botaoPDF = new javax.swing.JRadioButton();
        botaoTXT = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSave.setText("OK");
        btSave.setToolTipText("Save the password");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 120, -1));

        btClose.setText("Close");
        btClose.setToolTipText("Close this window");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 100, -1));
        getContentPane().add(inutil, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 300, 20));

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Export data and save as:");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 268, -1));

        grupo.add(botaoPDF);
        botaoPDF.setSelected(true);
        botaoPDF.setText("PDF");
        getContentPane().add(botaoPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        grupo.add(botaoTXT);
        botaoTXT.setText("TXT");
        getContentPane().add(botaoTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            verifyExport();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botaoPDF;
    private javax.swing.JRadioButton botaoTXT;
    private javax.swing.JButton btClose;
    private javax.swing.JButton btSave;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel inutil;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables

    private void verifyExport() throws IOException {
        if (botaoPDF.isSelected()) {
            historicControl = new HistoricControl();
            List<Historic> lista = historicControl.getHistorics();
            JFileChooser save = new JFileChooser();
            save.setFileFilter(new FilterPDF());
            if (save.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String arquivo = save.getSelectedFile().toString();
                ExportPDF t;
                if (arquivo == null || arquivo.equals("")) {
                    t = new ExportPDF("data");
                } else {
                    t = new ExportPDF(arquivo);
                }
                ArrayList<String> l = new ArrayList<String>();
                for (Historic h : lista) {
                    l.add(h.toString());
                }
                t.export(l);
            }
        } else if (botaoTXT.isSelected()) {
            historicControl = new HistoricControl();
            List<Historic> lista = historicControl.getHistorics();
            JFileChooser save = new JFileChooser();
            save.setFileFilter(new FilterTXT());
            if (save.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String arquivo = save.getSelectedFile().toString();
                ExportTXT t;
                if (arquivo == null || arquivo.equals("")) {
                    t = new ExportTXT("data");
                } else {
                    t = new ExportTXT(arquivo);
                }
                StringBuilder conteudo = new StringBuilder();
                for (Historic h : lista) {
                    conteudo.append(h.toString());
                    conteudo.append("\n");
                }
                t.export(conteudo.toString());
            }
        }
    }

    class FilterPDF extends FileFilter {

        @Override
        public boolean accept(File file) {
            String filename = file.getName().toLowerCase();
            return filename.endsWith(".pdf");
        }

        @Override
        public String getDescription() {
            return ".pdf";
        }
    }

    class FilterTXT extends FileFilter {

        @Override
        public boolean accept(File file) {
            String filename = file.getName().toLowerCase();
            return filename.endsWith(".txt");
        }

        @Override
        public String getDescription() {
            return ".txt";
        }
    }
}
