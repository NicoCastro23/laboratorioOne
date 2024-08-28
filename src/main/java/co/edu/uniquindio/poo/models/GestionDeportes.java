package co.edu.uniquindio.poo.models;

import java.util.ArrayList;
import java.util.List;

public class GestionDeportes {

    private List<Deporte> deportes = new ArrayList<>();
    private List<Entrenador> entrenadores = new ArrayList<>();
    private List<Miembro> miembros = new ArrayList<>();
    private List<SesionEntrenamiento> sesionEntrenamientos = new ArrayList<>();
    private Administrador administrador;

    public GestionDeportes() {

    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void addDeporte(Deporte deporte) {
        deportes.add(deporte);
    }

    public void addEntrenador(Entrenador entrenador) {
        entrenadores.add(entrenador);
    }

    public void addMiembros(Miembro miembro) {
        miembros.add(miembro);
    }

    public void addSesiones(SesionEntrenamiento sesionEntrenamiento) {
        sesionEntrenamientos.add(sesionEntrenamiento);
    }

    public Deporte encontrarDeporteporNombre(String nombre) {
        return deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Entrenador no encontrado"));
    }

    public Entrenador encontrarEntrenadorporNombre(String entrenador) {
        return entrenadores.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(entrenador))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Entrenador no encontrado"));
    }

}
