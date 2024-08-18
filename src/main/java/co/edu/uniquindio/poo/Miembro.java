package co.edu.uniquindio.poo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Miembro {
    private String nombre;
    private String email;
    private String id;

    public abstract boolean puedeInscribirse(Deporte deporte);
}
