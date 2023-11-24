/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clan;

import domain.Clan;
import so.AbstractSO;
import validation.Validator;

/**
 *
 * @author Sara
 */
public class AddClanSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Clan)) {
            throw new Exception("Invalid param...");
        }

        Clan clan = (Clan) param;

        try {
            Validator.startValidation()
                    .validateNotNullOrEmpty(clan.getIme(), "Ime ne sme biti prazno")
                    .validateNotNullOrEmpty(clan.getPrezime(), "Prezime ne sme biti prazno")
                    .validateNotNullOrEmpty(clan.getPol(), "Pol mora biti selektovan")
                    .validateNotNullOrEmpty(clan.getTelefon(), "Telefon mora biti unet")
                    .validateNotNullOrEmpty(clan.getAdresa(), "Adresa mora biti uneta")
                    .validateNotNullOrEmpty(clan.getPojas(), "Pojas mora biti unet").throwIfInvalide();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Clan) param);
    }

}
