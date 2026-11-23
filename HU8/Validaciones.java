package HU8;

import java.util.Scanner;

public class Validaciones {

    public int ValidarEntero(Scanner sc) {
        try {
            String entrada = sc.nextLine().trim();
            if (entrada.isEmpty()) {
                return ValidarEntero(sc);
            }
            int numero = Integer.parseInt(entrada);
            if (numero < 0) {
                System.out.println("Por favor, ingrese un número positivo:");
                return ValidarEntero(sc);
            }
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un dígito numérico válido:");
            return ValidarEntero(sc);
        }
    }

    public Double ValidarDecimal(Scanner sc) {
        try {
            String entrada = sc.nextLine().trim();
            if (entrada.isEmpty()) {
                return ValidarDecimal(sc);
            }
            double numero = Double.parseDouble(entrada);
            if (numero <= 0) {
                System.out.println("Por favor, ingrese un valor mayor a cero:");
                return ValidarDecimal(sc);
            }
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un dígito decimal válido (use punto para decimales):");
            return ValidarDecimal(sc);
        }
    }

    public String ValidarTextoAlfabetico(Scanner sc) {
        String entrada = sc.nextLine().trim();
        if (entrada.isEmpty()) {
            System.out.println("El campo no puede estar vacío. Ingrese un texto válido:");
            return ValidarTextoAlfabetico(sc);
        }
        if (!verificarSoloLetras(entrada, 0)) {
            System.out.println("Error: El texto no debe contener números ni caracteres especiales. Intente de nuevo:");
            return ValidarTextoAlfabetico(sc);
        }
        return entrada;
    }

    public String ValidarAlfaNumerico(Scanner sc) {
        String entrada = sc.nextLine().trim();
        if (entrada.isEmpty()) {
            System.out.println("El campo no puede estar vacío. Ingrese un dato válido:");
            return ValidarAlfaNumerico(sc);
        }
        if (!verificarLetrasYNumeros(entrada, 0)) {
            System.out
                    .println("Error: No se permiten caracteres especiales (solo letras y números). Intente de nuevo:");
            return ValidarAlfaNumerico(sc);
        }
        return entrada;
    }

    public String ValidarTextoLibre(Scanner sc) {
        String entrada = sc.nextLine().trim();
        if (entrada.isEmpty()) {
            System.out.println("El campo no puede estar vacío. Por favor ingrese la información:");
            return ValidarTextoLibre(sc);
        }
        return entrada;
    }

    private boolean verificarSoloLetras(String texto, int indice) {
        if (indice == texto.length())
            return true;
        char c = texto.charAt(indice);
        if (!Character.isLetter(c) && c != ' ')
            return false;
        return verificarSoloLetras(texto, indice + 1);
    }

    private boolean verificarLetrasYNumeros(String texto, int indice) {
        if (indice == texto.length())
            return true;
        char c = texto.charAt(indice);
        if (!Character.isLetterOrDigit(c))
            return false;
        return verificarLetrasYNumeros(texto, indice + 1);
    }

    public String ValidarSoloNumeros(Scanner sc) {
    String entrada = sc.nextLine().trim();
    if (entrada.isEmpty()) {
        System.out.println("El campo no puede estar vacío. Ingrese solo números:");
        return ValidarSoloNumeros(sc);
    }
    if (!verificarSoloDigitos(entrada, 0)) {
        System.out.println("Error: Solo se permiten números. Intente de nuevo:");
        return ValidarSoloNumeros(sc);
    }
    return entrada;
}

private boolean verificarSoloDigitos(String texto, int indice) {
    if (indice == texto.length())
        return true;
    char c = texto.charAt(indice);
    if (!Character.isDigit(c))
        return false;
    return verificarSoloDigitos(texto, indice + 1);
}
}