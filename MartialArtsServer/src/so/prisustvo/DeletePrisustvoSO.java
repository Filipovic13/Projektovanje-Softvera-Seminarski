/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.prisustvo;

import domain.Prisustvo;
import so.AbstractSO;

/**
 *
 * @author Sara
 */
public class DeletePrisustvoSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Prisustvo)) {
            throw new Exception("Invalid param...");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete((Prisustvo) param);
    }

}
