package co.edu.uniquindio.poo.models;

import java.util.ArrayList;
import java.util.List;

public class GestionDeportes {
    private static GestionDeportes instance;
    private List<Deporte> deportes = new ArrayList<>();
    private List<Entrenador> entrenadores = new ArrayList<>();
    private List<Miembro> miembros = new ArrayList<>();
    private List<SesionEntrenamiento> sesionEntrenamientos = new ArrayList<>();
    private static Administrador administrador;

    public GestionDeportes() {

    }

    public static GestionDeportes getInstance() {
        if (instance == null) {
            instance = new GestionDeportes();
        }
        return instance;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public static void setAdministrador(Administrador administrador) {
        GestionDeportes.administrador = administrador;
    }

    public void addDeporte(Deporte deporte) {
        deportes.add(deporte);
    }
}
