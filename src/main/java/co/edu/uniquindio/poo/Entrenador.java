package co.edu.uniquindio.poo;

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

    public List<SesionEntrenamiento> obtenerSesionesPorEstado(TipoEstado estado) {
        return sesionesEntrenamiento.stream()
                .filter(sesion -> sesion.getEstado().equals(estado))
                .toList();
    }

    public SesionEntrenamiento obtenerPrimeraSesionConDuracionMayorA(int minutos) {
        return sesionesEntrenamiento.stream()
                .filter(sesion -> sesion.getDuracion() > minutos)
                .findFirst()
                .orElse(null);
    }
}
