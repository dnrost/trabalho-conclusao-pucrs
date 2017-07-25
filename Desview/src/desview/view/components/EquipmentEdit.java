package desview.view.components;

import desview.controller.EquipmentControl;
import desview.model.entities.Equipment;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.JXBusyLabel.Direction;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.border.DropShadowBorder;

/**
 * Equipment edition window class.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 14/04/2010.
 */
public class EquipmentEdit extends JXFrame {

    private static final long serialVersionUID = 4387373524834515l;
    private String equipmentName;
    private String equipmentIp;
    private String equipmentTimeout;
    private String equipmentPort;
    private String equipmentRetries;
    private String writeCommunity;
    private String readCommunity;
    private EquipmentControl equipmentControl = new EquipmentControl();
    private DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
    private List<Equipment> equipments;
    private Long currentEquipmentID;

    /**
     * Constructor of class.
     */
    public EquipmentEdit() {
        super("Desview: Equipment update");
        initComponents();
        //  centralizaJanela();
        relacionaDados();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new org.jdesktop.swingx.JXLabel();
        labelEscolha = new org.jdesktop.swingx.JXLabel();
        labelNome = new org.jdesktop.swingx.JXLabel();
        labelPorta = new org.jdesktop.swingx.JXLabel();
        btAtualizar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        textNome = new javax.swing.JTextField();
        textPorta = new javax.swing.JTextField();
        statusBar = new org.jdesktop.swingx.JXStatusBar();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        botaoSair = new javax.swing.JButton();
        labelComunidadeEscrita = new org.jdesktop.swingx.JXLabel();
        textComunidadeEscrita = new javax.swing.JTextField();
        textComunidadeLeitura = new javax.swing.JTextField();
        labelComunidadeLeitura = new org.jdesktop.swingx.JXLabel();
        labelTimeout = new org.jdesktop.swingx.JXLabel();
        textTimeout = new javax.swing.JTextField();
        labelRetries = new org.jdesktop.swingx.JXLabel();
        textRetries = new javax.swing.JTextField();
        labelIP = new org.jdesktop.swingx.JXLabel();
        comboEquipamentos = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        botaoRecarregar = new javax.swing.JButton();
        enderecoIP = new desview.util.IPAddress();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowSize(6);
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        label.setBorder(dropShadowBorder1);
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText(" Update  Equipment:");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 10, 400, -1));

        labelEscolha.setText("Choose equipment:");
        getContentPane().add(labelEscolha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, -1));

        labelNome.setText("Name:");
        getContentPane().add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, -1));

        labelPorta.setText("Port:");
        getContentPane().add(labelPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 130, -1));

        btAtualizar.setText("Update");
        btAtualizar.setToolTipText("Update the equipment");
        btAtualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 100, -1));

        btCancelar.setText("Clear fields");
        btCancelar.setToolTipText("Clear the text fields");
        btCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 90, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        textNome.setBorder(dropShadowBorder2);
        getContentPane().add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 220, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder3.setShowBottomShadow(false);
        dropShadowBorder3.setShowRightShadow(false);
        textPorta.setBorder(dropShadowBorder3);
        getContentPane().add(textPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 90, -1));

        statusBar.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        statusBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busy.setText("Ready");
        statusBar.add(busy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 460, 30));

        getContentPane().add(statusBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 500, 40));

        botaoSair.setText("Close");
        botaoSair.setToolTipText("Close this window");
        botaoSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 80, -1));

        labelComunidadeEscrita.setText("Write community:");
        getContentPane().add(labelComunidadeEscrita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder4.setShowBottomShadow(false);
        dropShadowBorder4.setShowRightShadow(false);
        textComunidadeEscrita.setBorder(dropShadowBorder4);
        getContentPane().add(textComunidadeEscrita, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 220, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder5 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder5.setShowBottomShadow(false);
        dropShadowBorder5.setShowRightShadow(false);
        textComunidadeLeitura.setBorder(dropShadowBorder5);
        getContentPane().add(textComunidadeLeitura, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 220, -1));

        labelComunidadeLeitura.setText("Read community:");
        getContentPane().add(labelComunidadeLeitura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 170, -1));

        labelTimeout.setText("Timeout:");
        getContentPane().add(labelTimeout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 130, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder6 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder6.setShowBottomShadow(false);
        dropShadowBorder6.setShowRightShadow(false);
        textTimeout.setBorder(dropShadowBorder6);
        getContentPane().add(textTimeout, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 90, -1));

        labelRetries.setText("Retries:");
        getContentPane().add(labelRetries, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 130, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder7 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder7.setShowBottomShadow(false);
        dropShadowBorder7.setShowRightShadow(false);
        textRetries.setBorder(dropShadowBorder7);
        getContentPane().add(textRetries, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 90, -1));

        labelIP.setText("IP:");
        getContentPane().add(labelIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 130, -1));

        comboEquipamentos.setModel(comboModel);
        comboEquipamentos.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        comboEquipamentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEquipamentosItemStateChanged(evt);
            }
        });
        getContentPane().add(comboEquipamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 230, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 470, 10));

        botaoRecarregar.setText("Refresh");
        botaoRecarregar.setToolTipText("Refresh the data in combobox");
        botaoRecarregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRecarregarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRecarregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 110, -1));
        getContentPane().add(enderecoIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        botaoSalvarEvento();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        botaoCancelarEvento();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void comboEquipamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEquipamentosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Equipment e = (Equipment) this.comboEquipamentos.getSelectedItem();
            this.currentEquipmentID = e.getId();
            this.enderecoIP.setIp(e.getIP());
            this.textNome.setText(e.getName());
            this.textPorta.setText(e.getPort());
            this.textTimeout.setText(e.getTimeout());
            this.textComunidadeEscrita.setText(e.getWriteCommunity());
            this.textComunidadeLeitura.setText(e.getReadCommunity());
            this.textRetries.setText(e.getRetries());
        }
    }//GEN-LAST:event_comboEquipamentosItemStateChanged

    private void botaoRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRecarregarActionPerformed
        recarregaDadosCombo();
    }//GEN-LAST:event_botaoRecarregarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoRecarregar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCancelar;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JComboBox comboEquipamentos;
    private desview.util.IPAddress enderecoIP;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXLabel label;
    private org.jdesktop.swingx.JXLabel labelComunidadeEscrita;
    private org.jdesktop.swingx.JXLabel labelComunidadeLeitura;
    private org.jdesktop.swingx.JXLabel labelEscolha;
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
        this.equipmentIp = this.enderecoIP.getIp();
        this.equipmentName = this.textNome.getText();
        this.equipmentTimeout = this.textTimeout.getText();
        this.equipmentRetries = this.textRetries.getText();
        this.writeCommunity = this.textComunidadeEscrita.getText();
        this.readCommunity = this.textComunidadeLeitura.getText();
        this.equipmentPort = this.textPorta.getText();

        equipments = this.equipmentControl.getEquipments();

        for (Equipment e : equipments) {
            this.comboModel.addElement(e);
        }
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
            if (equipmentName.equals("")) {
                setBusy(false, "Equipment name is mandatory", 0, Color.red);
                textNome.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
            } else {
                setBusy(true, "Updating", 100, Color.black);
                repaint();
                DropShadowBorder drop = new DropShadowBorder();
                drop.setShowBottomShadow(false);
                drop.setShowRightShadow(false);
                textNome.setBorder(drop);
                Equipment newEquipment = new Equipment();
                newEquipment.setIP(equipmentIp);
                newEquipment.setName(equipmentName);
                newEquipment.setReadCommunity(readCommunity);
                newEquipment.setWriteCommunity(writeCommunity);
                newEquipment.setPort(equipmentPort);
                newEquipment.setTimeout(equipmentTimeout);
                newEquipment.setRetries(equipmentRetries);
                newEquipment.setId(currentEquipmentID);
                equipmentControl.setEquipment(newEquipment);
                equipmentControl.update();
                this.recarregaDadosCombo();
                setBusy(false, "Ready", 0, Color.black);
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

    private void recarregaDadosCombo() {
        equipments = this.equipmentControl.getEquipments();
        this.comboModel.removeAllElements();
        for (Equipment e : equipments) {
            this.comboModel.addElement(e);
        }
    }
}
