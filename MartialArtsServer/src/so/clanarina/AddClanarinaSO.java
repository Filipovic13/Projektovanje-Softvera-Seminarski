/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clanarina;

import domain.Clanarina;
import so.AbstractSO;
import validation.Validator;

/**
 *
 * @author Sara
 */
public class AddClanarinaSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Clanarina)) {
            throw new Exception("Invalid param...");
        }

        Clanarina clanarina = (Clanarina) param;

        try {
            Validator.startValidation()
                    .validateNotNullOrEmpty(clanarina.getIznos().toString(), "Iznos clanarine mora biti unet")
                    .validateNotNullOrEmpty(clanarina.getZaMesec(), "Mesec za koji se placa clanarina mora biti unet")
                    .validateNotNullOrEmpty(String.valueOf(clanarina.getZaGodinu()), "Godina za koju se placa clanarina mora biti uneta")
                    .validateNotNullOrEmpty(String.valueOf(clanarina.getClanID()), "Clan mora biti selektovan").throwIfInvalide();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Clanarina) param);
    }

}
