/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Polaganje;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sara
 */
public class TableModelPolaganja extends AbstractTableModel {

    private List<Polaganje> polaganja;
    private String[] columnNames = new String[]{"Za nivo", "Polozeno", "Datum polaganja"};
    private Class[] columnClass = new Class[]{String.class, Boolean.class, Date.class};

    public TableModelPolaganja() {
        polaganja = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return polaganja.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {

        if (i > columnClass.length) {
            return Object.class;
        } else {
            return columnClass[i];
        }

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Polaganje p = polaganja.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getZaPojas();
            case 1:
                return p.isPolozeno();
            case 2:
                return p.getDatumPolaganja();
            default:
                throw new AssertionError();
        }

    }

    public void setPolaganja(List<Polaganje> polaganja) {
        this.polaganja = polaganja;
        fireTableDataChanged();
    }

    public Polaganje vratiPolaganje(int row) {
        return polaganja.get(row);
    }

}
