/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author Sara
 */
public class DbRepositoryGeneric implements DbRepository<GenericEntity> {

    @Override
    public void add(GenericEntity param) throws Exception {
        try {
            System.out.println("==========================================");
            System.out.println(param.getClass());
            System.out.println(param.getTableName());
            System.out.println("==========================================");

            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(param.getTableName())
                    .append(" (").append(param.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(param.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            Long id = -1L;
            if (rsKey.next()) {
                id = rsKey.getLong(1);
                param.setId(id);
            }
            statement.close();
            rsKey.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Add item DB error: \n" + ex.getMessage());
        }
    }

    @Override
    public void edit(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ").append(param.getTableName())
                    .append(" SET ").append(param.getUpdateValues())
                    .append(" WHERE ").append(param.getID());
            String sql = sb.toString();
            System.out.println(sql);
            int broj = statement.executeUpdate(sql);
            System.out.println(broj);
            statement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Update item DB error: \n" + ex.getMessage());
        }
    }

    @Override
    public void delete(GenericEntity param) throws Exception {
        try {

            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ").append(param.getTableName())
                    .append(" WHERE ").append(param.getID());
            String sql = sb.toString();
            System.out.println(sql);
            int broj = statement.executeUpdate(sql);

            statement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Delete item DB error: \n" + ex.getMessage());
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity param) throws Exception {
        try {
            List<GenericEntity> generics = new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").append(param.getTableName());
            String sql = sb.toString();
            System.out.println("repository.db.impl.DbRepositoryGeneric.getAll(), sql je:" + sql);
            ResultSet rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                System.out.println("int i:" + ++i);
                generics.add(param.getEntity(rs));
            }
            System.out.println("repository.db.impl.DbRepositoryGeneric.getAll(), lista je:" + generics);
            statement.close();
            return generics;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("GetAll DB error: \n" + e.getMessage());
        }

    }

    @Override
    public GenericEntity getOne(GenericEntity param) throws Exception {
        GenericEntity genericEntity = null;

        Connection connection = DbConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(param.getTableName()).append(" WHERE ").append(param.getWhereCriteria());
        String sql = sb.toString();
        System.out.println(sql);
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            genericEntity = param.getEntity(rs);
        }
        statement.close();

        return genericEntity;
    }

    @Override
    public List<GenericEntity> getAllByCriteria(GenericEntity param, String whereCriteria) throws Exception {

        try {
            List<GenericEntity> generics = new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();

            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").append(param.getTableName())
                    .append(" WHERE ").append(whereCriteria);

            String sql = sb.toString();
            System.out.println("repository.db.impl.DbRepositoryGeneric.getAll(), sql je:" + sql);
            ResultSet rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                System.out.println("int i:" + ++i);
                generics.add(param.getEntity(rs));
            }
            System.out.println("repository.db.impl.DbRepositoryGeneric.getAll(), lista je:" + generics);
            statement.close();
            return generics;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("GetAllByCriteria DB error: \n" + e.getMessage());

        }

    }

    @Override
    public void changeAll(List<GenericEntity> addList, List<GenericEntity> editedList, List<GenericEntity> deletedList) throws Exception {

        try {

            for (GenericEntity oneEntity : addList) {
                add(oneEntity);
            }

            for (GenericEntity oneEntity : editedList) {
                edit(oneEntity);
            }

            for (GenericEntity oneEntity : deletedList) {
                delete(oneEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("changeAll DB error: \n" + e.getMessage());
        }

    }

}
