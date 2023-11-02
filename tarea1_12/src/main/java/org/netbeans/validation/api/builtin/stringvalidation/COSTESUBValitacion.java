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
public class COSTESUBValitacion extends StringValidator {

    @Override
    public void validate(Problems prblms, String CUENTA, String t) {
        // Definimos el patrón de expresión regular para validar el coste
        String regex = "[0-8]?[0-9](\\.[0][0]?)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(t);
        if (!matcher.matches()) {
            prblms.add("Máximo 80.00€");
        }
    }
}