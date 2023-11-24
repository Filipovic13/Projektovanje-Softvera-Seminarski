///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.DbConnectionFactory;
//import repository.db.DbRepository;
//import domain.Clanarina;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// *
// * @author Sara
// */
//public class RepositoryClanarina implements DbRepository<Clanarina, Object> {
//
//    public void edit(Clanarina clanarina) throws SQLException, Exception {
//
//        connect();
//        try {
//            String upit = "UPDATE Clanarina "
//                    + "SET iznos = ?, zaMesec = ?, zaGodinu = ?, isplaceno = ?, datumPlacanja = ? "
//                    + "WHERE clanarinaID = " + clanarina.getClanarinaID();
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setBigDecimal(1, clanarina.getIznos());
//            ps.setString(2, clanarina.getZaMesec());
//            ps.setInt(3, clanarina.getZaGodinu());
//            ps.setBoolean(4, clanarina.isIsplaceno());
//            if (clanarina.isIsplaceno()) {
//                ps.setDate(5, new Date(clanarina.getDatumPlacanja().getTime()));
//            } else {
//                ps.setDate(5, null);
//            }
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
//    public void add(Clanarina novaClanarina) throws SQLException, Exception {
//
//        connect();
//        try {
//            String upit = "INSERT INTO Clanarina (iznos, zaMesec, zaGodinu, isplaceno, datumPlacanja, clanID) VALUES (?,?,?,?,?,?)";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setBigDecimal(1, novaClanarina.getIznos());
//            ps.setString(2, novaClanarina.getZaMesec());
//            ps.setInt(3, novaClanarina.getZaGodinu());
//            ps.setBoolean(4, novaClanarina.isIsplaceno());
//            ps.setDate(5, null);
//            ps.setLong(6, novaClanarina.getClanID());
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
//    public void delete(Clanarina clanarinaBrisanje) throws SQLException, Exception {
//
//        connect();
//        try {
//            String upit = "DELETE FROM Clanarina WHERE clanarinaID = ?";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setLong(1, clanarinaBrisanje.getClanarinaID());
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
//    }
//
//   
//
//    @Override
//    public List<Clanarina> getAll(Clanarina param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<Clanarina> getAllByCriteria(Clanarina param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Clanarina getOne(Clanarina param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//}
