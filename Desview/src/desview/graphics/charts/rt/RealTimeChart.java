package desview.graphics.charts.rt;

import ChartDirector.Chart;
import ChartDirector.ChartViewer;
import ChartDirector.LegendBox;
import ChartDirector.LineLayer;
import ChartDirector.Mark;
import ChartDirector.ViewPortAdapter;
import ChartDirector.ViewPortChangedEvent;
import ChartDirector.XYChart;
import desview.controller.snmp.SNMPFacade;
import desview.model.entities.Task;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTextField;

/**
 * Class that represents a real time chart. Adapted from a Chart director example.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 01/05/2010.
 * @version 1.0
 */
public class RealTimeChart extends JXFrame {

    private static final long serialVersionUID = 8176877457L;
    private boolean inicializacaoFinalizada = false;
    private JButton run, stop;
    private ChartViewer chartViewer;
    private JComboBox period;
    private JTextField alarmThreshold;
    private JTextField valueA, valueB, valueC, valueD, valueE;
    private Timer dataRateTimer, chartUpdateTimer;
    private final int tamanho = 250;
    private Date[] timeStamps = new Date[tamanho];
    private double[] dados1 = new double[tamanho];
    private double[] dados2 = new double[tamanho];
    private double[] dados3 = new double[tamanho];
    private double[] dados4 = new double[tamanho];
    private double[] dados5 = new double[tamanho];
    private Date nextExecution = new Date();
    private Task task1, task2, task3, task4, task5;
    private String oid1, oid2, oid3, oid4, oid5;
    private String varName1, varName2, varName3, varName4, varName5;

    /**
     * Constructor of the class RealTimeChart.
     * @param t
     */
    public RealTimeChart(TransferableObject t) {
        this.task1 = t.getTask1();
        this.oid1 = t.getOid1();
        this.varName1 = t.getVarName1();
        this.task2 = t.getTask2();
        this.oid2 = t.getOid2();
        this.varName2 = t.getVarName2();
        this.task3 = t.getTask3();
        this.oid3 = t.getOid3();
        this.varName3 = t.getVarName3();
        this.task4 = t.getTask4();
        this.oid4 = t.getOid4();
        this.varName4 = t.getVarName4();
        this.task5 = t.getTask5();
        this.oid5 = t.getOid5();
        this.varName5 = t.getVarName5();
        if (varName1 == null) {
            varName1 = "";
        }
        if (varName2 == null) {
            varName2 = "";
        }
        if (varName3 == null) {
            varName3 = "";
        }
        if (varName4 == null) {
            varName4 = "";
        }
        if (varName5 == null) {
            varName5 = "";
        }
        initComponents(false);
    }

    private void initComponents(boolean closeOnExit) {
        if (inicializacaoFinalizada) {
            run.doClick();
            return;
        }

        setTitle("Realtime Chart");
        setResizable(true);

        if (closeOnExit) {
            addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });
        } else {
            //para quando fecha a janela
            addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    stop.doClick();
                }
            });
        }


        Font font = new Font("Dialog", Font.PLAIN, 11);

        // painel esquerdo
        JXPanel leftPanel = new JXPanel(null);
        leftPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        // insert botao de executar
        run = new JButton("Run", new ImageIcon(getClass().getResource("play.gif")));
        run.setHorizontalAlignment(SwingConstants.LEFT);
        run.setMargin(new Insets(5, 5, 5, 5));
        run.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                runClicked();
            }
        });
        leftPanel.add(run).setBounds(1, 0, 138, 24);

        //insert botao de parar
        stop = new JButton("Stop", new ImageIcon(getClass().getResource("pause.gif")));
        stop.setHorizontalAlignment(SwingConstants.LEFT);
        stop.setMargin(new Insets(5, 5, 5, 5));
        stop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                stopClicked();
            }
        });
        leftPanel.add(stop).setBounds(1, 24, 138, 24);

        // label de tempo de atualizacao
        leftPanel.add(new JXLabel("Update (ms)")).setBounds(5, 60, 130, 20);

        // lista de atualizacao
        period = new JComboBox(new Object[]{"1000", "5000", "10000", "20000", "60000",});
        period.setSelectedItem("10000");
        period.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                periodValueChanged(evt);
            }
        });
        leftPanel.add(period).setBounds(5, 80, 130, 20);

        // label de threshold
        leftPanel.add(new JXLabel("Alarm Threshold")).setBounds(5, 110, 130, 20);

        // valor de threshold
        alarmThreshold = new JTextField("000");
        //  alarmThreshold.setEditable(false);
        leftPanel.add(alarmThreshold).setBounds(5, 130, 110, 20);

        // botao de aumento de threshold
        JButton spinUp = new JButton(new ImageIcon("spinup.gif"));
        spinUp.addMouseListener(new MouseAdapter() {

            private Timer spinTimer = new Timer(100, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    updateValue();
                }
            });

            @Override
            public void mousePressed(MouseEvent e) {
                updateValue();
                spinTimer.setInitialDelay(1000);
                spinTimer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                spinTimer.stop();
            }

            private void updateValue() {
                int i = 0;
                try {
                    i = Integer.parseInt(alarmThreshold.getText());
                } catch (Exception e) {
                    alarmThreshold.setText("000");
                }
                alarmThreshold.setText("" + (i + 1));
                alarmThresholdValueChanged();
            }
        });
        leftPanel.add(spinUp).setBounds(115, 130, 20, 10);
        JButton spinDown = new JButton(new ImageIcon("spindown.gif"));
        spinDown.addMouseListener(new MouseAdapter() {

            private Timer spinTimer = new Timer(100, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    updateValue();
                }
            });

            @Override
            public void mousePressed(MouseEvent e) {
                updateValue();
                spinTimer.setInitialDelay(1000);
                spinTimer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                spinTimer.stop();
            }

            private void updateValue() {
                int i = 0;
                try {
                    i = Integer.parseInt(alarmThreshold.getText());
                } catch (Exception e) {
                    alarmThreshold.setText("0");
                }
                alarmThreshold.setText("" + (i - 1));
                alarmThresholdValueChanged();
            }
        });
        leftPanel.add(spinDown).setBounds(115, 140, 20, 10);

        // label de variaveis
        leftPanel.add(new JXLabel("Variables")).setBounds(5, 180, 130, 20);

        // variable 1
        JXLabel var1 = new JXLabel(varName1);
        var1.setFont(font);
        leftPanel.add(var1).setBounds(5, 200, 60, 20);

        valueA = new JXTextField();
        valueA.setEditable(false);
        leftPanel.add(valueA).setBounds(65, 200, 70, 20);

        JXLabel var2 = new JXLabel(varName2);
        var2.setFont(font);
        leftPanel.add(var2).setBounds(5, 220, 60, 20);

        valueB = new JXTextField();
        valueB.setEditable(false);
        leftPanel.add(valueB).setBounds(65, 220, 70, 20);

        JXLabel var3 = new JXLabel(varName3);
        var3.setFont(font);
        leftPanel.add(var3).setBounds(5, 240, 60, 20);

        valueC = new JXTextField();
        valueC.setEditable(false);
        leftPanel.add(valueC).setBounds(65, 240, 70, 20);

        JXLabel var4 = new JXLabel(varName4);
        var4.setFont(font);
        leftPanel.add(var4).setBounds(5, 260, 60, 20);

        valueD = new JXTextField();
        valueD.setEditable(false);
        leftPanel.add(valueD).setBounds(65, 260, 70, 20);

        JXLabel var5 = new JXLabel(varName5);
        var5.setFont(font);
        leftPanel.add(var5).setBounds(5, 280, 60, 20);

        valueE = new JXTextField();
        valueE.setEditable(false);
        leftPanel.add(valueE).setBounds(65, 280, 70, 20);

        // Total expected panel size
        leftPanel.setPreferredSize(new Dimension(150, 275));

        // Chart Viewer
        chartViewer = new ChartViewer();
        chartViewer.setBackground(new Color(255, 255, 255));
        chartViewer.setOpaque(true);
        chartViewer.setPreferredSize(new Dimension(616, 286));
        chartViewer.setHorizontalAlignment(SwingConstants.CENTER);
        chartViewer.addViewPortListener(new ViewPortAdapter() {

            @Override
            public void viewPortChanged(ViewPortChangedEvent e) {
                chartViewerViewPortChanged(e);
            }
        });

        // adiciona o painel esquerdo e o chartViewer
        getContentPane().add(leftPanel, BorderLayout.WEST);
        getContentPane().add(chartViewer, BorderLayout.CENTER);

        // Altera fontes exceto para os labels
        for (int i = 0; i < leftPanel.getComponentCount(); ++i) {
            Component c = leftPanel.getComponent(i);
            if (!(c instanceof JXLabel)) {
                c.setFont(font);
            }
        }

        dataRateTimer = new Timer(Integer.parseInt(period.getSelectedItem().toString()), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                generateData();
            }
        });

        // timer para o chart
        chartUpdateTimer = new Timer(Integer.parseInt((String) period.getSelectedItem()), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                chartUpdateTimerTick();
            }
        });

        pack();
        inicializacaoFinalizada = true;

        //Start collecting and displaying data
        dataRateTimer.start();
        run.doClick();
        chartViewer.updateViewPort(true, false);
    }

    private void runClicked() {
        run.setBackground(new Color(0x80, 0xff, 0x80));
        stop.setBackground(null);
        chartUpdateTimer.start();
    }

    private void stopClicked() {
        stop.setBackground(new Color(0x80, 0xff, 0x80));
        stop.setBackground(null);
        chartUpdateTimer.stop();
    }

    private void periodValueChanged(ActionEvent evt) {
        int periodAux = Integer.parseInt(period.getSelectedItem().toString());
        chartUpdateTimer.setDelay(periodAux);
        chartUpdateTimer.setInitialDelay(periodAux);
    }

    private void alarmThresholdValueChanged() {
        chartViewer.updateViewPort(true, true);
    }

    private void chartUpdateTimerTick() {
        chartViewer.updateViewPort(true, false);
    }

    private void chartViewerViewPortChanged(ViewPortChangedEvent e) {
        drawChart(chartViewer);
    }

    private void drawChart(ChartViewer viewer) {
        // Create an XYChart object 600 x 270 pixels in size, with light grey (f4f4f4)
        // background, black (000000) border, 1 pixel raised effect, and with a rounded frame.
        XYChart c = new XYChart(900, 700, 0xf4f4f4, 0x000000, 1);
        c.setRoundedFrame();

        // Re-cycle the resources of the existing chart, if any. This can improve performance
        // by reducing the frequency of garbage collections.
        c.recycle(chartViewer.getChart());

        // Set the plotarea at (55, 62) and of size 520 x 175 pixels. Use white (ffffff)
        // background. Enable both horizontal and vertical grids by setting their colors to
        // grey (cccccc). Set clipping mode to clip the data lines to the plot area.
        c.setPlotArea(60, 72, 850, 750, 0xffffff, -1, -1, 0xcccccc, 0xcccccc);
        c.setClipping();

        // Add a title to the chart using 15 pts Times New Roman Bold Italic font, with a light
        // grey (dddddd) background, black (000000) border, and a glass like raised effect.
        c.addTitle("Real Time chart", "Times New Roman Bold Italic", 15).setBackground(0xdddddd, 0x000000, Chart.glassEffect());

        // Add a legend box at the top of the plot area with 9pts Arial Bold font. We set the
        // legend box to the same width as the plot area and use grid layout (as opposed to
        // flow or top/down layout). This distributes the 3 legend icons evenly on top of the
        // plot area.
        LegendBox b = c.addLegend2(55, 35, 5, "Arial Bold", 9);
        b.setBackground(Chart.Transparent, Chart.Transparent);
        b.setWidth(520);

        // Configure the y-axis with a 10pts Arial Bold axis title
        c.yAxis().setTitle("Value", "Arial Bold", 10);

        // Configure the x-axis to auto-scale with at least 75 pixels between major tick and 15
        // pixels between minor ticks. This shows more minor grid lines on the chart.
        c.xAxis().setTickDensity(75, 15);

        // Set the axes width to 2 pixels
        c.xAxis().setWidth(2);
        c.yAxis().setWidth(2);

        // Now we add the data to the chart
        Date lastTime = timeStamps[timeStamps.length - 1];
        if (lastTime != null) {
            // Set up the x-axis to show the time range in the data buffer
            c.xAxis().setDateScale(new Date(lastTime.getTime() - Integer.parseInt(period.getSelectedItem().toString()) * timeStamps.length), lastTime);

            // Set the x-axis label format
            c.xAxis().setLabelFormat("{value|hh:nn:ss}");

            // Create a line layer to plot the lines
            LineLayer layer = c.addLineLayer2();

            // The x-coordinates are the timeStamps.
            layer.setXData(timeStamps);

            // The 3 data series are used to draw 3 lines. Here we put the latest data
            // values as part of the data set name, so you can see them updated in the
            // legend box.
            layer.set3D();

            layer.addDataSet(dados1, 0xaa0000, varName1 + ": <*bgColor=FFCCCC*>"
                    + c.formatValue(dados1[dados1.length - 1], " {value|2} "));
            layer.addDataSet(dados2, 0x00cc00, varName2 + ": <*bgColor=CCFFCC*>"
                    + c.formatValue(dados2[dados2.length - 1], " {value|2} "));
            layer.addDataSet(dados3, 0x0000ff, varName3 + ": <*bgColor=CCCCFF*>"
                    + c.formatValue(dados3[dados3.length - 1], " {value|2} "));
            layer.addDataSet(dados4, 0x9f00ff, varName4 + ": <*bgColor=CCCCFF*>"
                    + c.formatValue(dados4[dados4.length - 1], " {value|2} "));
            layer.addDataSet(dados5, 0x6f45ff, varName5 + ": <*bgColor=CCCCFF*>"
                    + c.formatValue(dados5[dados5.length - 1], " {value|2} "));

            // Add a red mark line to the chart, with the mark label shown at the left of  the mark line.
            double thresholdValue;
            try {
                thresholdValue = Double.parseDouble(alarmThreshold.getText());
            } catch (Exception e) {
                thresholdValue = 0;
            }
            Mark m = c.yAxis().addMark(thresholdValue, 0xff0000, "Alarm = " + thresholdValue);
            m.setAlignment(Chart.Left);
            m.setBackground(0xffcccc);

            if ((dados5[dados5.length - 1] > thresholdValue)
                    || (dados4[dados4.length - 1] > thresholdValue)
                    || (dados3[dados3.length - 1] > thresholdValue)
                    || (dados2[dados2.length - 1] > thresholdValue)
                    || (dados1[dados1.length - 1] > thresholdValue)) {
                // Add an alarm message as a custom text box on top-right corner of the
                // plot area if the latest data value exceeds threshold.
                c.addText(575, 72, "Alarm - Latest Value Exceeded Threshold", "Arial Bold Italic", 10, 0xffffff, Chart.TopRight).setBackground(0xdd0000);
            }

            // Fill the region above the threshold as semi-transparent red (80ff8888)
            c.addInterLineLayer(layer.getLine(1), m.getLine(), 0x80ff8888, Chart.Transparent);
            c.addInterLineLayer(layer.getLine(2), m.getLine(), 0x80ff8888, Chart.Transparent);
            c.addInterLineLayer(layer.getLine(3), m.getLine(), 0x80ff8888, Chart.Transparent);
            c.addInterLineLayer(layer.getLine(4), m.getLine(), 0x80ff8888, Chart.Transparent);
        }

        // Set the chart image to the ChartViewer
        chartViewer.setChart(c);
    }

    private void generateData() {
        Date now = new Date();
        do {
            if (task1 != null) {
                String a = SNMPFacade.snmpGet(oid1, task1.getEquipment().getIP(), task1.getEquipment().getReadCommunity());
                double data = 0;
                try {
                    data = Double.valueOf(a);
                } catch (Exception e) {
                    data = 0;
                }
                shiftData(dados1, data);
            }
            if (task2 != null) {
                String b = SNMPFacade.snmpGet(oid2, task2.getEquipment().getIP(), task2.getEquipment().getReadCommunity());
                double data = 0;
                try {
                    data = Double.valueOf(b);
                } catch (Exception e) {
                    data = 0;
                }
                shiftData(dados2, data);
            }
            if (task3 != null) {
                String c = SNMPFacade.snmpGet(oid3, task3.getEquipment().getIP(), task3.getEquipment().getReadCommunity());
                double data = 0;
                try {
                    data = Double.valueOf(c);
                } catch (Exception e) {
                    data = 0;
                }
                shiftData(dados3, data);
            }
            if (task4 != null) {
                String d = SNMPFacade.snmpGet(oid4, task4.getEquipment().getIP(), task4.getEquipment().getReadCommunity());
                double data = 0;
                try {
                    data = Double.valueOf(d);
                } catch (Exception e) {
                    data = 0;
                }
                shiftData(dados4, data);
            }
            if (task5 != null) {
                String e = SNMPFacade.snmpGet(oid5, task5.getEquipment().getIP(), task5.getEquipment().getReadCommunity());
                double data = 0;
                try {
                    data = Double.valueOf(e);
                } catch (Exception ec) {
                    data = 0;
                }
                shiftData(dados5, data);
            }

            shiftData(timeStamps, nextExecution);

            nextExecution = new Date(nextExecution.getTime() + Integer.parseInt(period.getSelectedItem().toString()));

        } while (nextExecution.before(now));

        valueA.setText("" + dados1[dados1.length - 1]);
        valueB.setText("" + dados2[dados2.length - 1]);
        valueC.setText("" + dados3[dados3.length - 1]);
        valueD.setText("" + dados4[dados4.length - 1]);
        valueE.setText("" + dados5[dados5.length - 1]);
    }

    private void shiftData(double[] data, double newValue) {
        for (int i = 1; i < data.length; ++i) {
            data[i - 1] = data[i];
        }
        data[data.length - 1] = newValue;
    }

    private void shiftData(Date[] data, Date newValue) {
        for (int i = 1; i < data.length; ++i) {
            data[i - 1] = data[i];
        }
        data[data.length - 1] = newValue;
    }
}


