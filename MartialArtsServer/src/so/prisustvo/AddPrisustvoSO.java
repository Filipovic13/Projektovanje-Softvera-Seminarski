/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.prisustvo;

import domain.Prisustvo;
import so.AbstractSO;
import validation.Validator;

/**
 *
 * @author Sara
 */
public class AddPrisustvoSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Prisustvo)) {
            throw new Exception("Invalid param...");
        }
        Prisustvo prisustvo = (Prisustvo) param;

        try {
            Validator.startValidation()
                    .validateNotNullOrEmpty(prisustvo.getDatum().toString(), "Datum prisustvovanja na treningu mora biti unet").throwIfInvalide();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Prisustvo) param);
    }

}
