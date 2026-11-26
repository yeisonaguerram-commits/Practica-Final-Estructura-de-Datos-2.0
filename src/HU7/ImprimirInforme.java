package HU7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import HU2.ObjetoCliente;
import HU3.ObjetoVehiculo;
import HU4.ObjetoContrato;
import HU8.Validaciones;

public class ImprimirInforme {

    public String ImprimirInformes(LinkedList<ObjetoCliente> ListaCliente, LinkedList<ObjetoVehiculo> ListaVehiculo,
            Queue<ObjetoContrato> ListaContrato, Scanner sc, Validaciones V) {

        System.out.println("==========================================");
        System.out.println("       INFORME GENERAL DEL SISTEMA");
        System.out.println("==========================================");

        Generarinforme(ListaCliente);
        Generarinforme(ListaVehiculo, true);
        Generarinforme(ListaContrato);

        System.out.println("==========================================");
        return "Informe generado correctamente.";
    }

    public String Generarinforme(LinkedList<ObjetoCliente> ListaCliente) {
        System.out.println("--- 1. LISTADO DE CLIENTES (" + ListaCliente.size() + ") ---");
        if (ListaCliente.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return "Sin clientes";
        }

        for (ObjetoCliente c : ListaCliente) {
            System.out.println("Cedula: " + c.getCedula() + " | Nombre: " + c.getNombreCliente() + " "
                    + c.getApellidoCliente() + " | Tel: " + c.getTelefono() + " | Licencia: " + c.getLicencia());
        }
        return "Clientes listados";
    }

    public String Generarinforme(LinkedList<ObjetoVehiculo> ListaVehiculo, boolean esVehiculo) {
        System.out.println("--- 2. LISTADO DE VEHICULOS (" + ListaVehiculo.size() + ") ---");
        if (ListaVehiculo.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return "Sin vehiculos";
        }

        for (ObjetoVehiculo v : ListaVehiculo) {
            String detalle = v.getTipoVehiculo().equalsIgnoreCase("Sedan")
                    ? "Combustible: " + v.getTipoCombustible() + " | Transmision: " + v.getTransmision()
                    : "Traccion: " + v.getTraccion() + " | Maletero: " + v.getCapacidadMaletero() + "L";

            System.out.println("Placa: " + v.getPlaca() + " | " + v.getTipoVehiculo() + " " + v.getMarca() + " ("
                    + v.getModelo() + ") | $" + v.getPrecioDiario() + "/dia | Estado: " + v.getEstado() + " | "
                    + detalle);
        }
        return "Vehiculos listados";
    }

    public String Generarinforme(Queue<ObjetoContrato> ListaContrato) {
        System.out.println("--- 3. CONTRATOS Y TOTAL DE INGRESOS ---");
        if (ListaContrato.isEmpty()) {
            System.out.println("No hay contratos registrados.");
            System.out.println("TOTAL INGRESOS GENERADOS: $0.0");
            return "Sin contratos";
        }

        Queue<ObjetoContrato> colaAux = new LinkedList<>();
        double totalIngresos = 0;

        System.out.println(">> CONTRATOS ACTIVOS:");
        boolean hayActivos = false;
        while (!ListaContrato.isEmpty()) {
            ObjetoContrato c = ListaContrato.poll();
            if (c.getEstado().equalsIgnoreCase("Activo")) {
                hayActivos = true;
                System.out.println("ID: " + c.getIDcontrato() + " | Cedula: " + c.getCedulaCliente() + " | Placa: "
                        + c.getPlacaVehiculo() + " | Inicio: " + c.getFechaInicio() + " | Fin: " + c.getFechaFin()
                        + " | Dias: " + c.getTotalDias() + " | Total: $" + c.getValorTotal());
            }
            totalIngresos += c.getValorTotal();
            colaAux.add(c);
        }
        if (!hayActivos) {
            System.out.println("   (Ninguno)");
        }

        System.out.println("\n>> CONTRATOS FINALIZADOS:");
        boolean hayFinalizados = false;
        while (!colaAux.isEmpty()) {
            ObjetoContrato c = colaAux.poll();
            if (c.getEstado().equalsIgnoreCase("Finalizado")) {
                hayFinalizados = true;
                System.out.println("ID: " + c.getIDcontrato() + " | Cedula: " + c.getCedulaCliente() + " | Placa: "
                        + c.getPlacaVehiculo() + " | Inicio: " + c.getFechaInicio() + " | Fin: " + c.getFechaFin()
                        + " | Dias: " + c.getTotalDias() + " | Total: $" + c.getValorTotal());
            }
            ListaContrato.add(c);
        }
        if (!hayFinalizados) {
            System.out.println("   (Ninguno)");
        }

        System.out.println("------------------------------------------");
        System.out.println("TOTAL DE INGRESOS GENERADOS POR RENTING: $" + totalIngresos);
        System.out.println("------------------------------------------");

        return "Contratos listados";
    }
}
