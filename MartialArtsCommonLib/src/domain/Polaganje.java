/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Sara
 */
public class Polaganje implements GenericEntity {

    private long polaganjeID;
    private String zaPojas;
    private boolean polozeno;
    private Date datumPolaganja;
    private long clanID;

    public Polaganje() {
    }

    public Polaganje(long polaganjeID, String zaPojas, boolean polozeno, Date datumPolaganja, long clanID) {
        this.polaganjeID = polaganjeID;
        this.zaPojas = zaPojas;
        this.polozeno = polozeno;
        this.datumPolaganja = datumPolaganja;
        this.clanID = clanID;
    }

    public long getClanID() {
        return clanID;
    }

    public void setClanID(long clanID) {
        this.clanID = clanID;
    }

    public long getPolaganjeID() {
        return polaganjeID;
    }

    public void setPolaganjeID(long polaganjeID) {
        this.polaganjeID = polaganjeID;
    }

    public String getZaPojas() {
        return zaPojas;
    }

    public void setZaPojas(String zaPojas) {
        this.zaPojas = zaPojas;
    }

    public boolean isPolozeno() {
        return polozeno;
    }

    public void setPolozeno(boolean polozeno) {
        this.polozeno = polozeno;
    }

    public Date getDatumPolaganja() {
        return datumPolaganja;
    }

    public void setDatumPolaganja(Date datumPolaganja) {
        this.datumPolaganja = datumPolaganja;
    }

    @Override
    public String getTableName() {
        return "polaganje";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "zaPojas, polozeno, datumPolaganja, clanID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(zaPojas).append("', ")
                .append(polozeno).append(", ")
                .append("'").append(new java.sql.Date(datumPolaganja.getTime())).append("', ")
                .append(clanID);
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.polaganjeID = id;
    }

    @Override
    public String getUpdateValues() {
        return "zaPojas = '" + zaPojas + "', polozeno = " + polozeno + ", datumPolaganja = '" + new java.sql.Date(datumPolaganja.getTime()) + "'";
    }

    @Override
    public String getWhereCriteria() {
        return "polaganjeID = " + polaganjeID;
    }

    @Override
    public String getJoinText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID() {
        return "polaganjeID = " + polaganjeID;
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        return new Polaganje(rs.getLong(getTableName() + ".polaganjeID"), rs.getString(getTableName() + ".zaPojas"), rs.getBoolean(getTableName() + ".polozeno"), rs.getDate(getTableName() + ".datumPolaganja"), rs.getLong(getTableName() + ".clanID"));
    }

}
