/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clanarina;

import domain.Clanarina;
import domain.IzmenaClanarina;
import so.AbstractSO;

/**
 *
 * @author Sara
 */
public class ChangeAllClanarinaSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        IzmenaClanarina izmene = (IzmenaClanarina) param;
        
        
        if (!izmene.getZaAdd().isEmpty()) {
            for (Clanarina clanarina : izmene.getZaEdit()) {
                if (clanarina == null || !(clanarina instanceof Clanarina)) {
                    throw new Exception("Invalid param...");
                }
            }
        }

        if (!izmene.getZaEdit().isEmpty()) {
            for (Clanarina clanarina : izmene.getZaEdit()) {
                if (clanarina == null || !(clanarina instanceof Clanarina)) {
                    throw new Exception("Invalid param...");
                }
            }
        }

        if (!izmene.getZaDelete().isEmpty()) {
            for (Clanarina clanarina : izmene.getZaDelete()) {
                if (clanarina == null || !(clanarina instanceof Clanarina)) {
                    throw new Exception("Invalid param...");
                }
            }
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.changeAll(((IzmenaClanarina) param).getZaAdd(), ((IzmenaClanarina) param).getZaEdit(), ((IzmenaClanarina) param).getZaDelete());
    }

}
