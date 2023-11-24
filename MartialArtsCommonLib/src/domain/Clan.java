/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sara
 */
public class Clan implements GenericEntity {

    private long clanID;
    private String ime;
    private String prezime;
    private String pol;
    private String telefon;
    private String adresa;
    private String pojas;

    private List<Prisustvo> prisustva;
    private List<Clanarina> clanarine;
    private List<Polaganje> polaganja;

    @Override
    public String toString() {
        return ime + " " + prezime + " (" + pojas + ")";
    }

    public Clan() {
    }

    public Clan(long clanID, String ime, String prezime, String pol, String telefon, String adresa, String pojas) {
        this.clanID = clanID;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.telefon = telefon;
        this.adresa = adresa;
        this.pojas = pojas;
        this.prisustva = new ArrayList<>();
        this.clanarine = new ArrayList<>();
        this.polaganja = new ArrayList<>();

    }

    public long getClanID() {
        return clanID;
    }

    public void setClanID(long clanID) {
        this.clanID = clanID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPojas() {
        return pojas;
    }

    public void setPojas(String pojas) {
        this.pojas = pojas;
    }

    public List<Prisustvo> getPrisustva() {
        return prisustva;
    }

    public void setPrisustva(List<Prisustvo> prisustva) {
        this.prisustva = prisustva;
    }

    public List<Clanarina> getClanarine() {
        return clanarine;
    }

    public void setClanarine(List<Clanarina> clanarine) {
        this.clanarine = clanarine;
    }

    public List<Polaganje> getPolaganja() {
        return polaganja;
    }

    public void setPolaganja(List<Polaganje> polaganja) {
        this.polaganja = polaganja;
    }

    @Override
    public String getTableName() {
        return "clan";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime, prezime, pol, telefon, adresa, pojas";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("', ")
                .append("'").append(prezime).append("', ")
                .append("'").append(pol).append("', ")
                .append("'").append(telefon).append("', ")
                .append("'").append(adresa).append("', ")
                .append("'").append(pojas).append("'");
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.clanID = id;
    }

    @Override
    public String getUpdateValues() {
        return "ime = '" + ime + "' , prezime = '" + prezime + "' , telefon = '" + telefon + "' , adresa = '" + adresa + "' , pojas = '" + pojas + "'";
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
        return "clan.clanID = " + clanID;
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        return new Clan(rs.getLong(getTableName() + ".clanID"), rs.getString(getTableName() + ".ime"), rs.getString(getTableName() + ".prezime"), rs.getString(getTableName() + ".pol"), rs.getString(getTableName() + ".telefon"), rs.getString(getTableName() + ".adresa"), rs.getString(getTableName() + ".pojas"));
    }

}
