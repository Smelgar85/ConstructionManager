/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.netbeans.validation.api.builtin.stringvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.netbeans.validation.api.Problems;

/**
 *
 * @author Sebastián Melgar Marín
 */
public class FECHAValidacion extends StringValidator {

    @Override
    public void validate(Problems prblms, String CUENTA, String t) {
        // Definimos el patrón de expresión regular para validar el DNI
        String regex = "^(1[0-2]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9])/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(t);
        if (!matcher.matches()) {
            prblms.add("Máximo 20 caracteres (solo letras)");
        }
    }
}