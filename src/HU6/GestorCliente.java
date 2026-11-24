package HU6;

import java.util.LinkedList;
import java.util.Scanner;

import HU2.ObjetoCliente;
import HU8.Validaciones;

public class GestorCliente {
        public LinkedList<ObjetoCliente> IngresarCliente(LinkedList<ObjetoCliente> ListaCliente, Scanner sc, Validaciones V) {
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

        public LinkedList<ObjetoCliente> ModificarCliente(LinkedList<ObjetoCliente> ListaCliente, Scanner sc, Validaciones V) {
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
                                break;
                        }
                }


                do {

                } while (continuar);

                return ListaCliente;
        }

        public LinkedList<ObjetoCliente> EliminarCliente(LinkedList<ObjetoCliente> ListaCliente, Scanner sc,
                        Validaciones V) {

        }

        public LinkedList<ObjetoCliente> BuscarCliente(LinkedList<ObjetoCliente> ListaCliente, Scanner sc,
                        Validaciones V) {

        }
}