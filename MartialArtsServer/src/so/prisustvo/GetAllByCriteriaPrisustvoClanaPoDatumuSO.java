/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.prisustvo;

import domain.Prisustvo;
import java.util.List;
import so.AbstractSO;
import validation.Validator;

/**
 *
 * @author Sara
 */
public class GetAllByCriteriaPrisustvoClanaPoDatumuSO extends AbstractSO {

    private List<Prisustvo> listaPrisustva;

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
        listaPrisustva = repository.getAllByCriteria((Prisustvo) param, ((Prisustvo) param).getWhereCriteria());
    }

    public List<Prisustvo> getListaPrisustva() {
        return listaPrisustva;
    }

}
