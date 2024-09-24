package co.edu.uniquindio.poo.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.*;

public class AppLogger {
    private static Logger logger;

    static {
        try {
            // Crear un Logger con el nombre de la aplicación
            logger = Logger.getLogger("AppLogger");

            // Establecer el nivel de logging global
            logger.setLevel(Level.ALL);

            // Evitar que los mensajes se envíen a los Handlers padres
            logger.setUseParentHandlers(false);

            // Crear un Handler para escribir en un archivo de log
            FileHandler fileHandler = new FileHandler("application.log", true);
            fileHandler.setLevel(Level.ALL);

            // Crear un formato simple para los mensajes de log
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            // Agregar el Handler al Logger
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            System.err.println("Error al configurar el Logger: " + e.getMessage());
        }
    }

    // Método para obtener el Logger
    public static Logger getLogger() {
        return logger;
    }
}
