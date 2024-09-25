package co.edu.uniquindio.poo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public abstract class Miembro implements Serializable {
    private String nombre;
    private String email;
    private String id;

    public abstract boolean puedeInscribirse(Deporte deporte);
}
