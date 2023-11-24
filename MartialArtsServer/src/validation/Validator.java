/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Sara
 */
public class Validator {

    private final List<String> validationErros;

    private Validator() {
        validationErros = new ArrayList<>();
    }

    public static Validator startValidation() {
        return new Validator();
    }

    public Validator validateNotNull(Object o, String errorMessage) throws Exception {
        if (o == null) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }

    public Validator validateNotNullOrEmpty(String value, String errorMessage) throws Exception {
        if (value == null || value.trim().isEmpty()) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }

    public void throwIfInvalide() throws Exception {
        if (!validationErros.isEmpty()) {
            throw new Exception(this.validationErros.stream().collect(Collectors.joining("\n")));
        }
    }
}
