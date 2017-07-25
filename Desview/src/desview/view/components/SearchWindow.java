package desview.view.components;

import desview.controller.EquipmentControl;
import desview.controller.SearchControl;
import desview.controller.TaskControl;
import desview.controller.VariableControl;
import desview.model.entities.Equipment;
import desview.model.entities.Search;
import desview.model.entities.Task;
import desview.model.entities.Variable;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import org.jdesktop.swingx.JXFrame;

/**
 * Search in database class.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @version 1.0
 * @since 25/04/2010
 */
public class SearchWindow extends JXFrame {

    private static final long serialVersionUID = 50049676261L;
    private DefaultListModel modelo = new DefaultListModel();
    private EquipmentControl equipmentControl;
    private TaskControl taskControl;
    private VariableControl variableControl;
    private SearchControl searchControl;

    /**
     * Constructor of search class.
     * @param title title of window.
     */
    public SearchWindow(String title) {
        super(title);
        initComponents();
        equipmentControl = new EquipmentControl();
        searchControl = new SearchControl();
        variableControl = new VariableControl();
        taskControl = new TaskControl();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        texto = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        lista = new org.jdesktop.swingx.JXList();
        botaoGo = new javax.swing.JButton();
        botaoClose = new javax.swing.JButton();
        link = new org.jdesktop.swingx.JXHyperlink();
        status = new org.jdesktop.swingx.JXStatusBar();
        labelStatus = new javax.swing.JLabel();
        inutil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label.setText("Type text");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 36, 72, -1));
        getContentPane().add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 58, 463, -1));

        lista.setModel(modelo);
        scroll.setViewportView(lista);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 144, 517, 120));

        botaoGo.setText("Go");
        botaoGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGoActionPerformed(evt);
            }
        });
        getContentPane().add(botaoGo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 89, 67, -1));

        botaoClose.setText("Close");
        botaoClose.setToolTipText("Close this window");
        botaoClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCloseActionPerformed(evt);
            }
        });
        getContentPane().add(botaoClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 89, -1, -1));

        link.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        link.setText("?");
        link.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkActionPerformed(evt);
            }
        });
        getContentPane().add(link, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 34, 18, -1));

        status.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        status.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelStatus.setText(" ");
        status.add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 380, 20));

        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 280, 520, 26));

        inutil.setText("   ");
        getContentPane().add(inutil, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 350, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void linkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkActionPerformed

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                sb.append("Available search: \n ~> tasks \n ~> variables \n ~> equipments");
                MiniPanel miniPanel = new MiniPanel(sb.toString(), true, false);
                miniPanel.setResizable(false);
                miniPanel.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
                miniPanel.setVisible(true);
            }
        });
    }//GEN-LAST:event_linkActionPerformed

    private void botaoCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCloseActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCloseActionPerformed

    private void botaoGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGoActionPerformed
        doSearch();
    }//GEN-LAST:event_botaoGoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoClose;
    private javax.swing.JButton botaoGo;
    private javax.swing.JLabel inutil;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelStatus;
    private org.jdesktop.swingx.JXHyperlink link;
    private org.jdesktop.swingx.JXList lista;
    private javax.swing.JScrollPane scroll;
    private org.jdesktop.swingx.JXStatusBar status;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables

    private void doSearch() {
        manageStatus(" ", Color.black);
        modelo.removeAllElements();
        insertSearch(texto.getText());
        List<Equipment> list1 = equipmentControl.getEquipmentNameLike(texto.getText());
        List<Equipment> list2 = equipmentControl.getEquipmentIPLike(texto.getText());
        List<Task> list3 = taskControl.getTaskNameLike(texto.getText());
        List<Variable> list4 = variableControl.getVariableNameLike(texto.getText());
        for (Equipment equipment : list1) {
            modelo.addElement(equipment);
        }
        for (Equipment equipment : list2) {
            modelo.addElement(equipment);
        }
        for (Task task : list3) {
            modelo.addElement(task);
        }
        for (Variable var : list4) {
            modelo.addElement(var);
        }
        if (modelo.isEmpty()) {
            manageStatus("No results", Color.red);
        } else {
            StringBuilder s = new StringBuilder();
            s.append("Found ").append(modelo.getSize());
            if (modelo.getSize() == 1) {
                s.append(" result");
            } else {
                s.append(" results");
            }
            manageStatus(s.toString(), Color.black);
        }
    }

    private void insertSearch(String text) {
        Search s = new Search();
        Date data = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        s.setDate(formatoData.format(data));
        s.setQuery(text);
        s.setUser("admin");//TODO
        searchControl.setSearch(s);
        searchControl.insert();
    }

    private void manageStatus(String text, Color c) {
        labelStatus.setForeground(c);
        labelStatus.setText(text);
    }
}
