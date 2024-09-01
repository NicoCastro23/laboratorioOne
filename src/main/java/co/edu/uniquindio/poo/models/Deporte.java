package co.edu.uniquindio.poo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Deporte {
    private String nombre;
    private String descripcion;
    private NivelDificultad nivelDificultad; // "bajo", "medio", "alto"
    private List<Entrenador> entrenadores = new ArrayList<>();

    public Deporte(String nombre, String descripcion, NivelDificultad nivelDificultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelDificultad = nivelDificultad;
    }

    public void asignarEntrenador(Entrenador entrenador) {
        entrenadores.add(entrenador);
    }

    public void removerEntrenador(Entrenador entrenador) {
        entrenadores.remove(entrenador);
    }
}
