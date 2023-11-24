/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import constant.MyServerConstants;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Sara
 */
public class DbConnectionFactory {

    private static DbConnectionFactory instance;
    private Connection connection;

    private DbConnectionFactory() {

    }

    public static DbConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DbConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        try {
            if (connection == null || connection.isClosed()) {

                //Class.forName("com.mysql.cj.jdbc.Driver"); ... nekad bilo NEOPHODNO
                Properties properties = new Properties(); //propertie treba da napunoimo sa podacima iz nekog fajla
                properties.load(new FileInputStream("config/dbconfig.properties"));

                String url = properties.getProperty(MyServerConstants.DB_CONFIG_URL);
                String username = properties.getProperty(MyServerConstants.DB_CONFIG_USERNAME);
                String password = properties.getProperty(MyServerConstants.DB_CONFIG_USERNAME);

                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);

                System.out.println("Uspensa konekcija!");
            }
        } catch (Exception e) {
            System.out.println("Neuspensa konekcija na bazu!\n" + e.getMessage());
            throw e;
        }
        return connection;
    }

}
