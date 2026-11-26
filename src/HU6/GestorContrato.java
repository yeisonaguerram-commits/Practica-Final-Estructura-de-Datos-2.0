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
            if (aux.getCedulaCliente().equalsIgnoreCase(Cedula) && aux.getEstado().equalsIgnoreCase("Activo")) {
                tieneContratoActivo = true;
            }
            colaAux.add(aux);

            while (!colaAux.isEmpty()) {
                ListaContrato.add(colaAux.poll());
            }

            if (tieneContratoActivo) {
                System.out.println("Este cliente ya tiene un vehiculo alquilado actualmente");
                return null;
            }
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

    public Queue<ObjetoContrato> ModificarContrato(Queue<ObjetoContrato> ListaContrato,
            LinkedList<ObjetoCliente> ListaCliente, LinkedList<ObjetoVehiculo> ListaVehiculo, Scanner sc,
            Validaciones V) {
        if (ListaCliente.isEmpty()) {
            System.out.println("Sin clientes ingresados a sistema");
            return ListaContrato;
        } else if (ListaVehiculo.isEmpty()) {
            System.out.println("Sin Vehiculos ingresados a sistema");
            return ListaContrato;
        }

        System.out.println("---------------------");
        System.out.println("MODIFICACION DE CONTRATO");
        System.out.println("---------------------");

        if (ListaContrato.isEmpty()) {
            System.out.println("No hay contratos registrados en el sistema");
            return ListaContrato;
        }

        System.out.println("Ingrese el ID del contrato a modificar:");
        String idBuscar = V.ValidarAlfaNumerico(sc);

        Queue<ObjetoContrato> colaAux = new LinkedList<>();
        boolean encontrado = false;

        while (!ListaContrato.isEmpty()) {
            ObjetoContrato aux = ListaContrato.poll();

            if (aux.getIDcontrato().equalsIgnoreCase(idBuscar)) {
                encontrado = true;
                if (!aux.getEstado().equalsIgnoreCase("Activo")) {
                    System.out.println("Solo se pueden modificar contratos en estado Activo.");
                } else {
                    MenuModificarContrato(aux, ListaVehiculo, sc, V);
                }
            }
            colaAux.add(aux);
        }

        while (!colaAux.isEmpty()) {
            ListaContrato.add(colaAux.poll());
        }

        if (!encontrado) {
            System.out.println("No se encontro ningun contrato con ese ID");
        }

        return ListaContrato;
    }

    public ObjetoContrato MenuModificarContrato(ObjetoContrato aux, LinkedList<ObjetoVehiculo> ListaVehiculo,
            Scanner sc, Validaciones V) {
        boolean continuar = true;
        do {
            System.out.println("Que desea modificar del contrato " + aux.getIDcontrato() + "?");
            System.out.println("1) Fecha de Inicio");
            System.out.println("2) Fecha de Fin");
            System.out.println("3) Total de Dias (recalcula valor total)");
            System.out.println("4) Salir");
            int opt = V.ValidarEntero(sc);

            switch (opt) {
                case 1:
                    System.out.println("Ingrese nueva Fecha de Inicio:");
                    aux.setFechaInicio(V.ValidarTextoLibre(sc));
                    System.out.println("Fecha de inicio actualizada.");
                    break;
                case 2:
                    System.out.println("Ingrese nueva Fecha de Fin:");
                    aux.setFechaFin(V.ValidarTextoLibre(sc));
                    System.out.println("Fecha de fin actualizada.");
                    break;
                case 3:
                    int nuevosDias = 0;
                    while (nuevosDias <= 0) {
                        System.out.println("Ingrese el nuevo total de dias (mayor a 0):");
                        nuevosDias = V.ValidarEntero(sc);
                    }
                    aux.setTotalDias(nuevosDias);
                    for (ObjetoVehiculo v : ListaVehiculo) {
                        if (v.getPlaca().equalsIgnoreCase(aux.getPlacaVehiculo())) {
                            aux.setValorTotal(nuevosDias * v.getPrecioDiario());
                            break;
                        }
                    }
                    System.out.println("Duracion y valor total actualizados: $" + aux.getValorTotal());
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (continuar);

        return aux;
    }

    public ObjetoContrato FinalizarContrato(ObjetoContrato aux, LinkedList<ObjetoVehiculo> ListaVehiculo,
            Scanner sc, Validaciones V) {
        ObjetoContrato NuevoContrato = new ObjetoContrato();

        if (ListaCliente == null) {
            System.out.println("Sin clientes ingresados a sistema");
            return ListaContrato;
        } else if (ListaVehiculo == null) {
            System.out.println("Sin Vehiculos ingresados a sistema");
            return ListaContrato;
        }

        System.out.println("---------------------");
        System.out.println("FINALIZACION DE CONTRATO");
        System.out.println("------------------------");
            }
}
