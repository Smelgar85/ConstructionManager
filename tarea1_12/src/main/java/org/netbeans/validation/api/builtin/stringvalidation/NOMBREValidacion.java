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
public class NOMBREValidacion extends StringValidator {

    @Override
    public void validate(Problems prblms, String CUENTA, String t) {
        // Definimos el patrón de expresión regular para validar el DNI
        String regex = "[A-Za-zÁáÉéÍíÓóÚúÑñ ]{1,20}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(t);
        if (!matcher.matches()) {
            prblms.add("Nombre: Máximo 20 caracteres (solo letras)");
        }
    }
}