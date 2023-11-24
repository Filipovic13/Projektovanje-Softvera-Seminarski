/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clanarina;

import domain.Clanarina;
import so.AbstractSO;

/**
 *
 * @author Sara
 */
public class DeleteClanarinaSO extends AbstractSO {

    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Clanarina)) {
            throw new Exception("Invalid param...");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((Clanarina) param);
    }

}
