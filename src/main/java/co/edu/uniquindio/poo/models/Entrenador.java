package co.edu.uniquindio.poo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Entrenador {
    private String nombre;
    private String especialidad;
    private List<SesionEntrenamiento> sesionesEntrenamiento = new ArrayList<>();

    public void agregarSesion(SesionEntrenamiento sesion) {
        sesionesEntrenamiento.add(sesion);
    }

    /**
     * Este método se encarga de filtrar las sesiones de entrenamiento de un mismo tipo.
     * @param estado estado por el cual se van a filtrar las sesiones . 
     * @return Una lista de sesiones de entrenamiento que coincidan con el estado proporcionado.
     */
    public List<SesionEntrenamiento> obtenerSesionesPorEstado(TipoEstado estado) {
        return sesionesEntrenamiento.stream()
                .filter(sesion -> sesion.getEstado().equals(estado))
                .toList();
    }

    /**
     * Este método se encarga de filtrar la primera sesión de entrenamiento mayor a los minutos proporcionados.
     * @param minutos.
     * @return La primera sesión de entrenamiento encontrada mayor a los minutos proporcionados o null si no encuentra ninguna con la condición especificada.
     */
    public SesionEntrenamiento obtenerPrimeraSesionConDuracionMayorA(int minutos) {
        return sesionesEntrenamiento.stream()
                .filter(sesion -> sesion.getDuracion() > minutos)
                .findFirst()
                .orElse(null);
    }
}
