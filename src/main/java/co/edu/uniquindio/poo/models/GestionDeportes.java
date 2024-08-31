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
    /**
     * Este método se encarga de buscar un deporte por su nombre en la lista de deportes.
     * @param nombre El nombre del deporte a buscar. 
     * @return Un objeto de tipo Deporte que coincida con el nombre proporcionado.
     * @throws IllegalArgumentException En caso tal que no se encuentre el deporte con el nombre proporcionado.
     */
    public Deporte buscarDeporteporNombre(String nombre) {
        return deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Deporte no encontrado"));
    }

    /**
     * Este método se encarga de buscar un entrenador por su nombre en la lista de entrenadoress.
     * @param nombre El nombre del entrenador a buscar. 
     * @return Un objeto de tipo Entrenador que coincida con el nombre proporcionado.
     * @throws IllegalArgumentException En caso tal que no se encuentre el entrenador.
     */

    public Entrenador buscarEntrenadorporNombre(String entrenador) {
        return entrenadores.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(entrenador))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Entrenador no encontrado"));

    }

}
