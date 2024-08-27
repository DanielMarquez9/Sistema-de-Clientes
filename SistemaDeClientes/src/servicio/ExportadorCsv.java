package servicio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorCsv {
    public void exportar(String fileName, List<Cliente> listaClientes) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Cliente cliente : listaClientes) {
                fw.write(cliente.getRunCliente() + "," + cliente.getNombreCliente() + "," + cliente.getApellidoCliente() + "," + cliente.getAniosCliente() + "," + cliente.getNombreCategoria() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}