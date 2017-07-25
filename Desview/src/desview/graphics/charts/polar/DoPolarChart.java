package desview.graphics.charts.polar;

import ChartDirector.ChartViewer;
import desview.controller.HistoricControl;
import desview.model.entities.Historic;
import desview.util.Message;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import org.jdesktop.swingx.JXFrame;

/**
 * Class where are selected the variables to view in polar chart.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 02/05/2010.
 * @version 1.0
 */
public class DoPolarChart extends JXFrame {

    private static final long serialVersionUID = 79526150L;
    private DefaultListModel lista;
    private HistoricControl historicControl = new HistoricControl();
    private String year, month, variable;

    /**
     * Constructor of class SelectVariablesRTChart.
     * @param title the window title
     */
    @SuppressWarnings("rawtypes")
    public DoPolarChart(String title) {
        super(title);
        lista = new DefaultListModel();
        initComponents();
        ArrayList<Historic> al = (ArrayList<Historic>) historicControl.getHistorics();
        for (int i = 0; i < al.size(); i++) {
            String oid = al.get(i).getOid();
            if (!lista.contains(oid)) {
                lista.addElement(oid);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new org.jdesktop.swingx.JXLabel();
        btViewChart = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        jlista = new org.jdesktop.swingx.JXList();
        labelInutil1 = new javax.swing.JLabel();
        painel = new org.jdesktop.swingx.JXPanel();
        comboYear = new javax.swing.JComboBox();
        comboMonth = new javax.swing.JComboBox();
        texto = new javax.swing.JLabel();
        labelVar = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Select  year and month");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 250, 20));

        btViewChart.setText("View chart");
        btViewChart.setToolTipText("View the real time chart with the selected variables");
        btViewChart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btViewChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewChartActionPerformed(evt);
            }
        });
        getContentPane().add(btViewChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 120, -1));

        btCancel.setText("Cancel");
        btCancel.setToolTipText("Cancel and close this window");
        btCancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 100, -1));

        jlista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlista.setModel(lista);
        jlista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scroll.setViewportView(jlista);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 260, 210));

        labelInutil1.setText("           ");
        getContentPane().add(labelInutil1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 620, 30));

        painel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "2009", "2010", "2011", "2012" }));
        painel.add(comboYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, -1));

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        painel.add(comboMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, -1));
        painel.add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 190, 20));

        getContentPane().add(painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 260, 210));

        labelVar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVar.setText("Select oid");
        getContentPane().add(labelVar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 260, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btViewChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewChartActionPerformed

        boolean problema = false;
        if (comboYear.getSelectedIndex() != 0) {
            year = (String) comboYear.getSelectedItem();
        } else {
            problema = true;
        }
        if (comboMonth.getSelectedIndex() != 0) {
            month = (String) comboMonth.getSelectedItem();
        } else {
            problema = true;
        }
        if (jlista.getSelectedValue() != null) {
            variable = (String) jlista.getSelectedValue();
        } else {
            problema = true;
        }
        if (!problema) {
            createChart();
        } else {
            Message.error(null, "Selection problem", "Please, select year, month and oid");
        }
    }//GEN-LAST:event_btViewChartActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btViewChart;
    private javax.swing.JComboBox comboMonth;
    private javax.swing.JComboBox comboYear;
    private org.jdesktop.swingx.JXList jlista;
    private org.jdesktop.swingx.JXLabel label;
    private javax.swing.JLabel labelInutil1;
    private org.jdesktop.swingx.JXLabel labelVar;
    private org.jdesktop.swingx.JXPanel painel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("rawtypes")
    private void createChart() {
        double[] data = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List historics = historicControl.getAvgByOIDYearMonth(variable, year, month);
        for (int i = 0; i < historics.size(); i++) {
            Object[] valores = (Object[]) historics.get(i);
            String day = String.valueOf(valores[0]);
            String oid = String.valueOf(valores[1]);
            String avg = String.valueOf(valores[2]);
            data[((Integer.parseInt(day))) - 1] = Double.parseDouble(avg);
        }
        //Instantiate an instance of this demo module
        Polar polar = new Polar();
        //Create and set up the main window
        JFrame frame = new JFrame("Polar chart");

        frame.getContentPane().setBackground(Color.white);

        // Create the chart and put them in the content pane
        ChartViewer viewer = new ChartViewer();

        polar.createChart(viewer, data);
        frame.getContentPane().add(viewer);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }
}
