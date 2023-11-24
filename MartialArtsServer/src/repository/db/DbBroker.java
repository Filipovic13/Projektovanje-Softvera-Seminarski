///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db;
//
//import domain.Clan;
//import domain.Clanarina;
//import domain.Polaganje;
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
//public class DbBroker {
//
//    public  List<Clan> vratiClanove() {
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
//        }
//        return null;
//    }
//    // check
//
//    public boolean unesiNovogClana(Clan clan) throws SQLException, Exception {
//
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
//            return true;
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//    //check
//
//    public boolean unesiPrisustvo(Prisustvo prisustvo) throws SQLException, Exception {
//
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
//            return true;
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//    //check
//
//    public List<Prisustvo> pretraziPrisustvo(Prisustvo p) {
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
//        }
//        return null;
//    }
//    //check
//
//    public boolean izmeniZaduzenje(Clanarina clanarina) throws SQLException, Exception {
//
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
//            return true;
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//    //check
//
//    public boolean unesiNovoZaduzenje(Clanarina novaClanarina) throws SQLException, Exception {
//
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
//            return true;
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//    //check
//
//    public boolean unesiPolaganje(Polaganje novoPolaganje) throws SQLException, Exception {
//
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
//            return true;
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//    //check
//
//    public boolean obrisiZaduzenje(Clanarina clanarinaBrisanje) throws SQLException, Exception {
//
//        try {
//            String upit = "DELETE FROM Clanarina WHERE clanarinaID = ?";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setLong(1, clanarinaBrisanje.getClanarinaID());
//
//            ps.executeUpdate();
//            ps.close();
//            DbConnectionFactory.getInstance().getConnection().commit();
//            return true;
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//        return false;
//    }
//    //check
//
//    public boolean obrisiClana(Clan clanBrisanje) throws SQLException, Exception {
//
//        try {
//            String upit = "DELETE FROM Clan WHERE clanID = ?";
//            PreparedStatement ps = DbConnectionFactory.getInstance().getConnection().prepareStatement(upit);
//
//            ps.setLong(1, clanBrisanje.getClanID());
//
//            ps.executeUpdate();
//            ps.close();
//            DbConnectionFactory.getInstance().getConnection().commit();
//            return true;
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//    //check
//
//    public boolean izmeniClana(Clan clanIzmena) throws SQLException, Exception {
//
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
//            return true;
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//    //izmeni clana
//
//    public boolean obrisiPrisustvo(Prisustvo prisustvoBrisanje) throws SQLException, Exception {
//
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
//            return true;
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//    //check
//
//    public boolean izmeniPolaganje(Polaganje polaganjeIzmena) throws SQLException, Exception {
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
//            return true;
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().rollback();
//            e.printStackTrace();
//        }
//        return false;
//    }
//    //check
//
//    public boolean obrisiPolaganje(Polaganje polaganjeBrisanje) throws SQLException, Exception {
//
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
//            return true;
//
//        } catch (Exception e) {
//            DbConnectionFactory.getInstance().getConnection().commit();
//            e.printStackTrace();
//        }
//        return false;
//    }
//    //check
//
//}
