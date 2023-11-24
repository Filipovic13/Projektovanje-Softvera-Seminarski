/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.korisnik;

import domain.Korisnik;
import so.AbstractSO;
import validation.Validator;

/**
 *
 * @author Sara
 */
public class LoginSO extends AbstractSO {

    private Korisnik korisnik;

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Korisnik)) {
            throw new Exception("Invalid param...");
        }

        Korisnik k = (Korisnik) param;

        try {
            Validator.startValidation()
                    .validateNotNullOrEmpty(k.getUsername(), "Username mora biti unet")
                    .validateNotNullOrEmpty(k.getPassword(), "Password mora biti unet!").throwIfInvalide();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        korisnik = (Korisnik) repository.getOne(param);
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

}
