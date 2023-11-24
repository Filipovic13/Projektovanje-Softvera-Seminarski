/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.polaganje;

import domain.Clan;
import domain.Polaganje;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Sara
 */
public class GetAllByCriteriaPolaganjeClanaSO extends AbstractSO {

    private List<Polaganje> listaPolaganja;

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Clan)) {
            throw new Exception("Invalid param...");
        }
    }

    protected void executeOperation(Object param) throws Exception {
        listaPolaganja = repository.getAllByCriteria(new Polaganje(), ((Clan) param).getWhereCriteria());
    }

    public List<Polaganje> getListaPolaganja() {
        return listaPolaganja;
    }

}
