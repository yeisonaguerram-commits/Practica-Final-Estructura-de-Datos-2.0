package HU6;

import java.util.LinkedList;
import java.util.Scanner;

import HU2.ObjetoCliente;
import HU8.Validaciones;

public class GestorCliente {
        public LinkedList<ObjetoCliente> IngresarCliente(LinkedList<ObjetoCliente> ListaCliente, Scanner sc,
                        Validaciones V) {
                System.out.println("---------------------");
                System.out.println("Registrando nuevo cliente");
                System.out.println("---------------------");

                System.out.println("Ingrese la cedula del cliente");
                String Cedula = V.ValidarAlfaNumerico(sc);

                for (ObjetoCliente Cliente : ListaCliente) {
                        if (Cliente.getCedula().equalsIgnoreCase(Cedula)) {
                                System.out.println("Ya existe un cliente con esa cedula");
                                return ListaCliente;
                        }
                }

                System.out.println("Ingrese nombre del cliente");
                String nombre = V.ValidarTextoAlfabetico(sc);

                System.out.println("Ingrese el Apellido");
                String Apellido = V.ValidarTextoAlfabetico(sc);

                System.out.println("Ingrese Telefono de contacto");
                String Telefono = V.ValidarSoloNumeros(sc);

                System.out.println("Ingrese direccion");
                String Direccion = V.ValidarTextoLibre(sc);

                System.out.println("Ingrese numerio de licencia de conduccion");
                String Licencia = V.ValidarAlfaNumerico(sc);

                ObjetoCliente NuevoCliente = new ObjetoCliente(Cedula, nombre, Apellido, Telefono, Direccion, Licencia);

                ListaCliente.add(NuevoCliente);

                System.out.println("Cliente Ingresado en sistema exitosamente en la posicion: " + ListaCliente.size());
                return ListaCliente;
        }

        public LinkedList<ObjetoCliente> ModificarCliente(LinkedList<ObjetoCliente> ListaCliente, Scanner sc,
                        Validaciones V) {
                boolean continuar = true;
                ObjetoCliente aux = null;

                System.out.println("---------------------");
                System.out.println("Modificacion de cliente");
                System.out.println("-------------------");
                System.out.println("Ingrese cedula del ciente a modificar");
                String Cedula = V.ValidarAlfaNumerico(sc);

                for (ObjetoCliente aux2 : ListaCliente) {
                        if (aux2.getCedula().equalsIgnoreCase(Cedula)) {
                                aux = aux2;
                                break;
                        } else {
                                System.out.println("No existe cliente con esa cedula");
                                return ListaCliente;
                        }
                }

                do {
                        System.out.println("Que desea cambiar??");

                        System.out.println("1) Nombre");
                        System.out.println("2) Apellido");
                        System.out.println("3) Telefono");
                        System.out.println("4) Direccion");
                        System.out.println("5) Liencia de conduccion");
                        System.out.println("6) salir");

                        int opt2 = V.ValidarEntero(sc);
                        switch (opt2) {
                                case 1:
                                        System.out.println("Ingrese nombre del cliente");
                                        aux.setNombreCliente(V.ValidarTextoAlfabetico(sc));
                                        break;
                                case 2:
                                        System.out.println("Ingrese el Apellido");
                                        aux.setApellidoCliente(V.ValidarTextoAlfabetico(sc));
                                        break;
                                case 3:
                                        System.out.println("Ingrese Telefono de contacto");
                                        aux.setTelefono(V.ValidarSoloNumeros(sc));
                                        break;
                                case 4:
                                        System.out.println("Ingrese direccion");
                                        aux.setDireccion(V.ValidarTextoLibre(sc));
                                case 5:
                                        System.out.println("Ingrese numerio de licencia de conduccion");
                                        aux.setLicencia(V.ValidarAlfaNumerico(sc));
                                case 6:
                                        System.out.println("Regresando...");
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opcion invalida, seleccione una opcion del 1 al 6");
                                        break;
                        }

                } while (continuar);

                return ListaCliente;
        }

        public LinkedList<ObjetoCliente> EliminarCliente(LinkedList<ObjetoCliente> ListaCliente, Scanner sc,
                        Validaciones V) {
                ObjetoCliente aux = null;

                System.out.println("---------------------");
                System.out.println("Eliminacion de cliente");
                System.out.println("---------------------");
                System.out.println("Ingrese cedula del ciente a eliminar");
                String Cedula = V.ValidarAlfaNumerico(sc);

                for (ObjetoCliente aux2 : ListaCliente) {
                        if (aux2.getCedula().equalsIgnoreCase(Cedula)) {
                                aux = aux2;
                                break;
                        } else {
                                System.out.println("No existe cliente con esa cedula");
                                return ListaCliente;
                        }
                }
                ListaCliente.remove(aux);

                return ListaCliente;
        }

        public String BuscarCliente(LinkedList<ObjetoCliente> ListaCliente, Scanner sc,
                        Validaciones V) {
                ObjetoCliente aux = null;

                System.out.println("---------------------");
                System.out.println("Buscar cliente");
                System.out.println("---------------------");
                System.out.println("Ingrese cedula del ciente a buscar");
                String Cedula = V.ValidarAlfaNumerico(sc);

                for (ObjetoCliente aux2 : ListaCliente) {
                        if (aux2.getCedula().equalsIgnoreCase(Cedula)) {
                                aux = aux2;
                                break;
                        } else {
                                return "No existe cliente con esa cedula";
                        }
                }

                System.out.println("---------------------------------------------");
                System.out.println("Cedula: " + aux.getCedula());
                System.out.println("Nombre: " + aux.getNombreCliente());
                System.out.println("Apellido: " + aux.getApellidoCliente());
                System.out.println("Telefono: " + aux.getTelefono());
                System.out.println("Direccion: " + aux.getDireccion());
                System.out.println("---------------------------------------------");

                return "Lista Mostrada exitosamente";
        }
}
