package desview.view;

import desview.controller.VariableControl;
import desview.model.entities.Variable;
import desview.util.Message;
import java.awt.Dimension;
import java.awt.Toolkit;
import org.jdesktop.swingx.JXFrame;

/**
 * Class for variable information visualization.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 18/04/2010.
 * @version 1.0
 */
public class VariableDataWindow extends JXFrame {

    private static final long serialVersionUID = 5904525423l;
    private Variable variable;
    private VariableControl variabelControl;
    private boolean canEdit = true;

    /**
     * Constructor of class.
     * @param variable
     * @param canEdit
     */
    public VariableDataWindow(Variable variable, boolean canEdit) {
        initComponents();
        setSize(new Dimension(700, 800));
        centralizaJanela();
        buttonSave.setEnabled(false);
        variabelControl = new VariableControl();
        this.variable = variable;
        this.canEdit = canEdit;
        buttonEdit.setEnabled(canEdit);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelOID = new org.jdesktop.swingx.JXLabel();
        textoOID = new javax.swing.JTextField();
        labelRotulo = new org.jdesktop.swingx.JXLabel();
        textoRotulo = new javax.swing.JTextField();
        labelAcesso = new org.jdesktop.swingx.JXLabel();
        textoAcesso = new javax.swing.JTextField();
        labelTipo = new org.jdesktop.swingx.JXLabel();
        textoTipo = new javax.swing.JTextField();
        labelMib = new org.jdesktop.swingx.JXLabel();
        textoMib = new javax.swing.JTextField();
        labelUpper = new org.jdesktop.swingx.JXLabel();
        textoUpper = new javax.swing.JTextField();
        labelDescricao = new org.jdesktop.swingx.JXLabel();
        labelLower = new org.jdesktop.swingx.JXLabel();
        textoLower = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        textoDescricao = new javax.swing.JTextArea();
        botaoFechar = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        inutil = new javax.swing.JLabel();
        buttonEdit = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOID.setText("OID:");
        getContentPane().add(labelOID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 98, -1));

        textoOID.setEditable(false);
        getContentPane().add(textoOID, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 11, 280, -1));

        labelRotulo.setText("Label:");
        getContentPane().add(labelRotulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 98, -1));

        textoRotulo.setEditable(false);
        getContentPane().add(textoRotulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 37, 280, -1));

        labelAcesso.setText("Access:");
        getContentPane().add(labelAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 98, -1));

        textoAcesso.setEditable(false);
        getContentPane().add(textoAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 63, 280, -1));

        labelTipo.setText("Type:");
        getContentPane().add(labelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 98, -1));

        textoTipo.setEditable(false);
        getContentPane().add(textoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 94, 280, -1));

        labelMib.setText("Mib:");
        getContentPane().add(labelMib, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 98, -1));

        textoMib.setEditable(false);
        getContentPane().add(textoMib, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 280, -1));

        labelUpper.setText("Upper:");
        getContentPane().add(labelUpper, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 98, -1));

        textoUpper.setEditable(false);
        getContentPane().add(textoUpper, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 280, -1));

        labelDescricao.setText("Description:");
        getContentPane().add(labelDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 98, -1));

        labelLower.setText("Lower:");
        getContentPane().add(labelLower, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 98, -1));

        textoLower.setEditable(false);
        getContentPane().add(textoLower, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 280, -1));

        textoDescricao.setColumns(20);
        textoDescricao.setEditable(false);
        textoDescricao.setRows(5);
        scroll.setViewportView(textoDescricao);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 226, 280, 140));

        botaoFechar.setText("Close");
        botaoFechar.setToolTipText("Close this window");
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });
        getContentPane().add(botaoFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 90, -1));

        buttonSave.setText("Save");
        buttonSave.setToolTipText("Save the variable");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 100, -1));

        inutil.setText(" ");
        getContentPane().add(inutil, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 350, -1));

        buttonEdit.setText("Edit");
        buttonEdit.setToolTipText("Edit the variable");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });
        getContentPane().add(buttonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        buttonSave.setEnabled(false);
        textoMib.setEditable(false);
        textoUpper.setEditable(false);
        textoLower.setEditable(false);
        variable.setMib(textoMib.getText());
        variable.setUpper(textoUpper.getText());
        variable.setLower(textoLower.getText());
        save();
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        buttonSave.setEnabled(true);
        buttonEdit.setEnabled(false);
        textoMib.setEditable(true);
        textoUpper.setEditable(true);
        textoLower.setEditable(true);
    }//GEN-LAST:event_buttonEditActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel inutil;
    private org.jdesktop.swingx.JXLabel labelAcesso;
    private org.jdesktop.swingx.JXLabel labelDescricao;
    private org.jdesktop.swingx.JXLabel labelLower;
    private org.jdesktop.swingx.JXLabel labelMib;
    private org.jdesktop.swingx.JXLabel labelOID;
    private org.jdesktop.swingx.JXLabel labelRotulo;
    private org.jdesktop.swingx.JXLabel labelTipo;
    private org.jdesktop.swingx.JXLabel labelUpper;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField textoAcesso;
    private javax.swing.JTextArea textoDescricao;
    private javax.swing.JTextField textoLower;
    private javax.swing.JTextField textoMib;
    private javax.swing.JTextField textoOID;
    private javax.swing.JTextField textoRotulo;
    private javax.swing.JTextField textoTipo;
    private javax.swing.JTextField textoUpper;
    // End of variables declaration//GEN-END:variables

    public String getTextoAcesso() {
        return textoAcesso.getText();
    }

    public void setTextoAcesso(String textoAcesso) {
        this.textoAcesso.setText(textoAcesso);
    }

    public String getTextoDescricao() {
        return textoDescricao.getText();
    }

    public void setTextoDescricao(String textoDescricao) {
        this.textoDescricao.setText(textoDescricao);
    }

    public String getTextoLower() {
        return textoLower.getText();
    }

    public void setTextoLower(String textoLower) {
        this.textoLower.setText(textoLower);
    }

    public String getTextoMib() {
        return textoMib.getText();
    }

    public void setTextoMib(String textoMib) {
        this.textoMib.setText(textoMib);
    }

    public String getTextoOID() {
        return textoOID.getText();
    }

    public void setTextoOID(String textoOID) {
        this.textoOID.setText(textoOID);
    }

    public String getTextoRotulo() {
        return textoRotulo.getText();
    }

    public void setTextoRotulo(String textoRotulo) {
        this.textoRotulo.setText(textoRotulo);
    }

    public String getTextoTipo() {
        return textoTipo.getText();
    }

    public void setTextoTipo(String textoTipo) {
        this.textoTipo.setText(textoTipo);
    }

    public String getTextoUpper() {
        return textoUpper.getText();
    }

    public void setTextoUpper(String textoUpper) {
        this.textoUpper.setText(textoUpper);
    }

    private void centralizaJanela() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    private void save() {
        variabelControl.setVariable(variable);
        if (variabelControl.update()) {
            Message.information(null, "Update", "Updated!");
        } else {
            Message.error(null, "Update", "Not updated!");
        }
        buttonEdit.setEnabled(true);
    }
}
