package by.bsuir.alexkomar.cultureis;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class VariableTableModel extends AbstractTableModel {
    private List<String> columnNames;
    private List<List<String>> entries;

    public VariableTableModel() {
        columnNames = new ArrayList<>();
        entries = new ArrayList<>();
    }

    @Override
    public int getRowCount() { return entries.size(); }

    @Override
    public int getColumnCount() { return columnNames.size(); }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex < getRowCount()) {
            return entries.get(rowIndex).get(columnIndex);
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) { return columnNames.get(columnIndex); }

    public void setColumnNames(List<String> newColumnNames) {
        entries = new ArrayList<>();
        columnNames = newColumnNames;
    }

    public void addEntry(List<String> toAdd) { entries.add(toAdd); }

}
