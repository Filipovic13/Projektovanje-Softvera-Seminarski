/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.prisustvo;

import domain.Clan;
import domain.Prisustvo;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Sara
 */
public class GetAllByCriteriaPrisustvoClanaSO extends AbstractSO {

    private List<Prisustvo> listaPrisustva;

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Clan)) {
            throw new Exception("Invalid param...");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        listaPrisustva = repository.getAllByCriteria(new Prisustvo(),((Clan) param).getWhereCriteria() );
    }

    public List<Prisustvo> getListaPrisustva() {
        return listaPrisustva;
    }

}
