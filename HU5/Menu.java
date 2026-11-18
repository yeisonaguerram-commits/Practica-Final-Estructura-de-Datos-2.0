package HU5;

import java.util.Scanner;

import HU8.Validaciones;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Validaciones V = new Validaciones();

    public int MenuPrincipal() {
        int Opcion = 0;
        boolean continuar = true;

        do {
            System.out.println("==========================================");
            System.out.println("     SISTEMA DE RENTING DE CARROS");
            System.out.println("==========================================");
            System.out.println("1. GESTIÓN DE CLIENTES");
            System.out.println("2. GESTIÓN DE VEHÍCULOS");
            System.out.println("3. GESTIÓN DE CONTRATOS DE RENTING");
            System.out.println("4. IMPRIMIR INFORME GENERAL");
            System.out.println("5. SALIR DEL SISTEMA");
            System.out.println("");
            System.out.print("Seleccione una opción: ");

                Opcion = V.ValidarEntero(sc);

                switch (Opcion) {
                    case 1:
                        System.out.println("Hola");
                        break;
                    case 2:
                        System.out.println("hola");
                        break;
                    case 3:
                        System.out.println("hola");
                        break;
                    case 4:
                        System.out.println("[Aquí se llamará al Informe General de HU7]");
                        break;
                    case 5:
                        System.out.println("saliendo del sistema... ¡Hasta pronto!");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Error: Opción inválida. Elija un número entre 1 y 5.");
                }

        } while (continuar);

        return Opcion;
    }

}
