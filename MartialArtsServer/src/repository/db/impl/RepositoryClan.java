///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.DbConnectionFactory;
//import repository.db.DbRepository;
//import domain.Clan;
//import domain.Clanarina;
//import domain.GenericEntity;
//import domain.Polaganje;
//import domain.Prisustvo;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Sara
// */
//public class RepositoryClan implements DbRepository<Clan, Object> {
//
//    @Override
//    public List<Clan> getAll(Clan param) throws Exception {
//
//        List<Clan> clanovi = new ArrayList<>();
//        try {
//            String upit = "SELECT * "
//                    + "FROM Clan";
//            Statement statement = DbConnectionFactory.getInstance().getConnection().createStatement();
//            ResultSet rs = statement.executeQuery(upit);
//
//            while (rs.next()) {
//                Clan clan = new Clan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
//                clanovi.add(clan);
//            }
//
//            //PRISUSTVA
//            for (Clan clan : clanovi) {
//                List<Prisustvo> prisustva = new ArrayList<>();
//                upit = "SELECT * "
//                        + "FROM Prisustvo "
//                        + "WHERE clanID = " + clan.getClanID()
//                        + " ORDER BY datum ASC";
//                statement = DbConnectionFactory.getInstance().getConnection().createStatement();
//                rs = statement.executeQuery(upit);
//
//                while (rs.next()) {
//                    Prisustvo prisustvo = new Prisustvo(rs.getLong(1), rs.getDate(2), rs.getLong(3));
//                    prisustva.add(prisustvo);
//                }
//                clan.setPrisustva(prisustva);
//            }
//
//            //CLANARINE
//            for (Clan clan : clanovi) {
//                List<Clanarina> clanarine = new ArrayList<>();
//                upit = "SELECT * "
//                        + "FROM Clanarina "
//                        + "WHERE clanID = " + clan.getClanID();
//                statement = DbConnectionFactory.getInstance().getConnection().createStatement();
//                rs = statement.executeQuery(upit);
//
//                while (rs.next()) {
//                    Clanarina clanarina = new Clanarina(rs.getLong(1), rs.getBigDecimal(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5), rs.getDate(6), rs.getLong(7));
//                    clanarine.add(clanarina);
//                }
//                clan.setClanarine(clanarine);
//            }
//
//            //POLAGANJA
//            for (Clan clan : clanovi) {
//                List<Polaganje> polaganja = new ArrayList<>();
//                upit = "SELECT * "
//                        + "FROM Polaganje "
//                        + " WHERE clanID = " + clan.getClanID()
//                        + " ORDER BY datumPolaganja ASC";
//                statement = DbConnectionFactory.getInstance().getConnection().createStatement();
//                rs = statement.executeQuery(upit);
//
//                while (rs.next()) {
//                    Polaganje polaganje = new Polaganje(rs.getLong(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getLong(5));
//                    polaganja.add(polaganje);
//                }
//                clan.setPolaganja(polaganja);
//            }
//
//            rs.close();
//            statement.close();
//            return clanovi;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//
//    }
//
//    public void add(Clan clan) throws Exception {
//
//        connect();
//        try {
//            String upit = "INSERT INTO Clan (ime, prezime, pol, telefon, adresa, pojas) VALUES (?,?,?,?,?,?)";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setString(1, clan.getIme());
//            ps.setString(2, clan.getPrezime());
//            ps.setString(3, clan.getPol());
//            ps.setString(4, clan.getTelefon());
//            ps.setString(5, clan.getAdresa());
//            ps.setString(6, clan.getPojas());
//
//            ps.executeUpdate();
//
//            ps.close();
//            DbConnectionFactory.getInstance().getConnection().commit();
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//            throw e;
//        } finally {
//            disconnect();
//        }
//
//    }
//
//    @Override
//    public void delete(Clan clanBrisanje) throws Exception {
//
//        connect();
//        try {
//            String upit = "DELETE FROM Clan WHERE clanID = ?";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setLong(1, clanBrisanje.getClanID());
//
//            ps.executeUpdate();
//            ps.close();
//            DbConnectionFactory.getInstance().getConnection().commit();
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//            throw e;
//        } finally {
//            disconnect();
//        }
//
//    }
//
//    @Override
//    public void edit(Clan clanIzmena) throws Exception {
//
//        connect();
//        try {
//            String upit = "UPDATE Clan "
//                    + "SET ime = ?, prezime = ?, telefon = ?, adresa = ?, pojas = ? "
//                    + "WHERE clanID = ?";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setString(1, clanIzmena.getIme());
//            ps.setString(2, clanIzmena.getPrezime());
//            ps.setString(3, clanIzmena.getTelefon());
//            ps.setString(4, clanIzmena.getAdresa());
//            ps.setString(5, clanIzmena.getPojas());
//            ps.setLong(6, clanIzmena.getClanID());
//
//            ps.executeUpdate();
//
//            ps.close();
//            DbConnectionFactory.getInstance().getConnection().commit();
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//            throw e;
//        } finally {
//            disconnect();
//        }
//
//    }
//
//    @Override
//    public List<Clan> getAllByCriteria(Clan param, Object criteria) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Clan getOne(Clan param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//}
