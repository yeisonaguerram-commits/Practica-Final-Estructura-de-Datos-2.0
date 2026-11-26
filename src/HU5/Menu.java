package HU5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import HU2.ObjetoCliente;
import HU8.Validaciones;
import HU3.ObjetoVehiculo;
import HU4.ObjetoContrato;
import HU6.GestorCliente;
import HU6.GestorVehiculo;
import HU6.GestorContrato;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Validaciones V = new Validaciones();
    LinkedList<ObjetoCliente> ListaCliente = new LinkedList<>();
    LinkedList<ObjetoVehiculo> ListaVehiculo = new LinkedList<>();
    Queue<ObjetoContrato> ListaContrato = new LinkedList<>();
    GestorCliente GC = new GestorCliente();
    GestorVehiculo GV = new GestorVehiculo();
    GestorContrato GCo = new GestorContrato();

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
                    System.out.println(GestorCliente());
                    ;
                    break;
                case 2:
                    System.out.println(GestorVehiculo());
                    break;
                case 3:
                    System.out.println(GestorContrato());
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

    public String GestorCliente() {
        boolean continuar = true;

        do {
            System.out.println("==========================================");
            System.out.println("     GESTION DE CLIENTES");
            System.out.println("==========================================");
            System.out.println("1. REGISTRAR CLIENTE");
            System.out.println("2. MODIFICAR CLIENTE");
            System.out.println("3. ELIMINAR CLIENTE");
            System.out.println("4. BUSCAR CLIENTE");
            System.out.println("5. VOLVER AL MENU PRINCIPAL");
            System.out.println("");
            System.out.print("Seleccione una opción: ");

            int opt = V.ValidarEntero(sc);

            switch (opt) {
                case 1:
                    GC.IngresarCliente(ListaCliente, sc, V);
                    break;
                case 2:
                    GC.ModificarCliente(ListaCliente, sc, V);
                    break;
                case 3:
                    GC.EliminarCliente(ListaCliente, sc, V);
                    break;
                case 4:
                    GC.BuscarCliente(ListaCliente, sc, V);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    break;
            }
        } while (continuar);
        return "Regresando a menu principal";
    }

    public String GestorVehiculo() {
        boolean continuar = true;

        do {
            System.out.println("==========================================");
            System.out.println("     GESTION DE VEHICULOS");
            System.out.println("==========================================");
            System.out.println("1. REGISTRAR VEHICULO");
            System.out.println("2. MODIFICAR VEHICULO");
            System.out.println("3. ELIMINAR VEHICULO");
            System.out.println("4. BUSCAR VEHICULO");
            System.out.println("5. VOLVER AL MENU PRINCIPAL");
            System.out.println("");
            System.out.print("Seleccione una opción: ");

            int opt = V.ValidarEntero(sc);

            switch (opt) {
                case 1:
                    GV.IngresarVehiculo(ListaVehiculo, sc, V);
                    break;
                case 2:
                    GV.ModificarVehiculo(ListaVehiculo, sc, V);
                    break;
                case 3:
                    GV.EliminarVehiculo(ListaVehiculo, sc, V);
                    break;
                case 4:
                    GV.BuscarVehiculo(ListaVehiculo, sc, V);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    break;
            }
        } while (continuar);
        return "Regresando a menu principal";
    }

    public String GestorContrato() {
        boolean continuar = true;

        do {
            System.out.println("==========================================");
            System.out.println("     GESTION DE CONTRATOS");
            System.out.println("==========================================");
            System.out.println("1. REGISTRAR NUEVO CONTRATO");
            System.out.println("2. MODIFICAR CONTRATO");
            System.out.println("3. FINALIZAR CONTRATO");
            System.out.println("4. BUSCAR CONTRATO");
            System.out.println("5. VOLVER AL MENU PRINCIPAL");
            System.out.println("");
            System.out.print("Seleccione una opción: ");

            int opt = V.ValidarEntero(sc);

            switch (opt) {
                case 1:
                    GCo.RegistrarContrato(ListaContrato, ListaCliente, ListaVehiculo, sc, V);
                    break;
                case 2:
                    GCo.ModificarContrato(ListaContrato, ListaCliente, ListaVehiculo, sc, V);
                    break;
                case 3:
                    GCo.FinalizarContrato(ListaContrato, ListaCliente, ListaVehiculo, sc, V);
                    break;
                case 4:
                    GCo.BuscarContrato(ListaContrato, ListaCliente, ListaVehiculo, sc, V);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    break;
            }
        } while (continuar);
        return "Regresando a menu principal";
    }
}
