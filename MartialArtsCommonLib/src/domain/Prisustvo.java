/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Sara
 */
public class Prisustvo implements GenericEntity {

    private long prisustvoID;
    private Date datum;
    private long clanID;

    public Prisustvo() {
    }

    public Prisustvo(long prisustvoID, Date datum, long clanID) {
        this.prisustvoID = prisustvoID;
        this.datum = datum;
        this.clanID = clanID;
    }

    public long getPrisustvoID() {
        return prisustvoID;
    }

    public void setPrisustvoID(long prisustvoID) {
        this.prisustvoID = prisustvoID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public long getClanID() {
        return clanID;
    }

    public void setClanID(long clanID) {
        this.clanID = clanID;
    }

    @Override
    public String getTableName() {
        return "prisustvo";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "datum, clanID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(new java.sql.Date(datum.getTime())).append("', ")
                .append(clanID);
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.prisustvoID = id;
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCriteria() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(datum);
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println((cal.get(Calendar.MONTH) + 1));
        return "clanID = " + clanID + " AND YEAR(datum) = " + cal.get(Calendar.YEAR) + " AND MONTH(datum) = " + (cal.get(Calendar.MONTH) + 1);
    }

    @Override
    public String getJoinText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID() {
        return "prisustvo.prisustvoID = " + prisustvoID;
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        return new Prisustvo(rs.getLong(getTableName() + ".prisustvoID"), rs.getDate(getTableName() + ".datum"), rs.getLong(getTableName() + ".clanID"));
    }

}
