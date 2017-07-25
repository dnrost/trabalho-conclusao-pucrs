package desview.view.components;

import desview.controller.EquipmentControl;
import desview.model.entities.Equipment;
import desview.util.Message;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.JXBusyLabel.Direction;
import org.jdesktop.swingx.JXFrame;

/**
 * This class is a window to delete an equipment.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 27/05/2010.
 */
public class EquipmentDelete extends JXFrame {

    private static final long serialVersionUID = 3793524834515l;
    private String nomeEquipamento;
    private String ipEquipamento;
    private String portaEquipamento;
    private EquipmentControl controleEquipamento = new EquipmentControl();
    private DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    private List<Equipment> listaEquipamentos;
    private Long idEquipamentoAtual;

    /**
     * Constructor of class.
     */
    public EquipmentDelete() {
        super("Desview: Delete equipment");
        initComponents();
        textPorta.setEditable(false);
        textNome.setEditable(false);
        enderecoIP.setEditable(false);
        relacionaDados();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new org.jdesktop.swingx.JXLabel();
        labelEscolha = new org.jdesktop.swingx.JXLabel();
        labelNome = new org.jdesktop.swingx.JXLabel();
        labelPorta = new org.jdesktop.swingx.JXLabel();
        textNome = new javax.swing.JTextField();
        textPorta = new javax.swing.JTextField();
        statusBar = new org.jdesktop.swingx.JXStatusBar();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        botaoSair = new javax.swing.JButton();
        labelIP = new org.jdesktop.swingx.JXLabel();
        comboEquipamentos = new javax.swing.JComboBox();
        botaoRecarregar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        enderecoIP = new desview.util.IPAddress();
        separador = new org.jdesktop.swingx.JXTitledSeparator();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowSize(6);
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        label.setBorder(dropShadowBorder1);
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Delete  Equipment:");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 10, 400, -1));

        labelEscolha.setText("Choose equipment:");
        getContentPane().add(labelEscolha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 160, 20));

        labelNome.setText("Name:");
        getContentPane().add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, -1));

        labelPorta.setText("Port:");
        getContentPane().add(labelPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 134, 60, 20));

        textNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        getContentPane().add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 220, -1));

        textPorta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        getContentPane().add(textPorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 90, 20));

        statusBar.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        statusBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busy.setText("Ready");
        statusBar.add(busy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 450, 30));

        getContentPane().add(statusBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 470, 40));

        botaoSair.setText("Close");
        botaoSair.setToolTipText("Close this window");
        botaoSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 80, -1));

        labelIP.setText("IP:");
        getContentPane().add(labelIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 50, -1));

        comboEquipamentos.setModel(modeloCombo);
        comboEquipamentos.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        comboEquipamentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEquipamentosItemStateChanged(evt);
            }
        });
        getContentPane().add(comboEquipamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 230, -1));

        botaoRecarregar.setText("Refresh");
        botaoRecarregar.setToolTipText("Refresh the data in combobox");
        botaoRecarregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRecarregarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRecarregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 90, -1));

        btExcluir.setText("Delete");
        btExcluir.setToolTipText("Delete the selected equipment");
        btExcluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 90, -1));
        getContentPane().add(enderecoIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        separador.setTitle("Selected equipment details");
        getContentPane().add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 470, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void comboEquipamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEquipamentosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Equipment e = (Equipment) this.comboEquipamentos.getSelectedItem();
            this.idEquipamentoAtual = e.getId();
            this.enderecoIP.setIp(e.getIP());
            this.textNome.setText(e.getName());
            this.textPorta.setText(e.getPort());
        }
    }//GEN-LAST:event_comboEquipamentosItemStateChanged

    private void botaoRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRecarregarActionPerformed
        recarregaDadosCombo();
    }//GEN-LAST:event_botaoRecarregarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        this.excluirEquipamento();
}//GEN-LAST:event_btExcluirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoRecarregar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton btExcluir;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JComboBox comboEquipamentos;
    private desview.util.IPAddress enderecoIP;
    private org.jdesktop.swingx.JXLabel label;
    private org.jdesktop.swingx.JXLabel labelEscolha;
    private org.jdesktop.swingx.JXLabel labelIP;
    private org.jdesktop.swingx.JXLabel labelNome;
    private org.jdesktop.swingx.JXLabel labelPorta;
    private org.jdesktop.swingx.JXTitledSeparator separador;
    private org.jdesktop.swingx.JXStatusBar statusBar;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textPorta;
    // End of variables declaration//GEN-END:variables

    private void relacionaDados() {
        this.ipEquipamento = this.enderecoIP.getIp();
        this.nomeEquipamento = this.textNome.getText();
        this.portaEquipamento = this.textPorta.getText();
        listaEquipamentos = this.controleEquipamento.getEquipments();
        for (Equipment e : listaEquipamentos) {
            this.modeloCombo.addElement(e);
        }
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
        listaEquipamentos = this.controleEquipamento.getEquipments();
        this.modeloCombo.removeAllElements();
        for (Equipment e : listaEquipamentos) {
            this.modeloCombo.addElement(e);
        }
    }

    private void excluirEquipamento() {
        Equipment e = (Equipment) this.comboEquipamentos.getSelectedItem();
        this.idEquipamentoAtual = e.getId();
        setBusy(true, "Waiting...", 100, Color.black);
        boolean r = Message.question(null, "Delete", "Do you want to delete the Equipment?");
        if (r) {
            this.controleEquipamento.delete(e);
            this.recarregaDadosCombo();
            setBusy(false, "Equipment successfully deleted", 0, Color.black);
        } else {
            this.recarregaDadosCombo();
        }
    }
}
