package desview.graphics.charts.barchart;

import desview.controller.HistoricControl;
import java.awt.Dimension;
import java.util.List;
import org.jdesktop.swingx.JXFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * This shows a 3D bar chart with item labels displayed.
 */
public class BarChart extends JXFrame {

    private static final long serialVersionUID = 12351401505L;

    /**
     * Creates a new chart
     * @param title  the frame title.
     */
    public BarChart(final String title) {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
        setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Creates a sample dataset.
     * @return a sample dataset.
     */
    @SuppressWarnings("rawtypes")
    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HistoricControl historicControl = new HistoricControl();
        List lista = historicControl.getValuesAMM();
        for (int i = 0; i < lista.size(); i++) {
            Object[] valores = (Object[]) lista.get(i);
            String oid = String.valueOf(valores[0]);
            String min = String.valueOf(valores[1]);
            String avg = String.valueOf(valores[2]);
            String max = String.valueOf(valores[3]);
            dataset.addValue(Double.parseDouble(max), "max", oid);
            dataset.addValue(Double.parseDouble(min), "min", oid);
            dataset.addValue(Double.parseDouble(avg), "avg", oid);
        }
        return dataset;
    }

    /**
     * Creates a chart.
     * @param dataset  the dataset.
     * @return The chart.
     */
    @SuppressWarnings("deprecation")
    private JFreeChart createChart(final CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createBarChart3D(
                "Bar Chart aggregation values x variable", // chart title
                "Aggregation type", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
                );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0));

        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true);
        final BarRenderer r = (BarRenderer) renderer;
        r.setMaximumBarWidth(0.07);
        return chart;
    }
}
