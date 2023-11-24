/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Clanarina;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sara
 */
public class TableModelClanarine extends AbstractTableModel {

    private List<Clanarina> clanarine;
    private String[] columnNames = new String[]{"Iznos", "Mesec", "Godina", "Isplaceno", "Datum placanja"};
    private Class[] columnClass = new Class[]{BigDecimal.class, String.class, Integer.class, Boolean.class, Date.class};

    public TableModelClanarine() {
        clanarine = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (clanarine == null) {
            return 0;
        } else {
            return clanarine.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int i) {
        if (i > columnNames.length) {
            return "n/a";
        } else {
            return columnNames[i];
        }
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

        Clanarina c = clanarine.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getIznos();
            case 1:
                return c.getZaMesec();
            case 2:
                return c.getZaGodinu();
            case 3:
                return c.isIsplaceno();
            case 4:
                return c.getDatumPlacanja();

            default:
                return "n/a";
        }

    }

    public void setClanarine(List<Clanarina> clanarine) {
        this.clanarine = clanarine;
        fireTableDataChanged();
    }

    public Clanarina vratiClanarinu(int row) {
        return clanarine.get(row);
    }

    public void izmenaClanarine(Clanarina clanarina) {

        for (Clanarina c : clanarine) {
            if (c.getClanarinaID() == clanarina.getClanarinaID()) {
                c = clanarina;
            }
        }
        fireTableDataChanged();
    }

    public void obrisiClanarinu(int row) {
        clanarine.remove(row);
        fireTableDataChanged();
    }

    public void dodajClanarinu(Clanarina clanarina) {
        clanarine.add(clanarina);
        fireTableDataChanged();
    }

}
