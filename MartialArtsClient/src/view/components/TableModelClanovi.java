/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import domain.Clan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sara
 */
public class TableModelClanovi extends AbstractTableModel {

    private List<Clan> clanovi;
    private String[] columnNames = new String[]{"Ime", "Prezime", "Pol", "Telefon", "Adresa", "Pojas"};

    public TableModelClanovi() {
        clanovi = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return clanovi.size();
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
    public Object getValueAt(int rowIndex, int columnIndex) {

        Clan c = clanovi.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getIme();
            case 1:
                return c.getPrezime();
            case 2:
                return c.getPol();
            case 3:
                return c.getTelefon();
            case 4:
                return c.getAdresa();
            case 5:
                return c.getPojas();
            default:
                throw new AssertionError();
        }

    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
        fireTableDataChanged();
    }

    public Clan vratiClana(int row) {
        return clanovi.get(row);
    }

}
