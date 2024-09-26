package co.edu.uniquindio.poo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.Arrays;

public class Utilities {
    private static final String DIRECTORIO_BASE = "C://Reportes_Java/";

    // Método para verificar o crear el directorio "C://Reportes_Java"
    private void verificarOCrearDirectorio() throws IOException {
        // Verificar si la raíz C:// existe
        File directorioRaiz = new File("C://");
        if (!directorioRaiz.exists() || !directorioRaiz.isDirectory()) {
            try {
                AppLogger.getLogger().info("El directorio raíz C:// no existe o no es accesible.");
            } catch (Exception e) {
                AppLogger.getLogger().log(Level.SEVERE, "El directorio raíz C:// no existe o no es accesible.", e);
            }
        }

        // Verificar o crear el directorio "C://Reportes_Java"
        File directorio = new File(DIRECTORIO_BASE);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) { // mkdirs() crea el directorio y subdirectorios si no existen
                try {
                    AppLogger.getLogger().info("Directorio creado: " + DIRECTORIO_BASE);
                } catch (Exception e) {
                    AppLogger.getLogger().log(Level.SEVERE,
                            "No se pudo crear el directorio o ya existe: " + DIRECTORIO_BASE, e);
                }
            }
        }
    }

    // Método para escribir una lista en un archivo, cada 10 elementos
    public void escribirListaEnArchivo(String nombreArchivo, List<?> lista) throws IOException {
        verificarOCrearDirectorio(); // Verifica y crea el directorio si es necesario

        File archivo = new File(DIRECTORIO_BASE + nombreArchivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            int contador = 0;
            for (Object elemento : lista) {
                writer.write(elemento.toString());
                writer.newLine();
                contador++;

                if (contador == 10) {
                    writer.flush(); // Optimiza el uso de recursos al escribir cada 10 elementos
                    contador = 0;
                }
            }
            writer.flush(); // Escribe lo que queda si es menor a 10
            AppLogger.getLogger().info("Archivo escrito con éxito: " + nombreArchivo);
        } catch (IOException e) {
            AppLogger.getLogger()
                    .info("Error al escribir en el archivo: " + nombreArchivo + ". Error: " + e.getMessage());
        }
    }

    // Método principal para probar la escritura de dos listas
    public static void main(String[] args) {
        Utilities util = new Utilities();

        // Primera lista de ejemplo
        List<String> lista1 = Arrays.asList("Elemento1", "Elemento2", "Elemento3", "Elemento4",
                "Elemento5", "Elemento6", "Elemento7", "Elemento8",
                "Elemento9", "Elemento10", "Elemento11", "Elemento12");

        // Segunda lista de ejemplo
        List<String> lista2 = Arrays.asList("Entidad1", "Entidad2", "Entidad3", "Entidad4",
                "Entidad5", "Entidad6", "Entidad7", "Entidad8",
                "Entidad9", "Entidad10", "Entidad11", "Entidad12");

        try {
            // Escribir la primera lista en un archivo
            util.escribirListaEnArchivo("reporte_lista1.txt", lista1);

            // Escribir la segunda lista en un archivo
            util.escribirListaEnArchivo("reporte_lista2.txt", lista2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
