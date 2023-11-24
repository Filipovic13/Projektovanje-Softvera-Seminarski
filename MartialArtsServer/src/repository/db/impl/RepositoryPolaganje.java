///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.DbConnectionFactory;
//import repository.db.DbRepository;
//import domain.Polaganje;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// *
// * @author Sara
// */
//public class RepositoryPolaganje implements DbRepository<Polaganje> {
//
//    public void add(Polaganje novoPolaganje) throws SQLException, Exception {
//
//        connect();
//        try {
//            String upit = "INSERT INTO Polaganje (zaPojas, polozeno, datumPolaganja, clanID) VALUES (?,?,?,?)";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setString(1, novoPolaganje.getZaPojas());
//            ps.setBoolean(2, novoPolaganje.isPolozeno());
//            ps.setDate(3, new Date(novoPolaganje.getDatumPolaganja().getTime()));
//            ps.setLong(4, novoPolaganje.getClanID());
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
//    public void edit(Polaganje polaganjeIzmena) throws SQLException, Exception {
//        connect();
//        try {
//            String upit = "UPDATE Polaganje "
//                    + "SET zaPojas = ?, polozeno = ?, datumPolaganja = ? "
//                    + "WHERE polaganjeID = ?";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setString(1, polaganjeIzmena.getZaPojas());
//            ps.setBoolean(2, polaganjeIzmena.isPolozeno());
//            ps.setDate(3, new Date(polaganjeIzmena.getDatumPolaganja().getTime()));
//            ps.setLong(4, polaganjeIzmena.getPolaganjeID());
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
//    public void delete(Polaganje polaganjeBrisanje) throws SQLException, Exception {
//
//        connect();
//        try {
//            String upit = "DELETE FROM Polaganje WHERE polaganjeID = ?";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setLong(1, polaganjeBrisanje.getPolaganjeID());
//
//            ps.executeUpdate();
//
//            ps.close();
//            DbConnectionFactory.getInstance().getConnection().commit();
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().commit();
//            e.printStackTrace();
//            throw e;
//        } finally {
//            disconnect();
//        }
//    }
//
//   
//
//    @Override
//    public List<Polaganje> getAll(Polaganje param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<Polaganje> getAllByCriteria(Polaganje param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Polaganje getOne(Polaganje param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}
