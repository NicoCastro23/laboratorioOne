package co.edu.uniquindio.poo.models;

import java.time.LocalDateTime;
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

    /**
     * Este método se encarga de buscar un deporte por su nombre en la lista de
     * deportes.
     * 
     * @param nombre El nombre del deporte a buscar.
     * @return Un objeto de tipo Deporte que coincida con el nombre proporcionado.
     * @throws IllegalArgumentException En caso tal que no se encuentre el deporte
     *                                  con el nombre proporcionado.
     */
    public Deporte buscarDeporteporNombre(String nombre) {
        return deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Deporte no encontrado"));
    }

    /**
     * Este método se encarga de buscar un entrenador por su nombre en la lista de
     * entrenadoress.
     * 
     * @param nombre El nombre del entrenador a buscar.
     * @return Un objeto de tipo Entrenador que coincida con el nombre
     *         proporcionado.
     * @throws IllegalArgumentException En caso tal que no se encuentre el
     *                                  entrenador.
     */

    public Entrenador buscarEntrenadorporNombre(String entrenador) {
        return entrenadores.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(entrenador))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Entrenador no encontrado"));

    }

    public void agregarSesion(SesionEntrenamiento sesion) throws IllegalArgumentException {
        if (validarSesion(sesion)) {
            sesionEntrenamientos.add(sesion);
        } else {
            throw new IllegalArgumentException("Datos de la sesión no válidos.");
        }
    }

    // Método para eliminar una sesión
    public void eliminarSesion(SesionEntrenamiento sesion) throws IllegalArgumentException {
        if (sesionEntrenamientos.contains(sesion)) {
            sesionEntrenamientos.remove(sesion);
        } else {
            throw new IllegalArgumentException("Sesión no encontrada.");
        }
    }

    // Método para obtener todas las sesiones
    public List<SesionEntrenamiento> getSesionEntrenamientos() {
        return sesionEntrenamientos;
    }

    // Método para encontrar una sesión por fecha
    public SesionEntrenamiento encontrarSesion(LocalDateTime fecha) throws IllegalArgumentException {
        for (SesionEntrenamiento sesion : sesionEntrenamientos) {
            if (sesion.getFecha().equals(fecha)) {
                return sesion;
            }
        }
        throw new IllegalArgumentException("Sesión no encontrada para la fecha especificada.");
    }

    // Método para actualizar una sesión existente
    public void actualizarSesion(SesionEntrenamiento sesionExistente, SesionEntrenamiento sesionNueva)
            throws IllegalArgumentException {
        if (sesionEntrenamientos.contains(sesionExistente)) {
            if (validarSesion(sesionNueva)) {
                int index = sesionEntrenamientos.indexOf(sesionExistente);
                sesionEntrenamientos.set(index, sesionNueva);
            } else {
                throw new IllegalArgumentException("Datos de la nueva sesión no válidos.");
            }
        } else {
            throw new IllegalArgumentException("Sesión no encontrada.");
        }
    }

    // Método para validar los datos de una sesión
    private boolean validarSesion(SesionEntrenamiento sesion) {
        if (sesion.getFecha() == null || sesion.getDuracion() <= 0 || sesion.getEstado() == null
                || sesion.getDeporte() == null || sesion.getEntrenador() == null) {
            return false;
        }
        return true;
    }
}
