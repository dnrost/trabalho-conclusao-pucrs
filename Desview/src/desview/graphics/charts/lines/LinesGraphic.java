package desview.graphics.charts.lines;

import ChartDirector.Chart;
import ChartDirector.ChartViewer;
import ChartDirector.LineLayer;
import ChartDirector.XYChart;
import desview.controller.HistoricControl;
import java.util.List;

/**
 * This class is a line chart. Adapted from a Chart director example.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 15/06/2010.
 * @version 1.0
 */
public class LinesGraphic {

    private HistoricControl historicControl = new HistoricControl();

    @SuppressWarnings("rawtypes")
    public void createChart(ChartViewer viewer, String year, String oid) {
        String[] labels = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Set", "Oct", "Nov", "Dec"};
        double[] dados = new double[12];
        List historics = historicControl.getValuesByOIDYear(oid, year);

        // Create a XYChart object of size 450 x 250 pixels, with a pale yellow
        // (0xffffc0) background, a black border, and 1 pixel 3D border effect.
        XYChart c = new XYChart(450, 250, 0xffffc0, 0, 1);

        // Set the plotarea at (60, 45) and of size 360 x 170 pixels, using white
        // (0xffffff) as the plot area background color. Turn on both horizontal and
        // vertical grid lines with light grey color (0xc0c0c0)
        c.setPlotArea(60, 45, 360, 170, 0xffffff, -1, -1, 0xc0c0c0, -1);

        // Add a legend box at (60, 20) (top of the chart) with horizontal layout.
        // Use 8 pts Arial Bold font. Set the background and border color to
        // Transparent.
        c.addLegend(60, 20, false, "Arial Bold", 8).setBackground(Chart.Transparent);

        // Add a title to the chart using 12 pts Arial Bold/white font. Use a 1 x 2
        // bitmap pattern as the background.
        c.addTitle("Values in year: " + year, "Arial Bold", 12, 0xffffff).setBackground(c.patternColor(new int[]{0x000040, 0x000080}, 2));

        // Set the labels on the x axis
        c.xAxis().setLabels(labels);

        c.xAxis().setMargin(8, 8);

        c.yAxis().setTitle("Read value");

        LineLayer layer = c.addLineLayer2();

        layer.set3D();
        for (int i = 0; i < historics.size(); i++) {
            Object[] valores = (Object[]) historics.get(i);
            String month = String.valueOf(valores[0]);
            String value = String.valueOf(valores[1]);
            dados[Integer.parseInt(month) - 1] = Double.valueOf(value);
        }

        layer.addDataSet(dados, 0xff2645, oid);
        layer.setLineWidth(3);

        viewer.setImage(c.makeImage());

        viewer.setImageMap(c.getHTMLImageMap("clickable", "", "title='Number of {dataSetName} at {xLabel}: {value}'"));
    }
}
