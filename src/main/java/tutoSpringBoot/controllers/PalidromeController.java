package tutoSpringBoot.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Práctica propuesta como ejercicio en el tutorial de Spring
 */
@RestController
public class PalidromeController {

    /**
     * Muestra el mensaje si es un palindromo
     * 
     * @param word la palabra a comprobar
     * @return Un texto que indica si es palindromo o no la palabra
     */
    @GetMapping("/validar-palidromo/{word}")
    public String palindrome(@PathVariable String word) {
        var flag = " ";
        if (!isPalidrome(word)) {
            flag = " NO ";
        }

        return "La palabra " + word + flag + "es un palíndromo";
    }

    /**
     * Comprueba si la palabra es un palindromo
     * 
     * @param word la palabra a comprobar
     * @return True si es palíndromo o false
     */
    private boolean isPalidrome(String word) {
        int length = word.length();

        // Si la mitad es igual, es un palíndromo
        for (int i = 0; i < length / 2; i++) {
            // Si el caracter es distinto del caracter opuesto
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}