///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.DbConnectionFactory;
//import repository.db.DbRepository;
//import domain.Prisustvo;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.TimeZone;
//
///**
// *
// * @author Sara
// */
//public class RepositoryPrisustvo implements DbRepository<Prisustvo> {
//
//    public void add(Prisustvo prisustvo) throws SQLException, Exception {
//        connect();
//        try {
//            String upit = "INSERT INTO Prisustvo (datum, clanID) VALUES (?,?)";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setDate(1, new Date(prisustvo.getDatum().getTime()));
//            ps.setLong(2, prisustvo.getClanID());
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
//    }
//
//    public List<Prisustvo> getBy(Prisustvo p) throws Exception {
//
//        List<Prisustvo> prisustva = new ArrayList<>();
//
//        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
//        cal.setTime(p.getDatum());
//
//        int godina = cal.get(Calendar.YEAR);
//        int mesec = cal.get(Calendar.MONTH);
//        mesec += 1;
//
//        connect();
//        try {
//            String upit = "SELECT * "
//                    + "FROM Prisustvo "
//                    + "WHERE clanID = " + p.getClanID() + " AND YEAR(datum) = " + godina + " AND MONTH(datum) = " + mesec;
//            Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
//            ResultSet rs = st.executeQuery(upit);
//
//            while (rs.next()) {
//                Prisustvo prisustvo = new Prisustvo(rs.getLong(1), rs.getDate(2), rs.getLong(3));
//                prisustva.add(prisustvo);
//            }
//
//            st.close();
//            rs.close();
//            return prisustva;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            disconnect();
//        }
//
//    }
//
//    public void delete(Prisustvo prisustvoBrisanje) throws SQLException, Exception {
//        connect();
//        try {
//            String upit = "DELETE FROM Prisustvo WHERE prisustvoID = ?";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setLong(1, prisustvoBrisanje.getPrisustvoID());
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
//
//    @Override
//    public void edit(Prisustvo t) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<Prisustvo> getAll(Prisustvo param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<Prisustvo> getAllByCriteria(Prisustvo param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Prisustvo getOne(Prisustvo param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//}
