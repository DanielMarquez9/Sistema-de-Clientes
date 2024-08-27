package servicio;

import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {
    private List<Cliente> listaClientes;

    public ClienteServicio() {
        listaClientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void editarCliente(Cliente cliente) {
        // implementar lógica para editar cliente
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}