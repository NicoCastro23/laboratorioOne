package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.models.Adulto;
import co.edu.uniquindio.poo.util.Utilidades;

public class SerializacionTest {

    public static void main(String[] args) {
        // Crear un objeto de la clase Adulto
        Adulto adulto = new Adulto("Juan Pérez", "juan@correo.com", "12345");

        // Crear el directorio si no existe
        String rutaDirectorio = "C:/Reportes_Java";
        Utilidades.getInstance().crearDirectorioSiNoExiste(rutaDirectorio);

        // Serializar el objeto en binario
        Utilidades.getInstance().serializarObjetoBinario(rutaDirectorio + "/adulto.dat", adulto);

        // Serializar el objeto en XML
        Utilidades.getInstance().serializarObjetoXML(rutaDirectorio + "/adulto.xml", adulto);

        // Deserializar el objeto desde el archivo binario
        Adulto adultoDeserializadoBinario = (Adulto) Utilidades.getInstance()
                .deserializarObjetoBinario(rutaDirectorio + "/adulto.dat");
        System.out.println("Deserializado binario: " + adultoDeserializadoBinario);

        // Deserializar el objeto desde el archivo XML
        Adulto adultoDeserializadoXML = (Adulto) Utilidades.getInstance()
                .deserializarObjetoXML(rutaDirectorio + "/adulto.xml");
        System.out.println("Deserializado XML: " + adultoDeserializadoXML);

    }
}
