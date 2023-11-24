/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Sara
 */
public class Clanarina implements GenericEntity {

    private long clanarinaID;
    private BigDecimal iznos;
    private String zaMesec;
    private int zaGodinu;
    private boolean isplaceno;
    private Date datumPlacanja;
    private long clanID;

    public Clanarina() {
    }

    public Clanarina(long clanarinaID, BigDecimal iznos, String zaMesec, int zaGodinu, boolean isplaceno, Date datumPlacanja, long clanID) {
        this.clanarinaID = clanarinaID;
        this.iznos = iznos;
        this.zaMesec = zaMesec;
        this.zaGodinu = zaGodinu;
        this.isplaceno = isplaceno;
        this.datumPlacanja = datumPlacanja;
        this.clanID = clanID;
    }

    public long getClanarinaID() {
        return clanarinaID;
    }

    public void setClanarinaID(long clanarinaID) {
        this.clanarinaID = clanarinaID;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public int getZaGodinu() {
        return zaGodinu;
    }

    public void setZaGodinu(int zaGodinu) {
        this.zaGodinu = zaGodinu;
    }

    public boolean isIsplaceno() {
        return isplaceno;
    }

    public void setIsplaceno(boolean isplaceno) {
        this.isplaceno = isplaceno;
    }

    public Date getDatumPlacanja() {
        return datumPlacanja;
    }

    public void setDatumPlacanja(Date datumPlacanja) {
        this.datumPlacanja = datumPlacanja;
    }

    public long getClanID() {
        return clanID;
    }

    public void setClanID(long clanID) {
        this.clanID = clanID;
    }

    public String getZaMesec() {
        return zaMesec;
    }

    public void setZaMesec(String zaMesec) {
        this.zaMesec = zaMesec;
    }

    @Override
    public String getTableName() {
        return "clanarina";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "iznos, zaMesec, zaGodinu, isplaceno, datumPlacanja, clanID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        if (isplaceno) {
            sb.append(iznos).append(", ")
                    .append("'").append(zaMesec).append("' , ")
                    .append(zaGodinu).append(", ")
                    .append(isplaceno).append(", ")
                    .append("'").append(new java.sql.Date(datumPlacanja.getTime())).append("' , ")
                    .append(clanID);
        } else {
            sb.append(iznos).append(", ")
                    .append("'").append(zaMesec).append("', ")
                    .append(zaGodinu).append(", ")
                    .append(isplaceno).append(", ")
                    .append("NULL").append(", ")
                    .append(clanID);
        }

        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.clanarinaID = id;
    }

    @Override
    public String getUpdateValues() {
        return "iznos = " + iznos + ", zaMesec = '" + zaMesec + "', zaGodinu = " + zaGodinu + ", isplaceno = " + isplaceno + ", datumPlacanja = '" + new java.sql.Date(datumPlacanja.getTime()) + "'";
    }

    @Override
    public String getWhereCriteria() {
        return "clanID = " + clanID;
    }

    @Override
    public String getJoinText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID() {
        return "clanarinaID =  " + clanarinaID;
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        return new Clanarina(rs.getLong(getTableName() + ".clanarinaID"), rs.getBigDecimal(getTableName() + ".iznos"), rs.getString(getTableName() + ".zaMesec"), rs.getInt(getTableName() + ".zaGodinu"), rs.getBoolean(getTableName() + ".isplaceno"), rs.getDate(getTableName() + ".datumPlacanja"), rs.getLong(getTableName() + ".clanID"));
    }

}
