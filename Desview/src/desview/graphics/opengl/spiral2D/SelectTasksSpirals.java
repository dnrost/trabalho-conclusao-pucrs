package desview.graphics.opengl.spiral2D;

import desview.controller.TaskControl;
import desview.model.entities.Task;
import desview.model.entities.Variable;
import desview.util.Message;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.DefaultListModel;
import org.jdesktop.swingx.JXFrame;

/**
 * Class where are selected the variables to visualization.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 23/05/2010.
 * @version 1.0
 */
public class SelectTasksSpirals extends JXFrame {

    private static final long serialVersionUID = 4235465565325156L;
    private DefaultListModel listaModelo;
    private int MAX_ALLOWED = 4; // number maximum of variables to monitoring.

    /**
     * Constructor of class SelectTasksSpirals.
     * @param title the window title
     */
    public SelectTasksSpirals(String title) {
        super(title);
        listaModelo = new DefaultListModel();
        initComponents();
        postInitComponent();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new org.jdesktop.swingx.JXLabel();
        btViewChart = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        jlista = new org.jdesktop.swingx.JXList();
        inutil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label.setText("Select a task:");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 260, 20));

        btViewChart.setText("View graphic");
        btViewChart.setToolTipText("View the real time chart with the selected variables");
        btViewChart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btViewChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewChartActionPerformed(evt);
            }
        });
        getContentPane().add(btViewChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 100, -1));

        btCancel.setText("Cancel");
        btCancel.setToolTipText("Cancel and close this window");
        btCancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 90, -1));

        jlista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlista.setModel(listaModelo);
        jlista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scroll.setViewportView(jlista);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 260, 230));
        getContentPane().add(inutil, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 270, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btViewChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewChartActionPerformed
        createView();
    }//GEN-LAST:event_btViewChartActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btViewChart;
    private javax.swing.JLabel inutil;
    private org.jdesktop.swingx.JXList jlista;
    private org.jdesktop.swingx.JXLabel label;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    private void postInitComponent() {
        TaskControl taskControl = new TaskControl();
        List<Task> lista = taskControl.getTasks();
        for (int i = 0; i < lista.size(); i++) {
            Task t = lista.get(i);
            listaModelo.addElement(t.getTaskName());
        }
    }

    private void createView() {
        Task task = null;
        if (jlista.getSelectedValue() != null) {
            String name = (String) jlista.getSelectedValue();
            TaskControl t = new TaskControl();
            task = t.getTaskByName(name);
            List<Variable> l = task.getVariables();
            for (int i = 0; i < l.size(); i++) {
                System.err.println(l.get(i).toStringFull());
            }
        } else {
            //nothing selected
            Message.information(null, "None selected", "Select one task to view graphic");
            return;
        }
        if (task != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(task.getTaskName()).append(" - ").append(" Spiral 2D visualization");
            int numberOfVariables = task.getVariables().size();
            if (numberOfVariables > MAX_ALLOWED) {
                StringBuilder s = new StringBuilder("The maximum of variables for this graphic is ");
                s.append(MAX_ALLOWED);
                s.append(".\n Do you want to continue?");
                if (Message.question(null, "Too much variables", s.toString())) {
                    SpiralGLCanvas frame = new SpiralGLCanvas(sb.toString(), task);
                    frame.setVisible(true);
                } else {
                    return;
                }
            } else {
                SpiralGLCanvas frame = new SpiralGLCanvas(sb.toString(), task);
                frame.setVisible(true);
            }
        }
    }
}

