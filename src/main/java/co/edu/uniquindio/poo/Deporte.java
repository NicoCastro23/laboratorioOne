package co.edu.uniquindio.poo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private String descripcion;
    private NivelDificultad nivelDificultad; // "bajo", "medio", "alto"
    private List<Entrenador> entrenadores = new ArrayList<>();

    public void asignarEntrenador(Entrenador entrenador) {
        entrenadores.add(entrenador);
    }

    public void removerEntrenador(Entrenador entrenador) {
        entrenadores.remove(entrenador);
    }
}
