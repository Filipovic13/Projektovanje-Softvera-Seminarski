/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.polaganje;

import domain.Polaganje;
import so.AbstractSO;

/**
 *
 * @author Sara
 */
public class DeletePolaganjeSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Polaganje)) {
            throw new Exception("Invalid param...");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((Polaganje) param);
    }

}
