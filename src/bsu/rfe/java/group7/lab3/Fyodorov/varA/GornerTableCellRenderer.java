package bsu.rfe.java.group7.lab3.Fyodorov.varA;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    private String needle = null;
    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    public GornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(5); /*пять знаков после запятой*/
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);

        panel.add(label);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        String formattedDouble = "";
        if (col == 1 || col == 0) {
            formattedDouble = formatter.format(value);
            label.setText(formattedDouble);
        }

        if (col == 1 && needle != null && needle.equals(formattedDouble)) {
// Номер столбца = 1 (т.е. второй столбец) + иголка не null // (значит что-то ищем) +
// значение иголки совпадает со значением ячейки таблицы - // окрасить задний фон панели в красный цвет
            panel.setBackground(Color.RED);
        } else if (col == 0) {
            panel.setBackground(Color.WHITE);
        }
        return panel;
    }
    public void setNeedle(String needle) {
        this.needle = needle;
    }
}
