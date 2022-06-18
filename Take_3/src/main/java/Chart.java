/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Kacper
 */
@Named(value = "chart")
@RequestScoped
public class Chart {

    private LineChartModel chartModel;

    /**
     * Creates a new instance of Chart
     */
    public Chart() {
        chartModel = new LineChartModel();
        LineChartSeries chartSeries = new LineChartSeries();
        for (int i = 0; i < 360; i++) {
            chartSeries.set(i, Math.sin(i));
        }

        chartModel.addSeries(chartSeries);
        chartModel.setLegendPosition("e");
        Axis y = chartModel.getAxis(AxisType.Y);
        y.setMin(-1.2);
        y.setMax(1.2);
        y.setLabel("Value of sinus");

        Axis x = chartModel.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(360);
        x.setTickInterval("15");
        x.setLabel("Degrees");

        chartModel.setZoom(true);
    }

    public LineChartModel getChartModel() {
        return chartModel;
    }

    public void setChartModel(LineChartModel chartModel) {
        this.chartModel = chartModel;
    }

    public void resetZoom() {
        chartModel.setZoom(false);
        chartModel.setZoom(true);
    }

}
