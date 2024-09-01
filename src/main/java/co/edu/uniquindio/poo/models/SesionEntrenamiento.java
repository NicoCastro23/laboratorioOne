package co.edu.uniquindio.poo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Getter
@Setter
public class SesionEntrenamiento {
    private LocalDate fecha;
    private int duracion; // Duración en minutos
    private TipoEstado estado;
    private Deporte deporte;
    private Entrenador entrenador;
}
