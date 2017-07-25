package desview.graphics.charts.lines;

import ChartDirector.ChartViewer;
import desview.controller.HistoricControl;
import desview.model.entities.Historic;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.jdesktop.swingx.JXFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * Class where are selected the variables to view in polar chart.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 02/05/2010.
 * @version 1.0
 */
public class SelectVariablesLines extends JXFrame {

    private static final long serialVersionUID = 7524226150L;
    private DefaultListModel lista;
    private HistoricControl historicControl = new HistoricControl();
    private String year, oid;
    private String oids[] = new String[5];

    /**
     * Constructor of class
     * @param title the window title
     */
    @SuppressWarnings("rawtypes")
    public SelectVariablesLines(String title) {
        super(title);
        lista = new DefaultListModel();
        initComponents();
        ArrayList<Historic> al = (ArrayList<Historic>) historicControl.getHistorics();
        for (int i = 0; i < al.size(); i++) {
            String oidv = al.get(i).getOid();
            if (!lista.contains(oidv)) {
                lista.addElement(oidv);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        btViewChart2 = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        scroll2 = new javax.swing.JScrollPane();
        jlista = new org.jdesktop.swingx.JXList();
        labelInutil1 = new javax.swing.JLabel();
        labelVar = new org.jdesktop.swingx.JXLabel();
        labelYear = new javax.swing.JLabel();
        comboYear = new javax.swing.JComboBox();
        inutil = new javax.swing.JLabel();
        btViewChart1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btViewChart2.setText("View chart 2");
        btViewChart2.setToolTipText("View the real time chart with the selected variables");
        btViewChart2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btViewChart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewChart2ActionPerformed(evt);
            }
        });
        getContentPane().add(btViewChart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 120, -1));

        btCancel.setText("Cancel");
        btCancel.setToolTipText("Cancel and close this window");
        btCancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 100, -1));

        jlista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlista.setModel(lista);
        scroll2.setViewportView(jlista);

        getContentPane().add(scroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 390, 200));

        labelInutil1.setText("           ");
        getContentPane().add(labelInutil1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 460, 30));

        labelVar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVar.setText("Select  variable to create Chart");
        getContentPane().add(labelVar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 260, 20));

        labelYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelYear.setText("Select year:");
        getContentPane().add(labelYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 210, -1));

        comboYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "2009", "2010", "2011", "2012" }));
        getContentPane().add(comboYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 160, -1));

        inutil.setText(" ");
        getContentPane().add(inutil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 310, -1));

        btViewChart1.setText("View chart 1");
        btViewChart1.setToolTipText("View the real time chart with the selected variables");
        btViewChart1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btViewChart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewChart1ActionPerformed(evt);
            }
        });
        getContentPane().add(btViewChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btViewChart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewChart2ActionPerformed
        boolean problema = false;
        if (comboYear.getSelectedIndex() != 0) {
            year = (String) comboYear.getSelectedItem();
        } else {
            problema = true;
        }
        if (jlista.getSelectedValue() != null) {
            oid = (String) jlista.getSelectedValue();
        } else {
            problema = true;
        }
        if (!problema) {
            createChart();
        }
    }//GEN-LAST:event_btViewChart2ActionPerformed

    private void btViewChart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewChart1ActionPerformed
        boolean problema = false;
        if (comboYear.getSelectedIndex() != 0) {
            year = (String) comboYear.getSelectedItem();
        } else {
            problema = true;
        }
        if (jlista.getSelectedValues() != null) {
            for (int i = 0; i < jlista.getSelectedValues().length; i++) {
                oids[i] = (String) jlista.getSelectedValues()[i];
            }
        } else {
            problema = true;
        }
        if (!problema) {
            createChart2();
        }
    }//GEN-LAST:event_btViewChart1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btViewChart1;
    private javax.swing.JButton btViewChart2;
    private javax.swing.JComboBox comboYear;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel inutil;
    private org.jdesktop.swingx.JXList jlista;
    private javax.swing.JLabel labelInutil1;
    private org.jdesktop.swingx.JXLabel labelVar;
    private javax.swing.JLabel labelYear;
    private javax.swing.JScrollPane scroll2;
    // End of variables declaration//GEN-END:variables

    private void createChart() {
        //Instantiate an instance of this demo module
        LinesGraphic d = new LinesGraphic();

        //Create and set up the main window
        JXFrame frame = new JXFrame("Line Chart");

        frame.getContentPane().setBackground(Color.white);

        // Create the chart and put them in the content pane
        ChartViewer viewer = new ChartViewer();
        d.createChart(viewer, year, oid);
        frame.getContentPane().add(viewer);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }

    private void createChart2() {
        LineChart d = new LineChart("Line chart", oids, year);
        d.pack();
        RefineryUtilities.centerFrameOnScreen(d);
        d.setVisible(true);
    }
}
