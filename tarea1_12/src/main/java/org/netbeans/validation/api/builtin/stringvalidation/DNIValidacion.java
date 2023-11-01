/*
 * Cambia nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para modificar esta licencia
 * Cambia nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar esta plantilla
 */
package org.netbeans.validation.api.builtin.stringvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.netbeans.validation.api.Problems;

/**
 *
 * Autor: Sebastián Melgar Marín
 */

public class DNIValidacion extends StringValidator {

    @Override
    public void validate(Problems prblms, String DNI, String t) {
        // Definimos el patrón de expresión regular para validar el DNI
        String regex = "[0-9]{8}[A-Za-z]{1}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(t);
        if (!matcher.matches()) {
            prblms.add("El DNI no tiene el formato correcto (8 números seguidos de una letra).");
        }
    }
}
