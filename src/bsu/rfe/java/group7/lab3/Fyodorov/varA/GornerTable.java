package bsu.rfe.java.group7.lab3.Fyodorov.varA;

import javax.swing.table.AbstractTableModel;

public class GornerTable extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    private double result;

    public GornerTable(Double from, Double to, Double step, Double[] coefficients) {

        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {

        return 3;
    }
    public int getRowCount() {

        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }
    public Object getValueAt(int row, int col) {

        double x = from + step * row;
        switch (col) {
            case 0:
                return x;
            case 1: {
                result = 0.0;
                for (int i = 0; i < coefficients.length; i++) {
                    result += Math.pow(x, coefficients.length - 1 - i) * coefficients[i];
                }
                return result;
            }
            case 2: {
                int g = (int)Math.sqrt((int)result);
                return g * g == (int)result;
            }
            default: {
                return 0;
            }
        }
    }
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 2:
                return "Значение является квадратом?";
            default:
                return "Значение многочлена";
        }
    }
    public Class<?> getColumnClass(int col) {
        if (col == 0 || col == 1){
            return Double.class;
        }
        else{
            return Boolean.class;
        }

    }
}
