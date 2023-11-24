/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sara
 */
public class IzmenaClanarina implements GenericEntity {

    private List<Clanarina> zaAdd;
    private List<Clanarina> zaEdit;
    private List<Clanarina> zaDelete;

    public IzmenaClanarina() {
    }

    public IzmenaClanarina(List<Clanarina> zaAdd, List<Clanarina> zaEdit, List<Clanarina> zaDelete) {
        this.zaAdd = zaAdd;
        this.zaEdit = zaEdit;
        this.zaDelete = zaDelete;
    }

    public List<Clanarina> getZaEdit() {
        return zaEdit;
    }

    public void setZaEdit(List<Clanarina> zaEdit) {
        this.zaEdit = zaEdit;
    }

    public List<Clanarina> getZaDelete() {
        return zaDelete;
    }

    public void setZaDelete(List<Clanarina> zaDelete) {
        this.zaDelete = zaDelete;
    }

    public List<Clanarina> getZaAdd() {
        return zaAdd;
    }

    public void setZaAdd(List<Clanarina> zaAdd) {
        this.zaAdd = zaAdd;
    }

    @Override
    public String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCriteria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
