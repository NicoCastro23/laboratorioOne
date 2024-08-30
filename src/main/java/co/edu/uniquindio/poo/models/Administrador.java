package co.edu.uniquindio.poo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Administrador {
    private String nombre;
    private String id;

/**
 * Este método se encarga de programar una sesión y añadirla a la lista de sesiones de entrenamiento.
 * @param sesiones Lista de sesiones de entrenamiento.
 * @param sesion sesión que se quiere añadir.
 */
    public void programarSesion(List<SesionEntrenamiento> sesiones, SesionEntrenamiento sesion) {
        sesiones.add(sesion);
    }
/**
 * Este método busca la primera sesión de entrenamiento dentro de la lista de las sesiones de entrenamiento que cumpla con el filtro.
 * @param sesiones la lista de sesiones de entrenamiento en la cual buscar.
 * @param filtro Un predicado que define la condición que debe cumplir la sesión buscada.
 * @return Un Optional que contiene la primera sesión que cumple con el filtro,o un Optional.empty() si no se encuentra ninguna sesión que cumpla con la condición.
 */
    public Optional<SesionEntrenamiento> buscarSesion(List<SesionEntrenamiento> sesiones,
            Predicate<SesionEntrenamiento> filtro) {
        return sesiones.stream().filter(filtro).findFirst();
    }

    public void gestionarSesion(SesionEntrenamiento sesion, TipoEstado nuevoEstado) {
        sesion.setEstado(nuevoEstado);
    }
}
