package desview.graphics.charts.lines;

import desview.controller.HistoricControl;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

/**
 * This class is a line chart. Adapted from a jfreechart example.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 09/07/2010.
 * @version 1.0
 */
public class LineChart extends ApplicationFrame {

    private static final long serialVersionUID = -9548485574L;
    private String[] oids;
    private String year;
    private HistoricControl historicControl = new HistoricControl();

    /**
     * Creates new chart.
     * @param title the frame title.
     * @param oids
     * @param year
     */
    public LineChart(String title, String[] oids, String year) {
        super(title);
        this.oids = oids;
        this.year = year;
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Creates a sample dataset.
     * @return a sample dataset.
     */
    @SuppressWarnings("rawtypes")
    private XYDataset createDataset() {
        XYSeries series;
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (String oid : oids) {
            if (oid != null) {
                List historics = historicControl.getValuesByOIDYear(oid, year);
                for (int i = 0; i < historics.size(); i++) {
                    Object[] valores = (Object[]) historics.get(i);
                    String month = String.valueOf(valores[0]);
                    String value = String.valueOf(valores[1]);
                    series = new XYSeries(oid);
                    series.add(Double.parseDouble(month), Double.parseDouble(value));
                    dataset.addSeries(series);
                }
            }
        }
        return dataset;
    }

    @SuppressWarnings("deprecation")
    private static JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Line Chart Demo 2",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setShapesVisible(true);
        renderer.setShapesFilled(true);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return chart;
    }
}
