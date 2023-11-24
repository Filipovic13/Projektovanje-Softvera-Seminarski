/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clan;

import domain.Clan;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Sara
 */
public class GetAllClanSO extends AbstractSO {

    private List<Clan> listaClanova;

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Clan)) {
            throw new Exception("Invalid param...");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        listaClanova = repository.getAll(new Clan());
    }

    public List<Clan> getListaClanova() {
        return listaClanova;
    }

  
}
