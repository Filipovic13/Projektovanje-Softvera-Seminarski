/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.polaganje;

import domain.Polaganje;
import so.AbstractSO;
import validation.Validator;

/**
 *
 * @author Sara
 */
public class AddPolaganjeSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Polaganje)) {
            throw new Exception("Invalid param...");
        }

        Polaganje polaganje = (Polaganje) param;

        try {
            Validator.startValidation()
                    .validateNotNullOrEmpty(polaganje.getZaPojas(), "Polaganje za pojas mor abiti uneto")
                    .validateNotNullOrEmpty(polaganje.getDatumPolaganja().toString(), "Datum polaganja mora biti unet")
                    .validateNotNullOrEmpty(String.valueOf(polaganje.getClanID()), "Clan mora biti selektovan").throwIfInvalide();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Polaganje) param);
    }

}
