package servicio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorTxt {
    public void exportar(String fileName, List<Cliente> listaClientes) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Cliente cliente : listaClientes) {
                fw.write("RUN: " + cliente.getRunCliente() + "\n");
                fw.write("Nombre: " + cliente.getNombreCliente() + "\n");
                fw.write("Apellido: " + cliente.getApellidoCliente() + "\n");
                fw.write("Años: " + cliente.getAniosCliente() + "\n");
                fw.write("Categoría: " + cliente.getNombreCategoria() + "\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}