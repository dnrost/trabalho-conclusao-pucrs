package desview.view.components;

import desview.controller.VariableControl;
import desview.model.entities.Variable;
import org.jdesktop.swingx.JXFrame;

/**
 * Thresholds edit window.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 17/04/2010.
 */
public class ThresholdsEdit extends JXFrame {

    private static final long serialVersionUID = 98908;
    private String upper;
    private String lower;
    private Variable variable;

    /**
     * Constructor of class.
     * @param v the variable.
     */
    public ThresholdsEdit(Variable v) {
        super("Desview: Thresholds");
        this.variable = v;
        initComponents();
        this.titulo.setText(v.getLabel());
        relacionaDados();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new org.jdesktop.swingx.JXLabel();
        labelUpper = new org.jdesktop.swingx.JXLabel();
        labelLower = new org.jdesktop.swingx.JXLabel();
        btSalvar = new javax.swing.JButton();
        textUpper = new javax.swing.JTextField();
        textLower = new javax.swing.JTextField();
        botaoSair = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        inutil = new javax.swing.JLabel();

        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowSize(6);
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        titulo.setBorder(dropShadowBorder1);
        titulo.setText("                    ");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, -1));

        labelUpper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUpper.setText("Upper threshold:");
        getContentPane().add(labelUpper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, -1));

        labelLower.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLower.setText("Lower threshold:");
        getContentPane().add(labelLower, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 170, -1));

        btSalvar.setText("OK");
        btSalvar.setToolTipText("Save and close this window");
        btSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowBottomShadow(false);
        dropShadowBorder2.setShowRightShadow(false);
        textUpper.setBorder(dropShadowBorder2);
        getContentPane().add(textUpper, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder3.setShowBottomShadow(false);
        dropShadowBorder3.setShowRightShadow(false);
        textLower.setBorder(dropShadowBorder3);
        getContentPane().add(textLower, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 140, -1));

        botaoSair.setText("Close");
        botaoSair.setToolTipText("Close this window");
        botaoSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 90, -1));
        getContentPane().add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 340, 10));
        getContentPane().add(inutil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 320, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        botaoSalvarEvento();
        dispose();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        dispose();
    }//GEN-LAST:event_botaoSairActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel inutil;
    private org.jdesktop.swingx.JXLabel labelLower;
    private org.jdesktop.swingx.JXLabel labelUpper;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField textLower;
    private javax.swing.JTextField textUpper;
    private org.jdesktop.swingx.JXLabel titulo;
    // End of variables declaration//GEN-END:variables

    private void relacionaDados() {
        setUpper(textUpper.getText());
        setLower(textLower.getText());
    }

    private void botaoSalvarEvento() {
        relacionaDados();
        VariableControl controleVariavel = new VariableControl();
        variable.setUpper(getUpper());
        variable.setLower(getLower());
        controleVariavel.setVariable(variable);
        controleVariavel.update();
    }

    private String getLower() {
        return lower;
    }

    private void setLower(String lower) {
        this.lower = lower;
    }

    private String getUpper() {
        return upper;
    }

    private void setUpper(String upper) {
        this.upper = upper;
    }
}
