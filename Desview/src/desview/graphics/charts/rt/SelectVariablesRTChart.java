package desview.graphics.charts.rt;

import desview.controller.TaskControl;
import desview.controller.ReadingControl;
import desview.model.entities.Task;
import desview.util.Message;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.DefaultListModel;
import org.jdesktop.swingx.JXFrame;

/**
 * Class where are selected the variables to view in Real time chart.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 02/05/2010.
 * @version 1.0
 */
public class SelectVariablesRTChart extends JXFrame {

    private static final long serialVersionUID = 92354315L;
    private DefaultListModel lista1, lista2;

    /**
     * Constructor of class SelectVariablesRTChart.
     * @param title the window title
     */
    public SelectVariablesRTChart(String title) {
        super(title);
        lista1 = new DefaultListModel();
        lista2 = new DefaultListModel();
        initComponents();
        postInitComponent();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new org.jdesktop.swingx.JXLabel();
        btViewChart = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        scroll1 = new javax.swing.JScrollPane();
        jlistaVolta = new org.jdesktop.swingx.JXList();
        scroll2 = new javax.swing.JScrollPane();
        jlistaVai = new org.jdesktop.swingx.JXList();
        volta = new javax.swing.JButton();
        vai = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        labelInutil2 = new javax.swing.JLabel();
        inutil = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label.setText("Select the variables to monitor in the Real Time Chart");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 390, 20));

        btViewChart.setText("View chart");
        btViewChart.setToolTipText("View the real time chart with the selected variables");
        btViewChart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btViewChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewChartActionPerformed(evt);
            }
        });
        getContentPane().add(btViewChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 170, -1));

        btCancel.setText("Cancel");
        btCancel.setToolTipText("Cancel and close this window");
        btCancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 90, -1));

        jlistaVolta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlistaVolta.setModel(lista2);
        scroll1.setViewportView(jlistaVolta);

        getContentPane().add(scroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 250, 230));

        jlistaVai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlistaVai.setModel(lista1);
        jlistaVai.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scroll2.setViewportView(jlistaVai);

        getContentPane().add(scroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 260, 230));

        volta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desview/graphics/charts/rt/spinleft.gif"))); // NOI18N
        volta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        volta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltaActionPerformed(evt);
            }
        });
        getContentPane().add(volta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 40, 30));

        vai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desview/graphics/charts/rt/spinright.gif"))); // NOI18N
        vai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        vai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaiActionPerformed(evt);
            }
        });
        getContentPane().add(vai, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 40, 30));

        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText(" ");
        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 580, 20));

        labelInutil2.setText("           ");
        getContentPane().add(labelInutil2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, -1, 330));

        inutil.setText("  ");
        getContentPane().add(inutil, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 270, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btViewChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewChartActionPerformed
        createChart();
    }//GEN-LAST:event_btViewChartActionPerformed

    private void vaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaiActionPerformed
        vaiAction();
    }//GEN-LAST:event_vaiActionPerformed

    private void voltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltaActionPerformed
        voltaAction();
    }//GEN-LAST:event_voltaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btViewChart;
    private org.jdesktop.swingx.JXLabel inutil;
    private org.jdesktop.swingx.JXList jlistaVai;
    private org.jdesktop.swingx.JXList jlistaVolta;
    private org.jdesktop.swingx.JXLabel label;
    private javax.swing.JLabel labelInutil2;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JLabel status;
    private javax.swing.JButton vai;
    private javax.swing.JButton volta;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("rawtypes")
    private void postInitComponent() {
        ReadingControl readingControl = new ReadingControl();
        TaskControl taskControl = new TaskControl();
        List lista = readingControl.getValuesToRT();
        for (int i = 0; i < lista.size(); i++) {
            StringBuffer b = new StringBuffer();
            Object[] valores = (Object[]) lista.get(i);
            String t = String.valueOf(valores[0]);
            String oid = String.valueOf(valores[1]);
            String var = String.valueOf(valores[2]);
            Task c = taskControl.getTaskByID(new Long(t));
            b.append(oid).append(", ").append(var).append(", ").append(c.getTaskName());
            lista1.addElement(b.toString());
        }
    }

    private void vaiAction() {
        String semiReading = (String) jlistaVai.getSelectedValue();
        if (lista2.size() >= 5) {
            Message.error(null, "Too much variables", "The number maximum of variables in the chart is 5");
        } else {
            lista2.addElement(semiReading);
            lista1.removeElement(semiReading);
        }
        StringBuilder s = new StringBuilder();
        s.append("Maximum of variables is 5.").append(" Current number is ").append(lista2.size()).append(".");
        status.setText(s.toString());
    }

    private void voltaAction() {
        String semiReading = (String) jlistaVolta.getSelectedValue();
        lista1.addElement(semiReading);
        lista2.removeElement(semiReading);
    }

    private void createChart() {
        Task task1 = null, task2 = null, task3 = null, task4 = null, task5 = null;
        String task1name, task2name, task3name, task4name, task5name;
        String oid1 = null, oid2 = null, oid3 = null, oid4 = null, oid5 = null;
        String var1 = null, var2 = null, var3 = null, var4 = null, var5 = null;
        if (lista2.size() == 1) {
            String total1 = (String) lista2.getElementAt(0);
            String[] partes1 = total1.split(", ");
            oid1 = partes1[0].trim();
            var1 = partes1[1].trim();
            task1name = partes1[2].trim();

            TaskControl t = new TaskControl();
            task1 = t.getTaskByName(task1name);
        } else if (lista2.size() == 2) {
            String total1 = (String) lista2.getElementAt(0);
            String[] partes1 = total1.split(", ");
            oid1 = partes1[0].trim();
            var1 = partes1[1].trim();
            task1name = partes1[2].trim();
            String total2 = (String) lista2.getElementAt(1);
            String[] partes2 = total2.split(", ");
            oid2 = partes2[0].trim();
            var2 = partes2[1].trim();
            task2name = partes2[2].trim();

            TaskControl t = new TaskControl();
            task1 = t.getTaskByName(task1name);
            task2 = t.getTaskByName(task2name);
        } else if (lista2.size() == 3) {
            String total1 = (String) lista2.getElementAt(0);
            String[] partes1 = total1.split(", ");
            oid1 = partes1[0].trim();
            var1 = partes1[1].trim();
            task1name = partes1[2].trim();
            String total2 = (String) lista2.getElementAt(1);
            String[] partes2 = total2.split(", ");
            oid2 = partes2[0].trim();
            var2 = partes2[1].trim();
            task2name = partes2[2].trim();
            String total3 = (String) lista2.getElementAt(2);
            String[] partes3 = total3.split(", ");
            oid3 = partes3[0].trim();
            var3 = partes3[1].trim();
            task3name = partes3[2].trim();

            TaskControl t = new TaskControl();
            task1 = t.getTaskByName(task1name);
            task2 = t.getTaskByName(task2name);
            task3 = t.getTaskByName(task3name);
        } else if (lista2.size() == 4) {
            String total1 = (String) lista2.getElementAt(0);
            String[] partes1 = total1.split(", ");
            oid1 = partes1[0].trim();
            var1 = partes1[1].trim();
            task1name = partes1[2].trim();
            String total2 = (String) lista2.getElementAt(1);
            String[] partes2 = total2.split(", ");
            oid2 = partes2[0].trim();
            var2 = partes2[1].trim();
            task2name = partes2[2].trim();
            String total3 = (String) lista2.getElementAt(2);
            String[] partes3 = total3.split(", ");
            oid3 = partes3[0].trim();
            var3 = partes3[1].trim();
            task3name = partes3[2].trim();
            String total4 = (String) lista2.getElementAt(3);
            String[] partes4 = total4.split(", ");
            oid4 = partes4[0].trim();
            var4 = partes4[1].trim();
            task4name = partes4[2].trim();

            TaskControl t = new TaskControl();
            task1 = t.getTaskByName(task1name);
            task2 = t.getTaskByName(task2name);
            task3 = t.getTaskByName(task3name);
            task4 = t.getTaskByName(task4name);
        } else if (lista2.size() == 5) {
            String total1 = (String) lista2.getElementAt(0);
            String[] partes1 = total1.split(", ");
            oid1 = partes1[0].trim();
            var1 = partes1[1].trim();
            task1name = partes1[2].trim();
            String total2 = (String) lista2.getElementAt(1);
            String[] partes2 = total2.split(", ");
            oid2 = partes2[0].trim();
            var2 = partes2[1].trim();
            task2name = partes2[2].trim();
            String total3 = (String) lista2.getElementAt(2);
            String[] partes3 = total3.split(", ");
            oid3 = partes3[0].trim();
            var3 = partes3[1].trim();
            task3name = partes3[2].trim();
            String total4 = (String) lista2.getElementAt(3);
            String[] partes4 = total4.split(", ");
            oid4 = partes4[0].trim();
            var4 = partes4[1].trim();
            task4name = partes4[2].trim();
            String total5 = (String) lista2.getElementAt(4);
            String[] partes5 = total5.split(", ");
            oid5 = partes5[0].trim();
            var5 = partes5[1].trim();
            task5name = partes5[2].trim();

            TaskControl t = new TaskControl();
            task1 = t.getTaskByName(task1name);
            task2 = t.getTaskByName(task2name);
            task3 = t.getTaskByName(task3name);
            task4 = t.getTaskByName(task4name);
            task5 = t.getTaskByName(task5name);
        } else {
            //nothing selected
            Message.information(null, "None selected", "Select at least one variable to draw chart");
            return;
        }
        TransferableObject t = new TransferableObject(task1, task2, task3, task4, task5, oid1, oid2, oid3, oid4, oid5, var1, var2, var3, var4, var5);
        RealTimeChart d = new RealTimeChart(t);
        d.setVisible(true);
    }
}
