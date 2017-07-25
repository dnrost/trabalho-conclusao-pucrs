package desview.view;

import desview.controller.EquipmentControl;
import desview.controller.TaskControl;
import desview.graphics.charts.barchart.BarChart;
import desview.graphics.charts.lines.SelectVariablesLines;
import desview.graphics.charts.polar.DoPolarChart;
import desview.graphics.charts.rt.SelectVariablesRTChart;
import desview.graphics.opengl.lines2D.SelectTasks;
import desview.graphics.opengl.spheres3D.SpheresGraphic;
import desview.graphics.opengl.spiral2D.SelectTasksSpirals;
import desview.model.entities.Equipment;
import desview.model.entities.Task;
import desview.model.entities.Users;
import desview.model.entities.Variable;
import desview.model.enums.TaskStatus;
import desview.util.Message;
import desview.util.Util;
import desview.view.components.EquipmentDelete;
import desview.view.components.EquipmentEdit;
import desview.view.components.EquipmentInsert;
import desview.view.components.Export;
import desview.view.components.MarkVisible;
import desview.view.components.Options;
import desview.view.components.SearchWindow;
import desview.view.components.TaskWindow;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.JXBusyLabel.Direction;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.action.AbstractActionExt;
import org.jdesktop.swingx.border.DropShadowBorder;
import org.jfree.ui.RefineryUtilities;
import org.jouvieje.application.IGLApplication;
import org.jouvieje.application.desktop.Launcher;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;
import org.jouvieje.application.desktop.LauncherSettings;
import org.jouvieje.opengl.GLApiName;

/**
 * This is the main window of the program.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 22/03/2010.
 * @version 1.0
 */
public class MainWindow extends JXFrame {

    private static final long serialVersionUID = 1903521436237l;
    private TabelaTarefa tabelaModelo;
    private TaskControl controleTarefa;
    private DefaultListModel modeloLista;
    private Users user;
    private Integer refreshTime;
    private String[] nomes = new String[]{
        new StringBuilder("ID").toString(),
        new StringBuilder("Name").toString(),
        new StringBuilder("IP").toString(),
        new StringBuilder("Start").toString(),
        new StringBuilder("End").toString(),
        new StringBuilder("Frequency").toString(),
        new StringBuilder("Status").toString()
    };

    /**
     * Constructor of class MainWindow.
     */
    public MainWindow() {
        super("Desview");
        controleTarefa = new TaskControl();
        List<Task> listaInicial = controleTarefa.getTasks();
        List<Task> lista = new ArrayList<Task>();
        for (Task tarefa : listaInicial) {
            if (!tarefa.getStatus().equals(TaskStatus.INVISIBLE)) {
                lista.add(tarefa);
            }
        }
        modeloLista = new DefaultListModel();
        tabelaModelo = new TabelaTarefa(lista, nomes); //lista = ArrayList e nomes = nome das colunas
        initComponents();
        createGraphicsPanel();
        atualiza();
        if (user == null) {
            new AtualizadorJanela(2, (Util.INTERVAL * 6));//realiza o "refresh" da tabela a cada 30 segundos .
        } else {
            new AtualizadorJanela(2, user.getRefreshTime());//realiza o "refresh" da tabela de acordo com o valor setado pelo usuario
        }
        centralizaJanela();
        this.setResizable(false);
    }

    /**
     * This method does the refresh of the window.
     */
    public void atualiza() {
        controleTarefa = new TaskControl();
        try {
            setBusy(true, new StringBuilder("Updated").toString(), 100, Color.black);
            List<Task> listaInicial = controleTarefa.getTasks();
            List<Task> lista = new ArrayList<Task>();
            for (Task tarefa : listaInicial) {
                if (!tarefa.getStatus().equals(TaskStatus.INVISIBLE)) {
                    lista.add(tarefa);
                }
            }
            tabelaModelo = new TabelaTarefa(lista, nomes); //lista = ArrayList e nomes = nome das colunas
            tabela.setModel(tabelaModelo);
            CorTabela renderer = new CorTabela(("Status"));
            for (int i = 0; i < tabela.getColumnCount(); i++) {
                tabela.getColumn(tabela.getColumnName(i)).setCellRenderer(renderer);
            }
            mouseOneClickEvent();
            repaint();
        } catch (Exception e) {
            setBusy(false, "Ooops.. Something went wrong...", 0, Color.red);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new org.jdesktop.swingx.JXStatusBar();
        busy = new org.jdesktop.swingx.JXBusyLabel();
        painelTarefas = new javax.swing.JPanel();
        buttonNew = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        scrollTabela = new javax.swing.JScrollPane();
        tabela = new org.jdesktop.swingx.JXTable();
        editButton = new javax.swing.JButton();
        container = new org.jdesktop.swingx.JXTaskPaneContainer();
        painelDetalhes = new org.jdesktop.swingx.JXPanel();
        scrollVariaveis = new javax.swing.JScrollPane();
        listaVariaveis = new org.jdesktop.swingx.JXList();
        lbNome = new org.jdesktop.swingx.JXLabel();
        textFim = new javax.swing.JTextField();
        lBVariaveisMonitoradas = new org.jdesktop.swingx.JXLabel();
        lbIP = new org.jdesktop.swingx.JXLabel();
        lbTempoInicio = new org.jdesktop.swingx.JXLabel();
        textNome = new javax.swing.JTextField();
        textFrequencia = new javax.swing.JTextField();
        lbTempoFinal = new org.jdesktop.swingx.JXLabel();
        lbFrequencia = new org.jdesktop.swingx.JXLabel();
        textInicio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        enderecoIP = new desview.util.IPAddress();
        separadorDescricao = new org.jdesktop.swingx.JXTitledSeparator();
        labelV = new org.jdesktop.swingx.JXLabel();
        labelT = new org.jdesktop.swingx.JXLabel();
        barra = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuInvisivel = new javax.swing.JMenuItem();
        markVisible = new javax.swing.JMenuItem();
        separador1MenuFile = new javax.swing.JPopupMenu.Separator();
        exportMenu = new javax.swing.JMenuItem();
        separador2MenuFile = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        menuTools = new javax.swing.JMenu();
        menuCadastro = new javax.swing.JMenu();
        menuInsertEquipment = new javax.swing.JMenuItem();
        menuInsertTask = new javax.swing.JMenuItem();
        menuEdicao = new javax.swing.JMenu();
        menuEditEquipment = new javax.swing.JMenuItem();
        menuEditTask = new javax.swing.JMenuItem();
        menuDelete = new javax.swing.JMenu();
        menuDeleteEquipment = new javax.swing.JMenuItem();
        menuDeleteTask = new javax.swing.JMenuItem();
        menuBuscar = new javax.swing.JMenuItem();
        separador1MenuEdit = new javax.swing.JPopupMenu.Separator();
        menuOpcoes = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        status.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        status.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busy.setText("Ready");
        status.add(busy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 760, 40));

        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 780, 50));

        painelTarefas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonNew.setMnemonic(KeyEvent.VK_N);
        buttonNew.setText("New");
        buttonNew.setToolTipText("Insert a new task");
        buttonNew.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });
        painelTarefas.add(buttonNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, -1));

        refreshButton.setMnemonic(KeyEvent.VK_R);
        refreshButton.setText("Refresh");
        refreshButton.setToolTipText("Refresh immediately the screen");
        refreshButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        painelTarefas.add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 110, -1));

        startButton.setMnemonic(KeyEvent.VK_S);
        startButton.setText("Start");
        startButton.setToolTipText("Start the selected task");
        startButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        painelTarefas.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 100, -1));

        stopButton.setMnemonic(KeyEvent.VK_T);
        stopButton.setText("Stop");
        stopButton.setToolTipText("Stop the selected task");
        stopButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        painelTarefas.add(stopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 90, -1));

        tabela.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        tabela.setModel(tabelaModelo);
        tabela.setColumnSelectionAllowed(true);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        scrollTabela.setViewportView(tabela);
        tabela.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        painelTarefas.add(scrollTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 290));

        editButton.setMnemonic(KeyEvent.VK_E);
        editButton.setText("Edit");
        editButton.setToolTipText("Insert a new task");
        editButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        painelTarefas.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 10, 100, -1));

        getContentPane().add(painelTarefas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 575, 330));

        container.setBackground(new java.awt.Color(240, 240, 240));
        container.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 210, 310));

        painelDetalhes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelDetalhes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaVariaveis.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listaVariaveis.setModel(modeloLista);
        listaVariaveis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollVariaveis.setViewportView(listaVariaveis);

        painelDetalhes.add(scrollVariaveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 320, 170));

        lbNome.setText("Name:");
        painelDetalhes.add(lbNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 20));

        textFim.setEditable(false);
        textFim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFim.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelDetalhes.add(textFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 230, -1));

        lBVariaveisMonitoradas.setText("Variables:");
        painelDetalhes.add(lBVariaveisMonitoradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 190, -1));

        lbIP.setText("IP:");
        painelDetalhes.add(lbIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, -1));

        lbTempoInicio.setText("Start time:");
        painelDetalhes.add(lbTempoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, -1));

        textNome.setEditable(false);
        textNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelDetalhes.add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 230, -1));

        textFrequencia.setEditable(false);
        textFrequencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFrequencia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelDetalhes.add(textFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 110, -1));

        lbTempoFinal.setText("End time:");
        painelDetalhes.add(lbTempoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, -1));

        lbFrequencia.setText("Frequency:");
        painelDetalhes.add(lbFrequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        textInicio.setEditable(false);
        textInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelDetalhes.add(textInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, 20));
        painelDetalhes.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 310, -1));
        painelDetalhes.add(enderecoIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        getContentPane().add(painelDetalhes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 730, 210));

        separadorDescricao.setTitle("Selected task details");
        getContentPane().add(separadorDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 730, -1));

        labelV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        labelV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelV.setText("Visualizations");
        getContentPane().add(labelV, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 220, 20));

        labelT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        labelT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelT.setText("Tasks");
        getContentPane().add(labelT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 560, 20));

        menuFile.setText("File");

        menuInvisivel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuInvisivel.setText("Mark invisible");
        menuInvisivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInvisivelActionPerformed(evt);
            }
        });
        menuFile.add(menuInvisivel);

        markVisible.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        markVisible.setText("Mark visible");
        markVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markVisibleActionPerformed(evt);
            }
        });
        menuFile.add(markVisible);
        menuFile.add(separador1MenuFile);

        exportMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        exportMenu.setText("Export");
        exportMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportMenuActionPerformed(evt);
            }
        });
        menuFile.add(exportMenu);
        menuFile.add(separador2MenuFile);

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuSair.setText("Quit");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuFile.add(menuSair);

        barra.add(menuFile);

        menuTools.setText("Tools");

        menuCadastro.setText("Insert");

        menuInsertEquipment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuInsertEquipment.setText("Equipment");
        menuInsertEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInsertEquipmentActionPerformed(evt);
            }
        });
        menuCadastro.add(menuInsertEquipment);

        menuInsertTask.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuInsertTask.setText("Task");
        menuInsertTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInsertTaskActionPerformed(evt);
            }
        });
        menuCadastro.add(menuInsertTask);

        menuTools.add(menuCadastro);

        menuEdicao.setText("Edit");

        menuEditEquipment.setText("Equipment");
        menuEditEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditEquipmentActionPerformed(evt);
            }
        });
        menuEdicao.add(menuEditEquipment);

        menuEditTask.setText("Task");
        menuEditTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditTaskActionPerformed(evt);
            }
        });
        menuEdicao.add(menuEditTask);

        menuTools.add(menuEdicao);

        menuDelete.setText("Delete");

        menuDeleteEquipment.setText("Equipment");
        menuDeleteEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteEquipmentActionPerformed(evt);
            }
        });
        menuDelete.add(menuDeleteEquipment);

        menuDeleteTask.setText("Task");
        menuDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteTaskActionPerformed(evt);
            }
        });
        menuDelete.add(menuDeleteTask);

        menuTools.add(menuDelete);

        menuBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menuBuscar.setText("Search");
        menuBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBuscarActionPerformed(evt);
            }
        });
        menuTools.add(menuBuscar);
        menuTools.add(separador1MenuEdit);

        menuOpcoes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOpcoes.setText("Options");
        menuOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcoesActionPerformed(evt);
            }
        });
        menuTools.add(menuOpcoes);

        barra.add(menuTools);

        menuHelp.setText("Help");

        menuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuSobre.setText("About");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        menuHelp.add(menuSobre);

        barra.add(menuHelp);

        setJMenuBar(barra);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        boolean sair = Message.question(null, new StringBuilder("Exit").toString(), new StringBuilder("Do you really want to exit?").toString());
        if (sair) {
            System.exit(0);
        } else {
            return;
        }
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AboutWindow(user).setVisible(true);
            }
        });
    }//GEN-LAST:event_menuSobreActionPerformed

    private void menuInsertEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInsertEquipmentActionPerformed
        insertEquipment();
    }//GEN-LAST:event_menuInsertEquipmentActionPerformed

    private void menuEditEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditEquipmentActionPerformed
        editEquipment();
    }//GEN-LAST:event_menuEditEquipmentActionPerformed

    private void menuBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_menuBuscarActionPerformed

    private void menuInvisivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInvisivelActionPerformed
        try {
            int r = tabela.getSelectedRow();
            Task t = tabelaModelo.getTarefa(r);
            setBusy(false, "Marking task invisible...", 0, Color.black);
            StringBuffer b = new StringBuffer();
            b.append("Do you want to mark invisible the task: \n").append(t.getTaskName()).append("  [").append(t.getId()).append("] invisível ?");
            if (Message.question(null, "Invisible task", b.toString())) {
                controleTarefa.setTask(t);
                t.setStatus(TaskStatus.INVISIBLE);
                controleTarefa.update();
                atualiza();
            } else {
                return;
            }
        } catch (Exception e) {
            setBusy(false, "Select a task to mark invisible", 0, Color.red);
        }
    }//GEN-LAST:event_menuInvisivelActionPerformed

    private void menuOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcoesActionPerformed
        opcoes();
    }//GEN-LAST:event_menuOpcoesActionPerformed

    private void markVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markVisibleActionPerformed
        markVisible();
    }//GEN-LAST:event_markVisibleActionPerformed

    private void menuInsertTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInsertTaskActionPerformed
        newTask();
    }//GEN-LAST:event_menuInsertTaskActionPerformed

    private void menuDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteTaskActionPerformed
        deleteTask();
    }//GEN-LAST:event_menuDeleteTaskActionPerformed

    private void menuDeleteEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteEquipmentActionPerformed
        deleteEquipment();
    }//GEN-LAST:event_menuDeleteEquipmentActionPerformed

    private void menuEditTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditTaskActionPerformed
        editTask();
    }//GEN-LAST:event_menuEditTaskActionPerformed

    private void exportMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportMenuActionPerformed
        export();
    }//GEN-LAST:event_exportMenuActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        editTask();
}//GEN-LAST:event_editButtonActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() == 1) {
            mouseOneClickEvent();
        } else if (evt.getClickCount() == 2) {
            editTask();
        }
}//GEN-LAST:event_tabelaMouseClicked

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        try {
            int r = tabela.getSelectedRow();
            Task t = tabelaModelo.getTarefa(r);
            setBusy(false, "Stopping...", 0, Color.black);

            if (t.getStatus().equals(TaskStatus.STOPPED)) {
                StringBuffer b = new StringBuffer();
                b.append("Task: ").append(t.getTaskName()).append("  [").append(t.getId()).append("] \n is already stopped!");
                Message.warning(null, "Task", b.toString());
            } else {
                StringBuffer b = new StringBuffer();
                b.append("Do you want to stop the task: \n").append(t.getTaskName()).append("  [").append(t.getId()).append("]?");
                if (Message.question(null, "Stop task", b.toString())) {
                    controleTarefa.setTask(t);
                    t.setStatus(TaskStatus.STOPPED);
                    controleTarefa.update();
                    atualiza();
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            setBusy(false, "Select a task to stop!", 0, Color.red);
        }
}//GEN-LAST:event_stopButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        try {
            int r = tabela.getSelectedRow();
            Task t = tabelaModelo.getTarefa(r);
            setBusy(false, "Starting...", 0, Color.black);

            if (t.getStatus().equals(TaskStatus.RUNNING)) {
                StringBuffer b = new StringBuffer();
                b.append("Task: ").append(t.getTaskName()).append("  [").append(t.getId()).append("] \n is already running!");
                Message.warning(null, "Task", b.toString());
            } else {
                StringBuffer b = new StringBuffer();
                b.append("Do you want to start the task: \n").append(t.getTaskName()).append("  [").append(t.getId()).append("]?");
                if (Message.question(null, "Start Task", b.toString())) {
                    controleTarefa.setTask(t);
                    t.setStatus(TaskStatus.RUNNING);
                    controleTarefa.update();
                    atualiza();
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            setBusy(false, "Select a task to start!", 0, Color.red);
        }
}//GEN-LAST:event_startButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        atualiza();
        mouseOneClickEvent();
        clearBottomPanel();
}//GEN-LAST:event_refreshButtonActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        newTask();
}//GEN-LAST:event_buttonNewActionPerformed

    private void centralizaJanela() {
        enderecoIP.setEditable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barra;
    private org.jdesktop.swingx.JXBusyLabel busy;
    private javax.swing.JButton buttonNew;
    private org.jdesktop.swingx.JXTaskPaneContainer container;
    private javax.swing.JButton editButton;
    private desview.util.IPAddress enderecoIP;
    private javax.swing.JMenuItem exportMenu;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXLabel lBVariaveisMonitoradas;
    private org.jdesktop.swingx.JXLabel labelT;
    private org.jdesktop.swingx.JXLabel labelV;
    private org.jdesktop.swingx.JXLabel lbFrequencia;
    private org.jdesktop.swingx.JXLabel lbIP;
    private org.jdesktop.swingx.JXLabel lbNome;
    private org.jdesktop.swingx.JXLabel lbTempoFinal;
    private org.jdesktop.swingx.JXLabel lbTempoInicio;
    private org.jdesktop.swingx.JXList listaVariaveis;
    private javax.swing.JMenuItem markVisible;
    private javax.swing.JMenuItem menuBuscar;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuDelete;
    private javax.swing.JMenuItem menuDeleteEquipment;
    private javax.swing.JMenuItem menuDeleteTask;
    private javax.swing.JMenu menuEdicao;
    private javax.swing.JMenuItem menuEditEquipment;
    private javax.swing.JMenuItem menuEditTask;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuInsertEquipment;
    private javax.swing.JMenuItem menuInsertTask;
    private javax.swing.JMenuItem menuInvisivel;
    private javax.swing.JMenuItem menuOpcoes;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JMenu menuTools;
    private org.jdesktop.swingx.JXPanel painelDetalhes;
    private javax.swing.JPanel painelTarefas;
    private javax.swing.JButton refreshButton;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JScrollPane scrollVariaveis;
    private javax.swing.JPopupMenu.Separator separador1MenuEdit;
    private javax.swing.JPopupMenu.Separator separador1MenuFile;
    private javax.swing.JPopupMenu.Separator separador2MenuFile;
    private org.jdesktop.swingx.JXTitledSeparator separadorDescricao;
    private javax.swing.JButton startButton;
    private org.jdesktop.swingx.JXStatusBar status;
    private javax.swing.JButton stopButton;
    private org.jdesktop.swingx.JXTable tabela;
    private javax.swing.JTextField textFim;
    private javax.swing.JTextField textFrequencia;
    private javax.swing.JTextField textInicio;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables

    private void setBusy(boolean b, String texto, int delay, Color cor) {
        busy.setBusy(b);
        busy.setText(texto);
        busy.setDelay(delay);
        busy.setForeground(cor);
        busy.setDirection(Direction.LEFT);
    }

    private void mouseOneClickEvent() {
        int c = tabela.getSelectedRow();
        if (c >= 0) {
            Task tarefa = tabelaModelo.getTarefa(c);
            StringBuffer b = new StringBuffer();
            b.append("Task ").append(tarefa.getId()).append(" selected");
            setBusy(false, b.toString(), 0, Color.black);
            textNome.setText(tarefa.getTaskName());
            textInicio.setText(tarefa.getEstimatedStartDate().toString());

            String infiniteS = "01/01/2020 00:00:00";
            String fimS = tarefa.getEstimatedEndDate();
            Date fim = new Date();
            Date infinite = new Date();
            GregorianCalendar calendarioInfinite = new GregorianCalendar();
            GregorianCalendar calendarioFim = new GregorianCalendar();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            try {
                fim = formatoData.parse(fimS);
                infinite = formatoData.parse(infiniteS);

                calendarioInfinite.setTime(infinite);
                calendarioFim.setTime(fim);

                if (calendarioFim.get(GregorianCalendar.YEAR) == calendarioInfinite.get(GregorianCalendar.YEAR)
                        && calendarioFim.get(GregorianCalendar.MONTH) == calendarioInfinite.get(GregorianCalendar.MONTH)
                        && calendarioFim.get(GregorianCalendar.DATE) == calendarioInfinite.get(GregorianCalendar.DATE)
                        && calendarioFim.get(GregorianCalendar.HOUR) == calendarioInfinite.get(GregorianCalendar.HOUR)
                        && calendarioFim.get(GregorianCalendar.MINUTE) == calendarioInfinite.get(GregorianCalendar.MINUTE)
                        && calendarioFim.get(GregorianCalendar.SECOND) == calendarioInfinite.get(GregorianCalendar.SECOND)) {
                    textFim.setText("Infinite");
                } else {
                    textFim.setText(tarefa.getEstimatedEndDate().toString());
                }
            } catch (Exception ex) {
            }
            textFrequencia.setText(tarefa.getFrequency().toString());
            enderecoIP.setIp(tarefa.getEquipment().getIP());
            List<Variable> listaVariaveisTarefa = tarefa.getVariables();
            modeloLista.removeAllElements();
            for (int i = 0; i < listaVariaveisTarefa.size(); i++) {
                modeloLista.addElement(listaVariaveisTarefa.get(i));
            }
        }
    }

    private void clearBottomPanel() {
        textNome.setText("");
        textInicio.setText("");
        textFim.setText("");
        textFrequencia.setText("");
        enderecoIP.cleanIP();
        modeloLista.removeAllElements();
    }

    private void newTask() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TaskWindow taskWindow = new TaskWindow("Desview: New task", 0);
                taskWindow.pack();
                taskWindow.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                taskWindow.setLabelWhat("Fill the following fields to create a new task:");
                taskWindow.setResizable(false);
                taskWindow.setVisible(true);
            }
        });
    }

    private void deleteTask() {
        try {
            int r = tabela.getSelectedRow();
            Task t = tabelaModelo.getTarefa(r);
            setBusy(false, "Deleting...", 0, Color.black);
            StringBuffer b = new StringBuffer();
            b.append("Do you really want to delete the task: \n").append(t.getTaskName()).append("  [").append(t.getId()).append("]?");
            if (Message.question(null, "Delete task", b.toString())) {
                try {
                    controleTarefa.setTask(t);
                    controleTarefa.delete();
                } catch (Exception ec) {
                    setBusy(false, "Problem trying to delete task", 0, Color.red);
                }
                atualiza();
            } else {
                return;
            }
        } catch (Exception e) {
            setBusy(false, "Select a task to delete!", 0, Color.red);
        }
    }

    private void deleteEquipment() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                EquipmentDelete e = new EquipmentDelete();
                e.pack();
                e.setVisible(true);
            }
        });
    }

    private void editEquipment() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                EquipmentEdit e = new EquipmentEdit();
                e.pack();
                e.setVisible(true);
            }
        });
    }

    private void insertEquipment() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                EquipmentInsert e = new EquipmentInsert();
                e.pack();
                e.setVisible(true);
            }
        });
    }

    private void markVisible() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MarkVisible m = new MarkVisible("Mark tasks visible");
                m.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                m.pack();
                m.setVisible(true);
            }
        });
    }

    private void export() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Export("Export").setVisible(true);
            }
        });
    }

    public void setUser(Users user) {
        this.user = user;
    }

    private class TabelaTarefa extends AbstractTableModel {

        private static final long serialVersionUID = 47563L;
        private List<Task> linhas = new ArrayList<Task>();
        private String[] colunas;

        public TabelaTarefa(List<Task> dados, String[] colunas) {
            setLinhas(dados);
            setColunas(colunas);
        }

        @Override
        public int getColumnCount() {
            int tamanho = colunas.length;
            return tamanho;
        }

        @Override
        public int getRowCount() {
            int tamanho = linhas.size();
            return tamanho;
        }

        @Override
        public Object getValueAt(int linha, int coluna) {
            Object valor = null;
            Task t = linhas.get(linha);
            switch (coluna) {
                case 0:
                    valor = t.getId();
                    if (valor == null) {
                        valor = new StringBuilder("").toString();
                    }
                    break;
                case 1:
                    valor = new StringBuilder(t.getTaskName()).toString();
                    if (valor == null) {
                        valor = new StringBuilder("").toString();
                    }
                    break;
                case 2:
                    EquipmentControl c = new EquipmentControl();
                    valor = t.getIdEquipment();
                    Equipment e = c.getEquipmentByID((Long) valor);
                    valor = e.getIP();
                    if (valor == null) {
                        valor = new StringBuilder("").toString();
                    }
                    break;
                case 3:
                    valor = new StringBuilder(t.getEstimatedStartDate()).toString();
                    if (valor == null) {
                        valor = new StringBuilder("").toString();
                    }
                    break;
                case 4:
                    try {
                        String infiniteS = new StringBuilder("01/01/2020 00:00:00").toString();
                        String fimS = t.getEstimatedEndDate();
                        Date fim = new Date();
                        Date infinite = new Date();
                        GregorianCalendar calendarioInfinite = new GregorianCalendar();
                        GregorianCalendar calendarioFim = new GregorianCalendar();
                        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                        fim = formatoData.parse(fimS);
                        infinite = formatoData.parse(infiniteS);

                        calendarioInfinite.setTime(infinite);
                        calendarioFim.setTime(fim);

                        if (calendarioFim.get(GregorianCalendar.YEAR) == calendarioInfinite.get(GregorianCalendar.YEAR)
                                && calendarioFim.get(GregorianCalendar.MONTH) == calendarioInfinite.get(GregorianCalendar.MONTH)
                                && calendarioFim.get(GregorianCalendar.DATE) == calendarioInfinite.get(GregorianCalendar.DATE)
                                && calendarioFim.get(GregorianCalendar.HOUR) == calendarioInfinite.get(GregorianCalendar.HOUR)
                                && calendarioFim.get(GregorianCalendar.MINUTE) == calendarioInfinite.get(GregorianCalendar.MINUTE)
                                && calendarioFim.get(GregorianCalendar.SECOND) == calendarioInfinite.get(GregorianCalendar.SECOND)) {
                            valor = new StringBuilder("Infinite").toString();
                        } else {
                            valor = new StringBuilder(t.getEstimatedEndDate()).toString();
                        }
                    } catch (Exception ex) {
                    }
                    if (valor == null) {
                        valor = new StringBuilder("").toString();
                    }
                    break;
                case 5:
                    valor = new StringBuilder(t.getFrequency()).toString();
                    if (valor == null) {
                        valor = new StringBuilder("").toString();
                    }
                    break;
                case 6:
                    valor = t.getStatus();
                    if (valor == null) {
                        valor = new StringBuilder("").toString();
                    }
                    break;
            }
            return valor;
        }

        public Task getTarefa(int linha) {
            return linhas.get(linha);
        }

        @Override
        public boolean isCellEditable(int r, int c) {
            return false;
        }

        @Override
        public String getColumnName(int num) {
            return colunas[num];
        }

        public List<Task> getLinhas() {
            return linhas;
        }

        public void setLinhas(List<Task> linhas) {
            this.linhas = linhas;
        }

        public String[] getColunas() {
            return colunas;
        }

        public void setColunas(String[] colunas) {
            this.colunas = colunas;
        }
    }

    private class CorTabela extends JLabel implements TableCellRenderer {

        private static final long serialVersionUID = 57412241L;
        private String statusColuna;

        public CorTabela(String statusColuna) {
            this.statusColuna = statusColuna;
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean hasFocus, int row, int column) {
            Object valor = table.getValueAt(row, table.getColumnModel().getColumnIndex(statusColuna));
            if (value != null) {
                setText(value.toString());
            }
            setBackground(table.getBackground());
            setForeground(table.getForeground());

            if (valor.equals(TaskStatus.RUNNING)) {
                setBackground(new Color(0x43CD80));//verde
            } else if (valor.equals(TaskStatus.WAITING)) {
                setBackground(new Color(0x1E90FF));//azul
            } else if (valor.equals(TaskStatus.STOPPED)) {
                setBackground(new Color(0xFFFF01));//amarelo
            } else if (valor.equals(TaskStatus.FINISHED)) {
                setBackground(new Color(0x8B8B7A)); //cinza
            } else if (valor.equals(TaskStatus.ERROR)) {
                setBackground(new Color(0xB22222)); //vermelho
            } else if (valor.equals(TaskStatus.INVISIBLE)) {
                setBackground(Color.white); //branco
            } else { //nunca deveria entrar aqui, somente se for mexido no banco e colocado num estado inconsistente
                setBackground(new Color(0xFFA500)); //laranja
            }
            return this;
        }
    }

    private class AtualizadorJanela {

        private Timer timer;

        /**
         * Construtor do atualizador de janela.
         * @param delay o <i>delay</i> para as atualizações.
         * @param segundos o intervalo entre as atualizações.
         */
        public AtualizadorJanela(int delay, int segundos) {
            timer = new Timer();
            timer.schedule(new AtualizadorTask(), delay, segundos * 1000);
        }

        private class AtualizadorTask extends TimerTask {

            @Override
            public void run() {
                try {
                    System.out.println("Updating...");
                    atualiza();
                } catch (Exception ex) {
                    StringBuilder s = new StringBuilder();
                    s.append("Error updating! " + ex.getMessage());
                    System.err.println(s.toString());
                    ex.printStackTrace();
                }
            }
        }
    }

    private void editTask() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    setBusy(false, "Ready", 0, Color.black);
                    int r = tabela.getSelectedRow();
                    Task tarefa = tabelaModelo.getTarefa(r);
                    TaskWindow taskWindow = new TaskWindow("Desview: Edit a task", 1);
                    taskWindow.setSelectedTaskToEdit(tarefa);
                    taskWindow.pack();
                    taskWindow.setLabelWhat("Fill the following fields to edit the task:");
                    taskWindow.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                    taskWindow.setVisible(true);
                    String inicioS = tarefa.getEstimatedStartDate();
                    String fimS = tarefa.getEstimatedEndDate();
                    String freqS = tarefa.getFrequency();
                    String infiniteS = "01/01/2020 00:00:00";
                    List<Variable> variaveis = tarefa.getVariables();
                    Date inicio = new Date();
                    Date fim = new Date();
                    Date infinite = new Date();
                    Date freq = new Date();

                    GregorianCalendar calendarioInfinite = new GregorianCalendar();
                    GregorianCalendar calendarioInicio = new GregorianCalendar();
                    GregorianCalendar calendarioFim = new GregorianCalendar();
                    GregorianCalendar calendarioFrequencia = new GregorianCalendar();

                    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    SimpleDateFormat formatoTempo = new SimpleDateFormat("HH:mm:ss");

                    inicio = formatoData.parse(inicioS);
                    infinite = formatoData.parse(infiniteS);
                    calendarioInicio.setTime(inicio);
                    freq = formatoTempo.parse(freqS);
                    calendarioFrequencia.setTime(freq);

                    calendarioInfinite.setTime(infinite);

                    fim = formatoData.parse(fimS);
                    calendarioFim.setTime(fim);

                    if (calendarioFim.get(GregorianCalendar.YEAR) == calendarioInfinite.get(GregorianCalendar.YEAR)
                            && calendarioFim.get(GregorianCalendar.MONTH) == calendarioInfinite.get(GregorianCalendar.MONTH)
                            && calendarioFim.get(GregorianCalendar.DATE) == calendarioInfinite.get(GregorianCalendar.DATE)
                            && calendarioFim.get(GregorianCalendar.HOUR) == calendarioInfinite.get(GregorianCalendar.HOUR)
                            && calendarioFim.get(GregorianCalendar.MINUTE) == calendarioInfinite.get(GregorianCalendar.MINUTE)
                            && calendarioFim.get(GregorianCalendar.SECOND) == calendarioInfinite.get(GregorianCalendar.SECOND)) {
                        //for infinite end, the set value must be null
                        taskWindow.fillFields(tarefa.getEquipment(), tarefa.getTaskName(), calendarioInicio, null, calendarioFrequencia, variaveis);
                    } else {
                        taskWindow.fillFields(tarefa.getEquipment(), tarefa.getTaskName(), calendarioInicio, calendarioFim, calendarioFrequencia, variaveis);
                    }
                } catch (Exception e) {
                    setBusy(false, "Select a task to edit", 0, Color.red);
                }
            }
        });
    }

    private void opcoes() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                if (user != null) {
                    Options s = new Options("Preferences", user);
                    s.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                    s.setVisible(true);
                } else {
                    Message.warning(null, "Options", "The user is null. Cannot open preferences.");
                }
            }
        });
    }

    private void buscar() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SearchWindow s = new SearchWindow("Search");
                s.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                s.setVisible(true);
            }
        });
    }

    private void createGraphicsPanel() {
        container.setBorder(new DropShadowBorder());
        JXTaskPane taskPane = new JXTaskPane();
        taskPane.setTitle("Real Time graphics");
        Action we = new Action("Real Time Chart");
        we.setLongDescription("Monitoring five variables at same time in a real time chart");
        taskPane.add(we);
        container.add(taskPane);

        taskPane = new JXTaskPane();
        taskPane.setTitle("Opengl");
        we = new Action("2D - Lines");
        we.setLongDescription("Monitoring variables at same in 2D lines graphic");
        taskPane.add(we);
        we = new Action("2D - Spirals");
        we.setLongDescription("Monitoring variables at same in 2D spiral graphic");
        taskPane.add(we);
        we = new Action("3D - Spheres");
        we.setLongDescription("Monitoring variables at same in 3D spherical graphic");
        taskPane.add(we);
        container.add(taskPane);

        taskPane = new JXTaskPane();
        taskPane.setTitle("Charts");
        we = new Action("Polar chart");
        we.setLongDescription("Polar chart data visualization");
        taskPane.add(we);
        we = new Action("Line chart");
        we.setLongDescription("Line chart data visualization");
        taskPane.add(we);
        we = new Action("Bar chart");
        we.setLongDescription("Bar chart data visualization with min, avg and max");
        taskPane.add(we);
        container.add(taskPane);
    }

    private static final class Action extends AbstractActionExt {

        private static final long serialVersionUID = 244246L;

        public Action(String name) {
            setName(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getName().equals("Real Time Chart")) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        SelectVariablesRTChart s = new SelectVariablesRTChart("Real time chart");
                        s.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                        s.setVisible(true);
                    }
                });
            } else if (getName().equals("2D - Lines")) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        SelectTasks s = new SelectTasks("Tasks");
                        s.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                        s.setVisible(true);
                    }
                });
            } else if (getName().equals("2D - Spirals")) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        SelectTasksSpirals s = new SelectTasksSpirals("2D - Spirals");
                        s.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                        s.setVisible(true);
                    }
                });
            } else if (getName().equals("3D - Spheres")) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        GLApiName api = GLApiName.JSR231;

                        LauncherSettings settings = new LauncherSettings(api);
                        settings.setGLScene(SpheresGraphic.class);
                        settings.setShowLauncherGUI(false).setTitle("Object selection");
                        IGLApplication app = Launcher.launch(settings);

                        //Change cursor
                        URL url = SpheresGraphic.class.getClass().getResource("/datas/textures/Cross2.png");
                        if (url != null) {
                            try {
                                Image image = Toolkit.getDefaultToolkit().getImage(url);
                                Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(16, 16), "Cross2");

                                final Component component = (Component) app.getSceneTarget().getComponent().getAwtComponent();
                                if (component != null) {
                                    component.setCursor(cursor);
                                }
                            } catch (Exception exc) {
                            } catch (Error err) {
                            }
                        }
                        app.run();
                    }
                });
            } else if (getName().equals("Polar chart")) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        DoPolarChart pc = new DoPolarChart("Polar chart");
                        pc.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                        pc.setVisible(true);
                    }
                });
            } else if (getName().equals("Line chart")) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        SelectVariablesLines lc = new SelectVariablesLines("Line chart");
                        lc.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                        lc.setVisible(true);
                    }
                });
            } else if (getName().equals("Bar chart")) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        BarChart bc = new BarChart("Bar chart");
                        bc.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                        bc.pack();
                        RefineryUtilities.centerFrameOnScreen(bc);
                        bc.setVisible(true);
                    }
                });
            } else {
                Message.error(null, "Error", getName());
            }
        }
    }
}
