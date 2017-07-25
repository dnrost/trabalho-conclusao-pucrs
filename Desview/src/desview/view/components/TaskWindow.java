package desview.view.components;

import desview.controller.EquipmentControl;
import desview.controller.TaskControl;
import desview.controller.VariableControl;
import desview.controller.snmp.Leaf;
import desview.controller.snmp.XMLReader;
import desview.model.entities.Equipment;
import desview.model.entities.Task;
import desview.model.entities.Variable;
import desview.model.enums.VariableAccessType;
import desview.model.enums.VariableType;
import desview.util.Message;
import desview.util.Util;
import desview.view.VariableDataWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.jdesktop.swingx.JXBusyLabel.Direction;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXTree;
import org.jdesktop.swingx.border.DropShadowBorder;

/**
 * This class creates a new task and edits an existing task.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 10/04/2010.
 */
public class TaskWindow extends JXFrame {

    private static final long serialVersionUID = 34413640153l;
    private String XML = "mibs/RFC1213-MIB.xml";
    private XMLReader arvore;
    private DefaultMutableTreeNode dmtn;
    private JPopupMenu popup, popupLista;
    private DefaultListModel modeloLista;
    private DefaultComboBoxModel modeloCombo;
    private SpinnerModel modeloHoraInicio;
    private SpinnerModel modeloHoraFim;
    private SpinnerModel modeloHoraFrequencia;
    private SpinnerModel modeloMinutoInicio;
    private SpinnerModel modeloMinutoFim;
    private SpinnerModel modeloSegundoInicio;
    private SpinnerModel modeloSegundoFim;
    private SpinnerModel modeloMinutoFrequencia;
    private SpinnerModel modeloSegundoFrequencia;
    private EquipmentControl controleEquipamento;
    private String nomeTarefa;
    private Equipment equipamento;
    private TaskControl controleTarefa;
    private VariableControl controleVariavel;
    private JMenuItem remover, removerTodos, thresholds, visualizarInfo;
    private String dataInicio, dataFim, frequencia;
    private Integer auxiliarFrequencia;
    private int type; //0 is insert, 1 is edit
    private Task selectedTaskEdit;
    private String OS; //the current operating system.

    /**
     * Construtor da Janela de novo monitoramento.
     * @param title the window title
     * @param type the type of crud -> 0 for insert, 1 for update.
     */
    public TaskWindow(String title, int type) {
        super(title);
        if (type == 0 || type == 1) {
            this.type = type;
        } else { //setting to 0.
            this.type = 0;
        }
        iniciaPrimeirosComponentes();
        initComponents();
        verifySO();
        centralizaJanela();
        postInitComponents();
        relacionaDados();
        this.setResizable(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        painel = new org.jdesktop.swingx.JXPanel();
        scrollTree = new javax.swing.JScrollPane();
        tree = new org.jdesktop.swingx.JXTree();
        labelWhat = new org.jdesktop.swingx.JXLabel();
        labelNome = new org.jdesktop.swingx.JXLabel();
        textNome = new javax.swing.JTextField();
        labelEquipamento = new org.jdesktop.swingx.JXLabel();
        labelVariaveis = new org.jdesktop.swingx.JXLabel();
        labelDataInicio = new javax.swing.JLabel();
        dataInicioChooser = new datechooser.beans.DateChooserCombo();
        labelDataFim = new javax.swing.JLabel();
        dataFimChooser = new datechooser.beans.DateChooserCombo();
        labelHorarioInicio = new javax.swing.JLabel();
        spinnerHoraInicio = new javax.swing.JSpinner();
        spinnerMinutoInicio = new javax.swing.JSpinner();
        spinnerSegundoInicio = new javax.swing.JSpinner();
        labelHorarioFim = new javax.swing.JLabel();
        spinnerHoraFim = new javax.swing.JSpinner();
        spinnerMinutoFim = new javax.swing.JSpinner();
        spinnerSegundoFim = new javax.swing.JSpinner();
        labelFrequencia = new javax.swing.JLabel();
        labelFim = new javax.swing.JLabel();
        radioDefinido = new javax.swing.JRadioButton();
        radioInfinito = new javax.swing.JRadioButton();
        spinnerFrequenciaHora = new javax.swing.JSpinner();
        spinnerFrequenciaMinuto = new javax.swing.JSpinner();
        spinnerFrequenciaSegundo = new javax.swing.JSpinner();
        status = new org.jdesktop.swingx.JXStatusBar();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        botaoSalvar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        scrollLista = new javax.swing.JScrollPane();
        lista = new org.jdesktop.swingx.JXList();
        comboEquipamentos = new javax.swing.JComboBox();
        botaoRemover = new javax.swing.JButton();
        botaoInserir = new javax.swing.JButton();
        botaoThresholds1 = new javax.swing.JButton();
        botaoThresholds2 = new javax.swing.JButton();
        botaoVisualizar = new javax.swing.JButton();
        botaoLimparCampos = new javax.swing.JButton();
        label3 = new org.jdesktop.swingx.JXLabel();
        label1 = new org.jdesktop.swingx.JXLabel();
        label2 = new org.jdesktop.swingx.JXLabel();
        btRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painel.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        scrollTree.setViewportView(tree);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTree, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTree, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 470));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        labelWhat.setBorder(dropShadowBorder1);
        labelWhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWhat.setText("Fill the following fields to create a new task:");
        getContentPane().add(labelWhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 360, -1));

        labelNome.setText("Task name:");
        getContentPane().add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 100, -1));
        getContentPane().add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 50, 360, -1));

        labelEquipamento.setText("Equipment:");
        getContentPane().add(labelEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 100, -1));

        labelVariaveis.setText("Variables:");
        getContentPane().add(labelVariaveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 65, -1));

        labelDataInicio.setText("Start date:");
        getContentPane().add(labelDataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 236, -1, -1));
        getContentPane().add(dataInicioChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 230, -1, -1));

        labelDataFim.setText("End date:");
        getContentPane().add(labelDataFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 322, -1, -1));
        getContentPane().add(dataFimChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 316, -1, -1));

        labelHorarioInicio.setText("Start time:");
        getContentPane().add(labelHorarioInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 264, -1, -1));

        spinnerHoraInicio.setModel(modeloHoraInicio);
        getContentPane().add(spinnerHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 37, -1));

        spinnerMinutoInicio.setModel(modeloMinutoInicio);
        getContentPane().add(spinnerMinutoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 37, -1));

        spinnerSegundoInicio.setModel(modeloSegundoInicio
        );
        getContentPane().add(spinnerSegundoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 37, -1));

        labelHorarioFim.setText("End time:");
        getContentPane().add(labelHorarioFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 350, -1, -1));

        spinnerHoraFim.setModel(modeloHoraFim);
        getContentPane().add(spinnerHoraFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 37, -1));

        spinnerMinutoFim.setModel(modeloMinutoFim);
        getContentPane().add(spinnerMinutoFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 37, -1));

        spinnerSegundoFim.setModel(modeloSegundoFim);
        getContentPane().add(spinnerSegundoFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 37, -1));

        labelFrequencia.setText("Frequency:");
        getContentPane().add(labelFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 391, -1, -1));

        labelFim.setText("End:");
        getContentPane().add(labelFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 295, -1, -1));

        grupo.add(radioDefinido);
        radioDefinido.setText("Defined");
        radioDefinido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDefinidoActionPerformed(evt);
            }
        });
        getContentPane().add(radioDefinido, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 291, -1, -1));

        grupo.add(radioInfinito);
        radioInfinito.setText("Infinity");
        radioInfinito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioInfinitoActionPerformed(evt);
            }
        });
        getContentPane().add(radioInfinito, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 291, -1, -1));

        spinnerFrequenciaHora.setModel(modeloHoraFrequencia);
        getContentPane().add(spinnerFrequenciaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 37, -1));

        spinnerFrequenciaMinuto.setModel(modeloMinutoFrequencia);
        getContentPane().add(spinnerFrequenciaMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 37, -1));

        spinnerFrequenciaSegundo.setModel(modeloSegundoFrequencia);
        getContentPane().add(spinnerFrequenciaSegundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 40, -1));

        status.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        status.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busy.setText("Ready");
        status.add(busy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 840, 39));

        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 543, 860, 47));

        botaoSalvar.setText("Save");
        botaoSalvar.setToolTipText("Save the task");
        botaoSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 120, -1));

        botaoFechar.setText("Close");
        botaoFechar.setToolTipText("Close this window");
        botaoFechar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });
        getContentPane().add(botaoFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 100, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        lista.setBorder(dropShadowBorder2);
        lista.setModel(modeloLista);
        scrollLista.setViewportView(lista);

        getContentPane().add(scrollLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 119, 330, 100));

        comboEquipamentos.setModel(modeloCombo);
        comboEquipamentos.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        getContentPane().add(comboEquipamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 80, 360, -1));

        botaoRemover.setText("Remove");
        botaoRemover.setToolTipText("Remove the selected variable");
        botaoRemover.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 100, -1));

        botaoInserir.setText("Insert");
        botaoInserir.setToolTipText("Insert variable in the task");
        botaoInserir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInserirActionPerformed(evt);
            }
        });
        getContentPane().add(botaoInserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 70, -1));

        botaoThresholds1.setText("Thresholds");
        botaoThresholds1.setToolTipText("Insert Thresholds");
        botaoThresholds1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoThresholds1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoThresholds1ActionPerformed(evt);
            }
        });
        getContentPane().add(botaoThresholds1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 80, -1));

        botaoThresholds2.setText("Thresholds");
        botaoThresholds2.setToolTipText("Insert Thresholds");
        botaoThresholds2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoThresholds2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoThresholds2ActionPerformed(evt);
            }
        });
        getContentPane().add(botaoThresholds2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 100, -1));

        botaoVisualizar.setText("View");
        botaoVisualizar.setToolTipText("View information about the selected variable");
        botaoVisualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVisualizarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(743, 200, 100, -1));

        botaoLimparCampos.setText("Clear fields");
        botaoLimparCampos.setToolTipText("Clear text fields");
        botaoLimparCampos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparCamposActionPerformed(evt);
            }
        });
        getContentPane().add(botaoLimparCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 120, -1));

        label3.setText("hh:mm:ss");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, -1, -1));

        label1.setText("hh:mm:ss");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        label2.setText("hh:mm:ss");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, -1, -1));

        btRefresh.setText("Refresh");
        btRefresh.setToolTipText("Refresh data in screen");
        btRefresh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        boolean q = Message.question(null, "Exit", "Do you want to exit and do not save?");
        if (q) {
            dispose();
        }
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        if (type == 0) {
            createTask();
        } else if (type == 1) {
            updateTask();
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void radioDefinidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDefinidoActionPerformed
        if (radioDefinido.isSelected()) {
            labelDataFim.setEnabled(true);
            dataFimChooser.setEnabled(true);
            labelHorarioFim.setEnabled(true);
            spinnerHoraFim.setEnabled(true);
            spinnerMinutoFim.setEnabled(true);
            spinnerSegundoFim.setEnabled(true);
        }
    }//GEN-LAST:event_radioDefinidoActionPerformed

    private void radioInfinitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioInfinitoActionPerformed
        if (radioInfinito.isSelected()) {
            labelDataFim.setEnabled(false);
            dataFimChooser.setEnabled(false);
            labelHorarioFim.setEnabled(false);
            spinnerHoraFim.setEnabled(false);
            spinnerMinutoFim.setEnabled(false);
            spinnerSegundoFim.setEnabled(false);
        }
    }//GEN-LAST:event_radioInfinitoActionPerformed

    private void botaoInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInserirActionPerformed
        insere();
    }//GEN-LAST:event_botaoInserirActionPerformed

    private void botaoThresholds1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoThresholds1ActionPerformed
        insereSetThresholds();
    }//GEN-LAST:event_botaoThresholds1ActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        removerVariavel();
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void botaoThresholds2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoThresholds2ActionPerformed
        Variable v = (Variable) lista.getSelectedValue();
        setThresholds(v);
    }//GEN-LAST:event_botaoThresholds2ActionPerformed

    private void botaoVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVisualizarActionPerformed
        Variable v = (Variable) lista.getSelectedValue();
        visualizarInformacoesVariavel(v, true);
    }//GEN-LAST:event_botaoVisualizarActionPerformed

    private void botaoLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparCamposActionPerformed
        setComponentesVisuais();
        repaint();
    }//GEN-LAST:event_botaoLimparCamposActionPerformed

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        recarregaDadosCombo();
    }//GEN-LAST:event_btRefreshActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JButton botaoLimparCampos;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoThresholds1;
    private javax.swing.JButton botaoThresholds2;
    private javax.swing.JButton botaoVisualizar;
    private javax.swing.JButton btRefresh;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JComboBox comboEquipamentos;
    private datechooser.beans.DateChooserCombo dataFimChooser;
    private datechooser.beans.DateChooserCombo dataInicioChooser;
    private javax.swing.ButtonGroup grupo;
    private org.jdesktop.swingx.JXLabel label1;
    private org.jdesktop.swingx.JXLabel label2;
    private org.jdesktop.swingx.JXLabel label3;
    private javax.swing.JLabel labelDataFim;
    private javax.swing.JLabel labelDataInicio;
    private org.jdesktop.swingx.JXLabel labelEquipamento;
    private javax.swing.JLabel labelFim;
    private javax.swing.JLabel labelFrequencia;
    private javax.swing.JLabel labelHorarioFim;
    private javax.swing.JLabel labelHorarioInicio;
    private org.jdesktop.swingx.JXLabel labelNome;
    private org.jdesktop.swingx.JXLabel labelVariaveis;
    private org.jdesktop.swingx.JXLabel labelWhat;
    private org.jdesktop.swingx.JXList lista;
    private org.jdesktop.swingx.JXPanel painel;
    private javax.swing.JRadioButton radioDefinido;
    private javax.swing.JRadioButton radioInfinito;
    private javax.swing.JScrollPane scrollLista;
    private javax.swing.JScrollPane scrollTree;
    private javax.swing.JSpinner spinnerFrequenciaHora;
    private javax.swing.JSpinner spinnerFrequenciaMinuto;
    private javax.swing.JSpinner spinnerFrequenciaSegundo;
    private javax.swing.JSpinner spinnerHoraFim;
    private javax.swing.JSpinner spinnerHoraInicio;
    private javax.swing.JSpinner spinnerMinutoFim;
    private javax.swing.JSpinner spinnerMinutoInicio;
    private javax.swing.JSpinner spinnerSegundoFim;
    private javax.swing.JSpinner spinnerSegundoInicio;
    private org.jdesktop.swingx.JXStatusBar status;
    private javax.swing.JTextField textNome;
    private org.jdesktop.swingx.JXTree tree;
    // End of variables declaration//GEN-END:variables

    private void postInitComponents() {
        if (type == 0) { //insert
            botaoSalvar.setText("Save");
            botaoSalvar.setToolTipText("Save the task");
        } else if (type == 1) {
            botaoSalvar.setText("Update");
            botaoSalvar.setToolTipText("Update the task");
        }
        tree = new JXTree(dmtn, false);
        scrollTree.setViewportView(tree);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(false);
        tree.setRootVisible(false);

        JMenuItem mi = new JMenuItem("Insert");
        mi.addActionListener(new popMenuArvore());
        mi.setActionCommand("inserir");
        popup.add(mi);
        mi = new JMenuItem("Insert & Thresholds");
        mi.addActionListener(new popMenuArvore());
        mi.setActionCommand("inserirethresolhods");
        popup.add(mi);
        mi = new JMenuItem("View info");
        mi.addActionListener(new popMenuArvore());
        mi.setActionCommand("viewinfo");
        popup.add(mi);
        popup.setOpaque(true);
        popup.setLightWeightPopupEnabled(true);
        if (OS.contains("Linux")) {
            tree.addMouseListener(
                    new MouseAdapter() {

                        private boolean isTriggered = false;

                        @Override
                        public void mousePressed(MouseEvent e) {
                            if (isTriggered = e.isPopupTrigger()) {
                                popup.show((JComponent) e.getSource(), e.getX(), e.getY());
                                repaint();
                            }
                        }

                        @Override
                        public void mouseReleased(MouseEvent me) {
                            isTriggered = false;
                            repaint();
                        }
                    });
        } else if (OS.contains("Windows")) {
            tree.addMouseListener(
                    new MouseAdapter() {

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            if (e.isPopupTrigger()) {
                                popup.show((JComponent) e.getSource(), e.getX(), e.getY());
                            }
                        }
                    });
        }
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode nodo_arvore = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (nodo_arvore == null) {
                    return;
                }
            }
        });
        radioDefinido.setSelected(true);

        List<Equipment> listaEquipamentos = this.controleEquipamento.getEquipments();
        try {
            for (Equipment e : listaEquipamentos) {
                this.modeloCombo.addElement(e);
            }
        } catch (NullPointerException ex) {
            Message.warning(null, "None Equipment", "Please insert equipments before create a task.");
        }

        //insert menus lista

        lista.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                // if right mouse button clicked (or me.isPopupTrigger())
                if (SwingUtilities.isRightMouseButton(me)
                        && !lista.isSelectionEmpty()
                        && lista.locationToIndex(me.getPoint())
                        == lista.getSelectedIndex()) {
                    popupLista.show(lista, me.getX(), me.getY());
                }
            }
        });

        popupLista.add(remover = new JMenuItem("Remove selected"));
        // popupLista.add(removerTodos = new JMenuItem("Remover todos"));
        popupLista.add(new JPopupMenu.Separator());
        popupLista.add(thresholds = new JMenuItem("Change thresholds"));
        popupLista.add(visualizarInfo = new JMenuItem("View data"));

        remover.addActionListener(new popMenuLista());
        //removerTodos.addActionListener(new popMenuLista());
        thresholds.addActionListener(new popMenuLista());
        visualizarInfo.addActionListener(new popMenuLista());
    }

    private void createTask() {
        relacionaDados();
        if (nomeTarefa.equals("")) {
            textNome.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
            setBusy(false, "Task name is mandatory", 0, Color.red);
        } else if (auxiliarFrequencia < 5) {
            StringBuilder s = new StringBuilder();
            s.append("Frequency interval is not valid: ");
            s.append(auxiliarFrequencia);
            setBusy(false, s.toString(), 0, Color.red);
        } else if (auxiliarFrequencia % 5 != 0) {
            StringBuilder s = new StringBuilder();
            s.append("Frequency interval is is not a 5 seconds remainder: ");
            s.append(auxiliarFrequencia);
            setBusy(false, s.toString(), 0, Color.red);
        } else {//continuar verificaçao com outros
            setBusy(true, "Inserting", 50, Color.black);
            StringBuffer b = new StringBuffer();
            DropShadowBorder drop = new DropShadowBorder();
            drop.setShowBottomShadow(false);
            drop.setShowRightShadow(false);
            textNome.setBorder(drop);

            Task tarefa = new Task();
            tarefa.setEquipment(equipamento);
            tarefa.setNameTask(nomeTarefa);

            //---- seta tarefa ---
            tarefa.setEstimatedStartDate(dataInicio);
            tarefa.setEstimatedEndDate(dataFim);
            tarefa.setFrequency(frequencia);

            tarefa.setFrequencyAuxiliary(String.valueOf(auxiliarFrequencia));
            tarefa.setVolatileFrequency(String.valueOf(auxiliarFrequencia));

            DefaultListModel dlm = (DefaultListModel) lista.getModel();
            List<Variable> var = new ArrayList<Variable>();
            for (int i = 0; i < dlm.getSize(); i++) {
                Variable v = (Variable) dlm.get(i);
                var.add(v);
            }
            tarefa.setVariables(var);
            controleTarefa.setTask(tarefa);
            if (controleTarefa.insert()) {
                b.append("Task ").append(tarefa.getTaskName()).append(" was succesfully inserted!");
                Message.information(null, "Task", b.toString());
                this.dispose();
            } else {
                b.append("Problem inserting task: ").append(tarefa.getTaskName()).append("!");
                setBusy(false, b.toString(), 0, Color.red);
            }
        }
    }

    private void iniciaPrimeirosComponentes() {
        arvore = new XMLReader(XML, new DefaultMutableTreeNode("."));
        dmtn = arvore.buildTreeFromXML();
        popup = new JPopupMenu();
        popupLista = new JPopupMenu();
        modeloLista = new DefaultListModel();
        modeloCombo = new DefaultComboBoxModel();
        //valores do spinnermodel sao valor inicial, min, max e step
        modeloHoraInicio = new SpinnerNumberModel(0, 0, 23, 1);
        modeloHoraFim = new SpinnerNumberModel(0, 0, 23, 1);
        modeloHoraFrequencia = new SpinnerNumberModel(0, 0, 23, 1);
        modeloMinutoInicio = new SpinnerNumberModel(0, 0, 59, 1);
        modeloMinutoFim = new SpinnerNumberModel(0, 0, 59, 1);
        modeloSegundoInicio = new SpinnerNumberModel(0, 0, 59, 1);
        modeloSegundoFim = new SpinnerNumberModel(0, 0, 59, 1);
        modeloMinutoFrequencia = new SpinnerNumberModel(0, 0, 59, 1);
        modeloSegundoFrequencia = new SpinnerNumberModel(5, 0, 59, 5);
        controleEquipamento = new EquipmentControl();
        controleTarefa = new TaskControl();
        controleVariavel = new VariableControl();
    }

    private void setBusy(boolean b, String texto, int delay, Color cor) {
        busy.setBusy(b);
        busy.setText(texto);
        busy.setDelay(delay);
        busy.setForeground(cor);
        busy.setDirection(Direction.LEFT);
    }

    private void verifySO() {
        this.OS = Util.OS;
        if (OS.contains("Linux") || OS.contains("Windows")) {
            botaoInserir.setVisible(true);
            botaoThresholds2.setVisible(true);
            botaoRemover.setVisible(true);
            botaoThresholds1.setVisible(true);
            botaoVisualizar.setVisible(true);
            // } else if (OS.contains("Windows")) {
            // botaoLinuxInserir.setVisible(false);
            // botaoLinuxThresholds2.setVisible(false);
            // botaoLinuxRemover.setVisible(false);
            // botaoLinuxThresholds1.setVisible(false);
            // botaoLinuxVisualizar.setVisible(false);
        } else {
            Message.warning(null, "Operating system", "This program may not run rightly in your operating system!");
        }
    }

    private class popMenuLista implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == remover) {
                // remover selecionado
                removerVariavel();
            } else if (e.getSource() == removerTodos) { //nao usado
                // limpar todos
                DefaultListModel dlm = (DefaultListModel) lista.getModel();
                dlm.removeAllElements();
                lista.setModel(dlm);
            } else if (e.getSource() == thresholds) {
                Variable v = (Variable) lista.getSelectedValue();
                setThresholds(v);
            } else if (e.getSource() == visualizarInfo) {
                Variable v = (Variable) lista.getSelectedValue();
                visualizarInformacoesVariavel(v, true);
            }
        }
    }

    private class popMenuArvore implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            TreePath path = tree.getSelectionPath();
            dmtn = (DefaultMutableTreeNode) path.getLastPathComponent();
            if (ae.getActionCommand().equals("inserir")) {
                insere();
            }
            if (ae.getActionCommand().equals("inserirethresolhods")) {
                insereSetThresholds();
            }
            if (ae.getActionCommand().equals("viewinfo")) {
                Variable v = getSelected();
                if (v != null) {
                    visualizarInformacoesVariavel(v, false);
                }
            }
        }
    }

    private void removerVariavel() {
        DefaultListModel dlm = (DefaultListModel) lista.getModel();
        Variable v = (Variable) lista.getSelectedValue();
        dlm.removeElement(v);
        controleVariavel.setVariable(v);
        controleVariavel.delete();
    }

    private void insere() {
        DefaultMutableTreeNode selecionado = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selecionado == null) {
            return;
        }
        Leaf nodo = (Leaf) selecionado.getUserObject();
        String nome, oid, acesso, descricao, tipo;
        nome = nodo.getName();
        oid = nodo.getOid();
        acesso = nodo.getAccess();
        descricao = nodo.getDescription();
        tipo = nodo.getType();
        if (!oid.equals("")) {
            Variable variavel = new Variable();
            variavel.setOid(oid);
            variavel.setLabel(nome);
            variavel.setDescription(descricao);
            //TODO: deixar estatico?
            variavel.setAccess(VariableAccessType.READ_WRITE);
            variavel.setType(VariableType.INTEGER);
            controleVariavel.setVariable(variavel);
            controleVariavel.insert();
            modeloLista.addElement(variavel);
            lista.setModel(modeloLista);
        }
        ((DefaultTreeModel) tree.getModel()).nodeStructureChanged((TreeNode) dmtn);
    }

    private Variable getSelected() {
        DefaultMutableTreeNode selecionado = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selecionado == null) {
            return null;
        }
        Leaf nodo = (Leaf) selecionado.getUserObject();
        String nome, oid, acesso, descricao, tipo;
        nome = nodo.getName();
        oid = nodo.getOid();
        acesso = nodo.getAccess();
        descricao = nodo.getDescription();
        tipo = nodo.getType();
        Variable variavel = null;
        if (!oid.equals("")) {
            variavel = new Variable();
            variavel.setOid(oid);
            variavel.setLabel(nome);
            variavel.setDescription(descricao);
            //TODO: deixar estatico?
            variavel.setAccess(VariableAccessType.READ_WRITE);
            variavel.setType(VariableType.INTEGER);
        }
        ((DefaultTreeModel) tree.getModel()).nodeStructureChanged((TreeNode) dmtn);
        return variavel;
    }

    private void insereSetThresholds() {
        DefaultMutableTreeNode selecionado = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selecionado == null) {
            return;
        }
        Leaf nodo = (Leaf) selecionado.getUserObject();
        String nome, oid, acesso, descricao, tipo;
        nome = nodo.getName();
        oid = nodo.getOid();
        acesso = nodo.getAccess();
        descricao = nodo.getDescription();
        tipo = nodo.getType();
        if (!oid.equals("")) {
            Variable variavel = new Variable();
            variavel.setOid(oid);
            variavel.setLabel(nome);
            variavel.setDescription(descricao);
            //TODO: deixar estatico?
            variavel.setAccess(VariableAccessType.READ_WRITE);
            variavel.setType(VariableType.INTEGER);
            controleVariavel.setVariable(variavel);
            controleVariavel.insert();
            modeloLista.addElement(variavel);
            lista.setModel(modeloLista);
            //altera os thresolds da variavel.
            setThresholds(variavel);
        }
        ((DefaultTreeModel) tree.getModel()).nodeStructureChanged((TreeNode) dmtn);
    }

    private void setComponentesVisuais() {
        textNome.setText("");
        radioDefinido.setSelected(true);
        spinnerHoraFim.setValue(new Integer(0));
        spinnerMinutoFim.setValue(new Integer(0));
        spinnerSegundoFim.setValue(new Integer(0));
        spinnerHoraInicio.setValue(new Integer(0));
        spinnerMinutoInicio.setValue(new Integer(0));
        spinnerSegundoInicio.setValue(new Integer(0));
        spinnerFrequenciaHora.setValue(new Integer(0));
        spinnerFrequenciaMinuto.setValue(new Integer(0));
        spinnerFrequenciaSegundo.setValue(new Integer(0));
        dataInicioChooser.setSelectedDate(new GregorianCalendar());
        dataFimChooser.setSelectedDate(new GregorianCalendar());
        labelDataFim.setEnabled(true);
        dataFimChooser.setEnabled(true);
        labelHorarioFim.setEnabled(true);
        spinnerHoraFim.setEnabled(true);
        spinnerMinutoFim.setEnabled(true);
        spinnerSegundoFim.setEnabled(true);
    }

    private void setThresholds(Variable variavel) {
        ThresholdsEdit e = new ThresholdsEdit(variavel);
        e.pack();
        e.setVisible(true);
    }

    private void visualizarInformacoesVariavel(Variable variavel, boolean canedit) {
        VariableDataWindow e = new VariableDataWindow(variavel, canedit);
        e.setSize(new Dimension(800, 800));
        e.pack();
        e.setVisible(true);
        e.setTextoOID(variavel.getOid());
        e.setTextoLower(variavel.getLower());
        e.setTextoAcesso(variavel.getAccess().name());
        e.setTextoDescricao(variavel.getDescription());
        e.setTextoRotulo(variavel.getLabel());
        e.setTextoTipo(variavel.getType().name());
        e.setTextoUpper(variavel.getUpper());
        e.setTextoMib(variavel.getMib());
    }

    private void centralizaJanela() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    private void relacionaDados() {
        this.equipamento = (Equipment) this.comboEquipamentos.getSelectedItem();
        this.nomeTarefa = this.textNome.getText();

        //ano, mes, dia, hora, minuto, segundo
        String horaInicio = String.valueOf(this.spinnerHoraInicio.getValue());
        String minutoInicio = String.valueOf(this.spinnerMinutoInicio.getValue());
        String segundoInicio = String.valueOf(this.spinnerSegundoInicio.getValue());
        String anoInicio = String.valueOf(dataInicioChooser.getSelectedDate().get(GregorianCalendar.YEAR));
        String mesInicio = String.valueOf(dataInicioChooser.getSelectedDate().get((GregorianCalendar.MONTH)) + 1);
        String diaInicio = String.valueOf(dataInicioChooser.getSelectedDate().get((GregorianCalendar.DATE)));
        if (mesInicio.length() == 1) {
            mesInicio = "0" + mesInicio;
        }
        if (diaInicio.length() == 1) {
            diaInicio = "0" + diaInicio;
        }
        if (horaInicio.length() == 1) {
            horaInicio = "0" + horaInicio;
        }
        if (minutoInicio.length() == 1) {
            minutoInicio = "0" + minutoInicio;
        }
        if (segundoInicio.length() == 1) {
            segundoInicio = "0" + segundoInicio;
        }

        StringBuffer bufferDataInicial = new StringBuffer();
        bufferDataInicial.append(diaInicio).append("/").append(mesInicio).append("/").append(anoInicio).append(" ").append(horaInicio).append(":").append(minutoInicio).append(":").append(segundoInicio);
        dataInicio = bufferDataInicial.toString();

        if (this.radioDefinido.isSelected()) {
            //ano, mes, dia, hora, minuto, segundo
            String horaFim = String.valueOf(this.spinnerHoraFim.getValue());
            String minutoFim = String.valueOf(this.spinnerMinutoFim.getValue());
            String segundoFim = String.valueOf(this.spinnerSegundoFim.getValue());
            String anoFim = String.valueOf(dataFimChooser.getSelectedDate().get(GregorianCalendar.YEAR));
            String mesFim = String.valueOf(dataFimChooser.getSelectedDate().get((GregorianCalendar.MONTH)) + 1);
            String diaFim = String.valueOf(dataFimChooser.getSelectedDate().get((GregorianCalendar.DATE)));
            if (mesFim.length() == 1) {
                mesFim = "0" + mesFim;
            }
            if (diaFim.length() == 1) {
                diaFim = "0" + diaFim;
            }
            if (horaFim.length() == 1) {
                horaFim = "0" + horaFim;
            }
            if (minutoFim.length() == 1) {
                minutoFim = "0" + minutoFim;
            }
            if (segundoFim.length() == 1) {
                segundoFim = "0" + segundoFim;
            }

            StringBuffer bufferDataFim = new StringBuffer();
            bufferDataFim.append(diaFim).append("/").append(mesFim).append("/").append(anoFim).append(" ").append(horaFim).append(":").append(minutoFim).append(":").append(segundoFim);
            dataFim = bufferDataFim.toString();
        } else { //infinite selected, it work right until 01/01/2020 00:00:00
            StringBuffer bufferDataFim = new StringBuffer();
            bufferDataFim.append("01").append("/").append("12").append("/").append("2019").append(" ").append("23").append(":").append("59").append(":").append("59");
            dataFim = bufferDataFim.toString();
        }

        String horaFrequencia = String.valueOf(this.spinnerFrequenciaHora.getValue());
        String minutoFrequencia = String.valueOf(this.spinnerFrequenciaMinuto.getValue());
        String segundoFrequencia = String.valueOf(this.spinnerFrequenciaSegundo.getValue());

        if (horaFrequencia.length() == 1) {
            horaFrequencia = "0" + horaFrequencia;
        }
        if (minutoFrequencia.length() == 1) {
            minutoFrequencia = "0" + minutoFrequencia;
        }
        if (segundoFrequencia.length() == 1) {
            segundoFrequencia = "0" + segundoFrequencia;
        }
        StringBuffer bufferFrequencia = new StringBuffer();
        bufferFrequencia.append(horaFrequencia).append(":").append(minutoFrequencia).append(":").append(segundoFrequencia);
        frequencia = bufferFrequencia.toString();

        Integer aux = new Integer(0);
        Integer aux1 = (Integer) spinnerFrequenciaSegundo.getValue();
        Integer aux2 = (Integer) spinnerFrequenciaMinuto.getValue();
        Integer aux3 = (Integer) spinnerFrequenciaHora.getValue();
        aux = aux1 + (60 * aux2) + (3600 * aux3);
        auxiliarFrequencia = aux;
    }

    public void fillFields(Equipment equipamento, String nomeTarefa, GregorianCalendar inicio, GregorianCalendar fim, GregorianCalendar frequencia, List<Variable> lista) {
        this.comboEquipamentos.setSelectedItem(equipamento);
        this.textNome.setText(nomeTarefa);
        dataInicioChooser.setSelectedDate(inicio);
        spinnerHoraInicio.setValue(inicio.get(GregorianCalendar.HOUR));
        spinnerMinutoInicio.setValue(inicio.get(GregorianCalendar.MINUTE));
        spinnerSegundoInicio.setValue(inicio.get(GregorianCalendar.SECOND));

        if (fim == null) {//it MUST arrive null here
            radioInfinito.setSelected(true);
            dataFimChooser.setSelectedDate(new GregorianCalendar());
            spinnerHoraFim.setValue(new Integer(0));
            spinnerMinutoFim.setValue(new Integer(0));
            spinnerSegundoFim.setValue(new Integer(0));
            labelDataFim.setEnabled(false);
            dataFimChooser.setEnabled(false);
            labelHorarioFim.setEnabled(false);
            spinnerHoraFim.setEnabled(false);
            spinnerMinutoFim.setEnabled(false);
            spinnerSegundoFim.setEnabled(false);
        } else {
            radioDefinido.setSelected(true);
            dataFimChooser.setSelectedDate(fim);
            spinnerHoraFim.setValue(fim.get(GregorianCalendar.HOUR));
            spinnerMinutoFim.setValue(fim.get(GregorianCalendar.MINUTE));
            spinnerSegundoFim.setValue(fim.get(GregorianCalendar.SECOND));
        }

        this.spinnerFrequenciaHora.setValue(frequencia.get(GregorianCalendar.HOUR));
        this.spinnerFrequenciaMinuto.setValue(frequencia.get(GregorianCalendar.MINUTE));
        this.spinnerFrequenciaSegundo.setValue(frequencia.get(GregorianCalendar.SECOND));
        if (modeloLista.getSize() > 0) {
            modeloLista.removeAllElements();
        }
        for (Variable variavel : lista) {
            modeloLista.addElement(variavel);
        }
        this.lista.setModel(modeloLista);
    }

    public void setLabelWhat(String text) {
        this.labelWhat.setText(text);
        repaint();
    }

    private void recarregaDadosCombo() {
        List<Equipment> listaEquipamentos = this.controleEquipamento.getEquipments();
        this.modeloCombo.removeAllElements();
        for (Equipment e : listaEquipamentos) {
            this.modeloCombo.addElement(e);
        }
    }

    public void setSelectedTaskToEdit(Task task) {
        selectedTaskEdit = task;
    }

    public Task getSelectedTaskToEdit() {
        return selectedTaskEdit;
    }

    private void updateTask() {
        relacionaDados();
        if (nomeTarefa.equals("")) {
            textNome.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
            setBusy(false, "Task name is mandatory", 0, Color.red);
        } else if (auxiliarFrequencia < 5) {
            setBusy(false, "Frequency interval is not valid: " + auxiliarFrequencia, 0, Color.red);
        } else if (auxiliarFrequencia % 5 != 0) {
            setBusy(false, "Frequency interval is 5 seconds", 0, Color.red);
        } else {//continuar verificaçao com outros
            setBusy(true, "Updating", 50, Color.black);
            StringBuffer b = new StringBuffer();
            DropShadowBorder drop = new DropShadowBorder();
            drop.setShowBottomShadow(false);
            drop.setShowRightShadow(false);
            textNome.setBorder(drop);

            Task tarefa = selectedTaskEdit;
            tarefa.setEquipment(equipamento);
            tarefa.setNameTask(nomeTarefa);

            //---- seta tarefa ---
            tarefa.setEstimatedStartDate(dataInicio);
            tarefa.setEstimatedEndDate(dataFim);
            tarefa.setFrequency(frequencia);

            tarefa.setFrequencyAuxiliary(String.valueOf(auxiliarFrequencia));
            tarefa.setVolatileFrequency(String.valueOf(auxiliarFrequencia));

            DefaultListModel dlm = (DefaultListModel) lista.getModel();
            List<Variable> var = new ArrayList<Variable>();
            for (int i = 0; i < dlm.getSize(); i++) {
                Variable v = (Variable) dlm.get(i);
                var.add(v);
            }
            tarefa.setVariables(var);//TODO ver problema no update de tarefas problema esta nas variaveis
            controleTarefa.setTask(tarefa);
            if (controleTarefa.update()) {
                b.append("Task ").append(tarefa.getTaskName()).append(" was succesfully updated!");
                Message.information(null, "Task", b.toString());
                this.dispose();
            } else {
                b.append("Problem updating task: ").append(tarefa.getTaskName()).append("!");
                setBusy(false, b.toString(), 0, Color.red);
            }
        }
    }
}
