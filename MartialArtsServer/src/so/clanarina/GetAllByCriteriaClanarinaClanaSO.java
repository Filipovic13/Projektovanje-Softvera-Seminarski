/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clanarina;

import domain.Clan;
import domain.Clanarina;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Sara
 */
public class GetAllByCriteriaClanarinaClanaSO extends AbstractSO {

    private List<Clanarina> listaClanrina;

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Clan)) {
            throw new Exception("Invalid param...");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        listaClanrina = repository.getAllByCriteria(new Clanarina(), ((Clan) param).getWhereCriteria());
    }

    public List<Clanarina> getListaClanrina() {
        return listaClanrina;
    }

}
