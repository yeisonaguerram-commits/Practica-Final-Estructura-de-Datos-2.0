package HU6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import HU2.ObjetoCliente;
import HU3.ObjetoVehiculo;
import HU4.ObjetoContrato;
import HU8.Validaciones;

public class GestorContrato {
    private int ContadorID = 1000;

    public Queue<ObjetoContrato> RegistrarContrato(Queue<ObjetoContrato> ListaContrato,
            LinkedList<ObjetoCliente> ListaCliente, LinkedList<ObjetoVehiculo> ListaVehiculo, Scanner sc,
            Validaciones V) {
        ObjetoContrato NuevoContrato = new ObjetoContrato();

        if (ListaCliente == null) {
            System.out.println("Sin clientes ingresados a sistema");
            return ListaContrato;
        } else if (ListaVehiculo == null) {
            System.out.println("Sin Vehiculos ingresados a sistema");
            return ListaContrato;
        }

        System.out.println("---------------------");
        System.out.println("CREACION DE CONTRATO");
        System.out.println("------------------------");

        System.out.println("Digite la Cedula del ciente a realizar contrato");
        String Cedula = V.ValidarAlfaNumerico(sc);

        ObjetoCliente clienteEncontrado = ValidarCliente(ListaCliente, ListaContrato, Cedula);
        if (clienteEncontrado == null) {
            return ListaContrato;
        }
        NuevoContrato.setCedulaCliente(clienteEncontrado.getCedula());

        System.out.println("Digite la Placa del vehiculo a alquilar:");
        String Placa = V.ValidarAlfaNumerico(sc);

        ObjetoVehiculo vehiculoEncontrado = ValidarVehiculo(ListaVehiculo, Placa);
        if (vehiculoEncontrado == null) {
            return ListaContrato;
        }
        NuevoContrato.setPlacaVehiculo(vehiculoEncontrado.getPlaca());

        System.out.println("Ingrese la fecha de inicio (ej. 25/11/2026):");
        String FechaInicio = V.ValidarTextoLibre(sc);
        NuevoContrato.setFechaInicio(FechaInicio);

        System.out.println("Ingrese la fecha de fin (ej. 30/11/2026):");
        String FechaFin = V.ValidarTextoLibre(sc);
        NuevoContrato.setFechaFin(FechaFin);

        System.out.println("Ingrese el total de dias de alquiler:");
        int TotalDias = V.ValidarEntero(sc);
        NuevoContrato.setTotalDias(TotalDias);

        double ValorTotal = TotalDias * vehiculoEncontrado.getPrecioDiario();
        NuevoContrato.setValorTotal(ValorTotal);

        String Idgenerado = "Con" + ContadorID;
        ContadorID++;
        NuevoContrato.setIDcontrato(Idgenerado);

        NuevoContrato.setEstado("Activo");

        ListaContrato.add(NuevoContrato);

        return ListaContrato;
    }

    public ObjetoCliente ValidarCliente(LinkedList<ObjetoCliente> ListaCliente,

            Queue<ObjetoContrato> ListaContrato, String Cedula) {

        ObjetoCliente clienteEncontrado = null;

        for (ObjetoCliente cliente : ListaCliente) {
            if (cliente.getCedula().equalsIgnoreCase(Cedula)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("No se encontro ningun cliente con esa cedula");
            return null;
        }

        System.out.println("Cliente encontrado:");
        System.out.println("Nombre: " + clienteEncontrado.getNombreCliente());
        System.out.println("Apellido: " + clienteEncontrado.getApellidoCliente());
        System.out.println("Telefono: " + clienteEncontrado.getTelefono());
        System.out.println("Licencia: " + clienteEncontrado.getLicencia());

        Queue<ObjetoContrato> colaAux = new LinkedList<>();
        boolean tieneContratoActivo = false;

        while (!ListaContrato.isEmpty()) {
            ObjetoContrato aux = ListaContrato.poll();
            if (aux.getCedulaCliente().equalsIgnoreCase(Cedula) && aux.getEstado().equalsIgnoreCase("Activo")){
                tieneContratoActivo = true;
            }
            colaAux.add(aux);
        }

        while (!colaAux.isEmpty()) {
            ListaContrato.add(colaAux.poll());
        }

        if (tieneContratoActivo) {
            System.out.println("Este cliente ya tiene un vehiculo alquilado actualmente");
            return null;
        }

        return clienteEncontrado;
    }

    public ObjetoVehiculo ValidarVehiculo(LinkedList<ObjetoVehiculo> ListaVehiculo, String Placa) {
        for (ObjetoVehiculo vehiculo : ListaVehiculo) {
            if (vehiculo.getPlaca().equalsIgnoreCase(Placa)) {
                if (!vehiculo.getEstado().equalsIgnoreCase("Disponible")) {
                    System.out.println("El vehiculo con placa " + Placa + " ya se encuentra alquilado");
                    return null;
                }

                System.out.println("Vehiculo disponible encontrado:");
                System.out.println("Tipo de Vehiculo: " + vehiculo.getTipoVehiculo());
                System.out.println("Marca: " + vehiculo.getMarca());
                System.out.println("Modelo: " + vehiculo.getModelo());
                System.out.println("Precio Diario: $" + vehiculo.getPrecioDiario());
                return vehiculo;
            }
        }

        System.out.println("No se encontro ningun vehiculo con esa placa");
        return null;
    }

}
