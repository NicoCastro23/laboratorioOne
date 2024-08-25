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

    public void programarSesion(List<SesionEntrenamiento> sesiones, SesionEntrenamiento sesion) {
        sesiones.add(sesion);
    }

    public Optional<SesionEntrenamiento> buscarSesion(List<SesionEntrenamiento> sesiones,
            Predicate<SesionEntrenamiento> filtro) {
        return sesiones.stream().filter(filtro).findFirst();
    }

    public void gestionarSesion(SesionEntrenamiento sesion, TipoEstado nuevoEstado) {
        sesion.setEstado(nuevoEstado);
    }
}
