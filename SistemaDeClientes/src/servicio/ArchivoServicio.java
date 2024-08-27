package servicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoServicio {
    public void cargarDatos(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // implementar lógica para cargar datos desde archivo
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportarDatos(String fileName, List<Cliente> listaClientes) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Cliente cliente : listaClientes) {
                // implementar lógica para exportar datos a archivo
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}