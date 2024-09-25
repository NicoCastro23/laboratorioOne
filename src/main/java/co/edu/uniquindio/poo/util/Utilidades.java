package co.edu.uniquindio.poo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Utilidades implements Serializable {

    // Atributo estático que mantiene la única instancia de la clase
    private static Utilidades instance;

    // Constructor privado para evitar la creación de instancias fuera de la clase
    private Utilidades() {
    }

    // Método estático que retorna la instancia única (Singleton)
    public static Utilidades getInstance() {
        if (instance == null) {
            instance = new Utilidades();
        }
        return instance;
    }

    // Método para serializar un objeto en formato binario (.dat)
    public void serializarObjetoBinario(String rutaArchivo, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
            System.out.println("Objeto serializado correctamente en formato binario.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para deserializar un objeto desde un archivo binario (.dat)
    public Object deserializarObjetoBinario(String rutaArchivo) {
        Object objeto = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            objeto = ois.readObject();
            System.out.println("Objeto deserializado correctamente desde formato binario.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;
    }

    // Método para serializar un objeto en formato XML
    public void serializarObjetoXML(String rutaArchivo, Object objeto) {
        XStream xstream = new XStream();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            xstream.toXML(objeto, writer);
            System.out.println("Objeto serializado correctamente en formato XML.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para deserializar un objeto desde un archivo XML
    public Object deserializarObjetoXML(String rutaArchivo) {
        XStream xstream = new XStream();

        // Configuración de seguridad: Permitir la clase Adulto y cualquier otra clase
        // necesaria
        xstream.addPermission(AnyTypePermission.ANY); // Puedes limitar a clases específicas más adelante

        Object objeto = null;
        try (FileReader reader = new FileReader(rutaArchivo)) {
            objeto = xstream.fromXML(reader);
            System.out.println("Objeto deserializado correctamente desde formato XML.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;
    }

    // Método para crear directorios si no existen
    public void crearDirectorioSiNoExiste(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) { // Verificar si el directorio ya existe
            if (directorio.mkdirs()) { // Crear el directorio, incluyendo los intermedios
                System.out.println("Directorio creado: " + rutaDirectorio);
            } else {
                System.out.println("No se pudo crear el directorio.");
            }
        } else {
            System.out.println("El directorio ya existe: " + rutaDirectorio);
        }
    }
}
