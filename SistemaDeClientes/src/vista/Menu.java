package vistas;

import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

import java.util.Scanner;

public class Menu {
    private ClienteServicio clienteServicio;
    private ArchivoServicio archivoServicio;
    private ExportadorCsv exportadorCsv;
    private ExportadorTxt exportadorTxt;
    private Utilidad utilidad;
    private Scanner scanner;

    public Menu() {
        clienteServicio = new ClienteServicio();
        archivoServicio = new ArchivoServicio();
        exportadorCsv = new ExportadorCsv();
        exportadorTxt = new ExportadorTxt();
        utilidad = new Utilidad();
        scanner = new Scanner(System.in);
    }

    public void iniciarMenu() {
        int opcion;
        do {
            utilidad.limpiarPantalla();
            System.out.println("Menú Principal");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Cargar Datos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (opcion) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    agregarCliente();
                    break;
                case 3:
                    editarCliente();
                    break;
                case 4:
                    cargarDatos();
                    break;
                case 5:
                    exportarDatos();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }

    private void listarClientes() {
        List<Cliente> listaClientes = clienteServicio.getListaClientes();
        for (Cliente cliente : listaClientes) {
            System.out.println("RUN: " + cliente.getRunCliente());
            System.out.println("Nombre: " + cliente.getNombreCliente());
            System.out.println("Apellido: " + cliente.getApellidoCliente());
            System.out.println("Años: " + cliente.getAniosCliente());
            System.out.println("Categoría: " + cliente.getNombreCategoria());
            System.out.println();
        }
    }

    private void agregarCliente() {
        System.out.print("Ingrese RUN del cliente: ");
        String runCliente = scanner.nextLine();
        System.out.print("Ingrese nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese apellido del cliente: ");
        String apellidoCliente = scanner.nextLine();
        System.out.print("Ingrese años del cliente: ");
        String aniosCliente = scanner.nextLine();
        CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;

        Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
        clienteServicio.agregarCliente(cliente);
    }

    private void editarCliente() {
        System.out.print("Ingrese RUN del cliente a editar: ");
        String runCliente = scanner.nextLine();
        // implementar lógica para editar cliente
    }

    private void cargarDatos() {
        System.out.print("Ingrese ruta del archivo a cargar: ");
        String fileName = scanner.nextLine();
        archivoServicio.cargarDatos(fileName);
    }

    private void exportarDatos() {
        System.out.print("Ingrese ruta del archivo a exportar: ");
        String fileName = scanner.nextLine();
        List<Cliente> listaClientes = clienteServicio.getListaClientes();
        exportadorCsv.exportar(fileName, listaClientes);
    }
}ln