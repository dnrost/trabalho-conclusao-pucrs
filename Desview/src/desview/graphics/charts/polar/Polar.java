package desview.graphics.charts.polar;

import ChartDirector.Chart;
import ChartDirector.ChartViewer;
import ChartDirector.PolarChart;

/**
 * This chart represents a polar chart with the informations.
 * @author Diones Rossetto.
 * @author Luiz Mello.
 * @since 12/05/2010.
 * @version 1.0
 * This class is based in a chart director example.
 */
public class Polar {

    /**
     * Polar chart class constructor.
     */
    public Polar() {
    }

    //Main code for creating charts
    public void createChart(ChartViewer viewer, double[] data) {

        Integer[] days = new Integer[31];
        for (int i = 0; i <= 30; i++) {
            days[i] = i;
        }

        // Create a PolarChart object of size 460 x 460 pixels, with a silver
        // background and a 1 pixel 3D border
        PolarChart c = new PolarChart(460, 460, Chart.goldColor(), 0x000000, 1);

        // Add a title to the chart at the top left corner using 15pts Arial Bold
        // Italic font. Use white text on deep blue background.
        c.addTitle("", "Arial Bold Italic", 15, 0xffffff).setBackground(0xcc0080);

        // Set plot area center at (230, 240) with radius 180 pixels and white background
        c.setPlotArea(230, 240, 180, 0xffffff);

        // Set the grid style to circular grid
        c.setGridStyle(false);

        // Set angular axis as 0 - 360, with a spoke every 30 units
        c.angularAxis().setLinearScale(1, 32, 1);

        // Add sectors to the chart as sector zones
        for (int i = 0; i < data.length; ++i) {
            c.angularAxis().addZone(days[i], days[i] + 1, 0, data[i], 0x33ff33,
                    0x008000);
        }

        // Add an Transparent invisible layer to ensure the axis is auto-scaled using
        // the data
        c.addLineLayer(data, Chart.Transparent);

        // Output the chart
        viewer.setImage(c.makeImage());
    }
}
