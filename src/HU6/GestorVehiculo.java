package HU6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import HU3.ObjetoVehiculo;
import HU4.ObjetoContrato;
import HU8.Validaciones;

public class GestorVehiculo {
        public LinkedList<ObjetoVehiculo> IngresarVehiculo(LinkedList<ObjetoVehiculo> ListaVehiculo, Scanner sc,
                        Validaciones V) {
                ObjetoVehiculo NuevoCarro = new ObjetoVehiculo();

                System.out.println("---------------------");
                System.out.println("Registrando nuevo vehiculo");
                System.out.println("---------------------");

                System.out.println("Ingrese la placa del vehiculo");
                String Placa = V.ValidarAlfaNumerico(sc);

                for (ObjetoVehiculo vehiculo : ListaVehiculo) {
                        if (vehiculo.getPlaca().equalsIgnoreCase(Placa)) {
                                System.out.println("Ya existe un vehiculo con esa placa");
                                return ListaVehiculo;
                        }
                }
                NuevoCarro.setPlaca(Placa);

                System.out.println("Ingrese marca del vehiculo");
                NuevoCarro.setMarca(V.ValidarTextoAlfabetico(sc));

                NuevoCarro = TipoVehiculo(sc, V, NuevoCarro);

                System.out.println("Ingrese Modelo del Vehiculo");
                NuevoCarro.setModelo(V.ValidarEntero(sc));

                System.out.println("Ingrese precio diario");
                NuevoCarro.setPrecioDiario(V.ValidarDecimal(sc).floatValue());

                NuevoCarro.setEstado("Disponible");

                ListaVehiculo.add(NuevoCarro);

                System.out.println(
                                "Vehiculo Ingresado en sistema exitosamente en la posicion: " + ListaVehiculo.size());
                return ListaVehiculo;
        }

        public ObjetoVehiculo TipoVehiculo(Scanner sc, Validaciones V, ObjetoVehiculo NuevoCarro) {

                boolean continuar = true;
                while (continuar) {

                        System.out.println("Ingrese el tipo de vehiculo");
                        System.out.println("1) Carro sedan");
                        System.out.println("2) Camioneta SUV");
                        int optcarro = V.ValidarEntero(sc);
                        switch (optcarro) {
                                case 1:
                                        NuevoCarro.setTipoVehiculo("Sedan");
                                        System.out.println(TipodeCombustible(sc, V, NuevoCarro));
                                        System.out.println(Trasnmision(sc, V, NuevoCarro));
                                        NuevoCarro.setTraccion(null);
                                        NuevoCarro.setCapacidadMaletero(0);
                                        continuar = false;
                                        break;
                                case 2:
                                        NuevoCarro.setTipoVehiculo("Camioneta SUV");
                                        System.out.println(Traccion(sc, V, NuevoCarro));
                                        System.out.println(CapacidadMaletero(sc, V, NuevoCarro));
                                        NuevoCarro.setTipoCombustible(null);
                                        NuevoCarro.setTransmision(null);
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opcion incorrecta ingrese una opcion valida");
                                        break;
                        }
                }

                return NuevoCarro;
        }

        public String TipodeCombustible(Scanner sc, Validaciones V, ObjetoVehiculo NuevoCarro) {
                System.out.println("Seleccione el tipo de combustible");
                System.out.println("1) Gasolina");
                System.out.println("2) Diesel");
                System.out.println("3) Electrico");

                boolean continuar = true;
                while (continuar) {
                        int optcarro = V.ValidarEntero(sc);
                        switch (optcarro) {
                                case 1:
                                        NuevoCarro.setTipoCombustible("Gasolina");
                                        continuar = false;
                                        break;
                                case 2:
                                        NuevoCarro.setTipoCombustible("Diesel");
                                        continuar = false;
                                        break;
                                case 3:
                                        NuevoCarro.setTipoCombustible("Electrico");
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opcion no valida, intente de nuevo");
                                        break;
                        }
                }
                return "Correcto";
        }

        public String Trasnmision(Scanner sc, Validaciones V, ObjetoVehiculo NuevoCarro) {
                System.out.println("Seleccione el tipo de trasnmision");
                System.out.println("1) Automatica");
                System.out.println("2) Manual");
                boolean continuar = true;
                while (continuar) {
                        int optcarro = V.ValidarEntero(sc);
                        switch (optcarro) {
                                case 1:
                                        NuevoCarro.setTransmision("Automatica");
                                        continuar = false;
                                        break;
                                case 2:
                                        NuevoCarro.setTransmision("Manual");
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opcion no valida, intente de nuevo");
                                        break;
                        }
                }
                return "Correcto";
        }

        public String Traccion(Scanner sc, Validaciones V, ObjetoVehiculo NuevoCarro) {
                System.out.println("Seleccione el tipo de traccion");
                System.out.println("1) 4x2");
                System.out.println("2) 4x4");
                boolean continuar = true;
                while (continuar) {
                        int optcarro = V.ValidarEntero(sc);
                        switch (optcarro) {
                                case 1:
                                        NuevoCarro.setTraccion("4x2");
                                        continuar = false;
                                        break;
                                case 2:
                                        NuevoCarro.setTraccion("4x4");
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opcion no valida, intente de nuevo");
                                        break;
                        }
                }
                return "Correcto";
        }

        public String CapacidadMaletero(Scanner sc, Validaciones V, ObjetoVehiculo NuevoCarro) {
                System.out.println("Capacidad del maletero en litros");
                float litros = V.ValidarDecimal(sc).floatValue();
                NuevoCarro.setCapacidadMaletero(litros);

                return "Correcto";
        }

        public LinkedList<ObjetoVehiculo> ModificarVehiculo(LinkedList<ObjetoVehiculo> ListaVehiculo,
                        Queue<ObjetoContrato> ListaContrato, Scanner sc, Validaciones V) {
                boolean continuar = true;
                ObjetoVehiculo aux = null;

                System.out.println("---------------------");
                System.out.println("Modificacion de Vehiculo");
                System.out.println("-------------------");
                System.out.println("Ingrese placa del vehiculo a modificar");
                String placa = V.ValidarAlfaNumerico(sc);

                for (ObjetoVehiculo aux2 : ListaVehiculo) {
                        if (aux2.getPlaca().equalsIgnoreCase(placa)) {
                                aux = aux2;
                                break;
                        }
                }

                if (aux == null) {
                        System.out.println("No existe vehiculo con esa placa");
                        return ListaVehiculo;
                }

                do {
                        System.out.println("Que desea cambiar??");
                        System.out.println("1) Marca");
                        System.out.println("2) Modelo");
                        System.out.println("3) PrecioDiario");
                        if (aux.getTipoVehiculo().equalsIgnoreCase("Sedan")) {
                                System.out.println("4) Tipo de combustible");
                                System.out.println("5) Transmision");
                        } else {
                                System.out.println("4) Traccion");
                                System.out.println("5) Capacidad del maletero");
                        }
                        System.out.println("6) Salir");

                        int opt2 = V.ValidarEntero(sc);
                        switch (opt2) {
                                case 1:
                                        System.out.println("Ingrese marca del Vehiculo");
                                        aux.setMarca(V.ValidarTextoAlfabetico(sc));
                                        break;
                                case 2:
                                        System.out.println("Ingrese el modelo del vehiculo");
                                        aux.setModelo(V.ValidarEntero(sc));
                                        break;
                                case 3:
                                        System.out.println("Ingrese nuevo precio diario");
                                        float nuevoPrecio = V.ValidarDecimal(sc).floatValue();
                                        aux.setPrecioDiario(nuevoPrecio);

                                        Queue<ObjetoContrato> colaAux = new LinkedList<>();
                                        while (!ListaContrato.isEmpty()) {
                                                ObjetoContrato contrato = ListaContrato.poll();
                                                if (contrato.getPlacaVehiculo().equalsIgnoreCase(aux.getPlaca())
                                                                && contrato.getEstado().equalsIgnoreCase("Activo")) {
                                                        contrato.setValorTotal(contrato.getTotalDias() * nuevoPrecio);
                                                }
                                                colaAux.add(contrato);
                                        }
                                        while (!colaAux.isEmpty()) {
                                                ListaContrato.add(colaAux.poll());
                                        }
                                        break;
                                case 4:
                                        if (aux.getTipoVehiculo().equalsIgnoreCase("Sedan")) {
                                                TipodeCombustible(sc, V, aux);
                                        } else {
                                                Traccion(sc, V, aux);
                                        }
                                        break;
                                case 5:
                                        if (aux.getTipoVehiculo().equalsIgnoreCase("Sedan")) {
                                                Trasnmision(sc, V, aux);
                                        } else {
                                                CapacidadMaletero(sc, V, aux);
                                        }
                                        break;
                                case 6:
                                        System.out.println("Regresando...");
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opcion invalida, seleccione una opcion del 1 al 6");
                                        break;
                        }
                } while (continuar);

                return ListaVehiculo;
        }

        public LinkedList<ObjetoVehiculo> EliminarVehiculo(LinkedList<ObjetoVehiculo> ListaVehiculo, Scanner sc,
                        Validaciones V) {
                System.out.println("---------------------");
                System.out.println("Eliminacion de Vehiculo");
                System.out.println("---------------------");

                if (ListaVehiculo.isEmpty()) {
                        System.out.println("No hay vehiculos registrados en el sistema.");
                        return ListaVehiculo;
                }

                System.out.println("Ingrese la placa del vehiculo a eliminar:");
                String Placa = V.ValidarAlfaNumerico(sc);

                for (ObjetoVehiculo aux : ListaVehiculo) {
                        if (aux.getPlaca().equalsIgnoreCase(Placa)) {
                                if (aux.getEstado().equalsIgnoreCase("Alquilado")) {
                                        System.out.println(
                                                        "Error: No se puede eliminar un vehiculo que esta alquilado.");
                                        return ListaVehiculo;
                                }
                                ListaVehiculo.remove(aux);
                                System.out.println("Vehiculo eliminado correctamente.");
                                return ListaVehiculo;
                        }
                }

                System.out.println("No se encontro ningun vehiculo con esa placa.");
                return ListaVehiculo;
        }

        public String BuscarVehiculo(LinkedList<ObjetoVehiculo> ListaVehiculo, Scanner sc, Validaciones V) {
                System.out.println("---------------------");
                System.out.println("Busqueda de Vehiculo");
                System.out.println("---------------------");

                if (ListaVehiculo.isEmpty()) {
                        return "No hay vehiculos registrados en el sistema.";
                }

                System.out.println("Ingrese la placa del vehiculo a buscar:");
                String Placa = V.ValidarAlfaNumerico(sc);

                for (ObjetoVehiculo aux : ListaVehiculo) {
                        if (aux.getPlaca().equalsIgnoreCase(Placa)) {
                                System.out.println("----------------------------------");
                                System.out.println("Placa: " + aux.getPlaca());
                                System.out.println("Tipo: " + aux.getTipoVehiculo());
                                System.out.println("Marca: " + aux.getMarca());
                                System.out.println("Modelo: " + aux.getModelo());
                                System.out.println("Precio Diario: " + aux.getPrecioDiario());
                                System.out.println("Estado: " + aux.getEstado());

                                if (aux.getTipoVehiculo().equalsIgnoreCase("Sedan")) {
                                        System.out.println("Tipo de Combustible: " + aux.getTipoCombustible());
                                        System.out.println("Transmision: " + aux.getTransmision());
                                } else {
                                        System.out.println("Traccion: " + aux.getTraccion());
                                        System.out.println("Capacidad Maletero: " + aux.getCapacidadMaletero() + " L");
                                }
                                System.out.println("----------------------------------------");
                                return "Busqueda finalizada.";
                        }
                }

                return "No se encontro ningun vehiculo con esa placa.";
        }

}