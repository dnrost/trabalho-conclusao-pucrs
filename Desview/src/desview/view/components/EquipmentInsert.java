package desview.view.components;

import desview.controller.EquipmentControl;
import desview.model.entities.Equipment;
import desview.util.Message;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import org.jdesktop.swingx.JXBusyLabel.Direction;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.border.DropShadowBorder;

/**
 * Equipment insert window.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 14/04/2010.
 */
public class EquipmentInsert extends JXFrame {

    private static final long serialVersionUID = 65257524834515l;
    private String nomeEquipamento;
    private String ipEquipamento;
    private String timeoutEquipamento;
    private String portaEquipamento;
    private String retriesEquipamento;
    private String comunidadeEscritaEquipamento;
    private String comunidadeLeituraEquipamento;
    private EquipmentControl controleEquipamento;

    /**
     * Constructor of class.
     */
    public EquipmentInsert() {
        super("Desview: New equipment");
        controleEquipamento = new EquipmentControl();
        initComponents();
        relacionaDados();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new org.jdesktop.swingx.JXLabel();
        labelIP = new org.jdesktop.swingx.JXLabel();
        labelNome = new org.jdesktop.swingx.JXLabel();
        labelPorta = new org.jdesktop.swingx.JXLabel();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        textNome = new javax.swing.JTextField();
        textPorta = new javax.swing.JTextField();
        statusBar = new org.jdesktop.swingx.JXStatusBar();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        labelComunidadeEscrita = new org.jdesktop.swingx.JXLabel();
        textComunidadeEscrita = new javax.swing.JTextField();
        textComunidadeLeitura = new javax.swing.JTextField();
        labelComunidadeLeitura = new org.jdesktop.swingx.JXLabel();
        labelTimeout = new org.jdesktop.swingx.JXLabel();
        textTimeout = new javax.swing.JTextField();
        labelRetries = new org.jdesktop.swingx.JXLabel();
        textRetries = new javax.swing.JTextField();
        enderecoIP = new desview.util.IPAddress();
        btClose = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowSize(6);
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        label.setBorder(dropShadowBorder1);
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText(" New Equipment");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 383, -1));

        labelIP.setText("IP:");
        getContentPane().add(labelIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 58, 130, -1));

        labelNome.setText("Name:");
        getContentPane().add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, -1));

        labelPorta.setText("Port:");
        getContentPane().add(labelPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, -1));

        btSalvar.setText("Save");
        btSalvar.setToolTipText("Save equipment");
        btSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 100, -1));

        btLimpar.setText("Clear Fields");
        btLimpar.setToolTipText("Close this window");
        btLimpar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 100, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        textNome.setBorder(dropShadowBorder2);
        getContentPane().add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 220, -1));

        textPorta.setText("161");
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder3.setShowBottomShadow(false);
        dropShadowBorder3.setShowRightShadow(false);
        textPorta.setBorder(dropShadowBorder3);
        getContentPane().add(textPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 90, -1));

        statusBar.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        statusBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busy.setText("Ready");
        statusBar.add(busy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 440, 30));

        getContentPane().add(statusBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 470, 40));

        labelComunidadeEscrita.setText("Write community:");
        getContentPane().add(labelComunidadeEscrita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, -1));

        textComunidadeEscrita.setText("public");
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder4.setShowBottomShadow(false);
        dropShadowBorder4.setShowRightShadow(false);
        textComunidadeEscrita.setBorder(dropShadowBorder4);
        getContentPane().add(textComunidadeEscrita, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 220, -1));

        textComunidadeLeitura.setText("public");
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder5 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder5.setShowBottomShadow(false);
        dropShadowBorder5.setShowRightShadow(false);
        textComunidadeLeitura.setBorder(dropShadowBorder5);
        getContentPane().add(textComunidadeLeitura, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 220, -1));

        labelComunidadeLeitura.setText("Read community:");
        getContentPane().add(labelComunidadeLeitura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, -1));

        labelTimeout.setText("Timeout:");
        getContentPane().add(labelTimeout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, -1));

        textTimeout.setText("1000");
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder6 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder6.setShowBottomShadow(false);
        dropShadowBorder6.setShowRightShadow(false);
        textTimeout.setBorder(dropShadowBorder6);
        getContentPane().add(textTimeout, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 90, -1));

        labelRetries.setText("Retries:");
        getContentPane().add(labelRetries, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 130, -1));

        textRetries.setText("2");
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder7 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder7.setShowBottomShadow(false);
        dropShadowBorder7.setShowRightShadow(false);
        textRetries.setBorder(dropShadowBorder7);
        getContentPane().add(textRetries, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 90, -1));
        getContentPane().add(enderecoIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        btClose.setText("Close");
        btClose.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        botaoSalvarEvento();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        botaoCancelarEvento();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private desview.util.IPAddress enderecoIP;
    private org.jdesktop.swingx.JXLabel label;
    private org.jdesktop.swingx.JXLabel labelComunidadeEscrita;
    private org.jdesktop.swingx.JXLabel labelComunidadeLeitura;
    private org.jdesktop.swingx.JXLabel labelIP;
    private org.jdesktop.swingx.JXLabel labelNome;
    private org.jdesktop.swingx.JXLabel labelPorta;
    private org.jdesktop.swingx.JXLabel labelRetries;
    private org.jdesktop.swingx.JXLabel labelTimeout;
    private org.jdesktop.swingx.JXStatusBar statusBar;
    private javax.swing.JTextField textComunidadeEscrita;
    private javax.swing.JTextField textComunidadeLeitura;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textPorta;
    private javax.swing.JTextField textRetries;
    private javax.swing.JTextField textTimeout;
    // End of variables declaration//GEN-END:variables

    private void relacionaDados() {
        this.ipEquipamento = this.enderecoIP.getIp();
        this.nomeEquipamento = this.textNome.getText();
        this.timeoutEquipamento = this.textTimeout.getText();
        this.retriesEquipamento = this.textRetries.getText();
        this.comunidadeEscritaEquipamento = this.textComunidadeEscrita.getText();
        this.comunidadeLeituraEquipamento = this.textComunidadeLeitura.getText();
        this.portaEquipamento = this.textPorta.getText();
    }

    private void botaoSalvarEvento() {
        relacionaDados();
        boolean ipOK = true;
        for (int i = 1; i <= 4; i++) {
            if (enderecoIP.getOctetIP(i).equals("")) {
                setBusy(false, "Equipment IP is mandatory", 0, Color.red);
                ipOK = false;
            }
        }
        if (ipOK) {
            if (nomeEquipamento.equals("")) {
                setBusy(false, "Equipment name is mandatory", 0, Color.red);
                textNome.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
            } else {
                setBusy(true, "Inserting", 50, Color.black);
                DropShadowBorder drop = new DropShadowBorder();
                drop.setShowBottomShadow(false);
                drop.setShowRightShadow(false);
                textNome.setBorder(drop);
                StringBuffer b = new StringBuffer();
                Equipment newEquipment = new Equipment();
                newEquipment.setIP(ipEquipamento);
                newEquipment.setName(nomeEquipamento);
                newEquipment.setReadCommunity(comunidadeLeituraEquipamento);
                newEquipment.setWriteCommunity(comunidadeEscritaEquipamento);
                newEquipment.setPort(portaEquipamento);
                newEquipment.setTimeout(timeoutEquipamento);
                newEquipment.setRetries(retriesEquipamento);
                controleEquipamento.setEquipment(newEquipment);
                if (controleEquipamento.insert()) {
                    b.append("Equipment ").append(nomeEquipamento).append(" was succesfully inserted!");
                    Message.information(null, "Equipment", b.toString());
                    this.dispose();
                } else {
                    b.append("Problem inserting equipment: ").append(nomeEquipamento).append("!");
                    setBusy(false, b.toString(), 0, Color.red);
                }
            }
        }
    }

    private void botaoCancelarEvento() {
        this.textNome.setText("");
        this.textPorta.setText("");
        this.textTimeout.setText("");
        this.textComunidadeEscrita.setText("");
        this.textComunidadeLeitura.setText("");
        this.textRetries.setText("");
        relacionaDados();
    }

    private void setBusy(boolean b, String texto, int delay, Color cor) {
        busy.setBusy(b);
        busy.setText(texto);
        busy.setDelay(delay);
        busy.setForeground(cor);
        busy.setDirection(Direction.LEFT);
    }

    private void centralizaJanela() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }
}
