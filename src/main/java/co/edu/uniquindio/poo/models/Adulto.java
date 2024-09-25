package co.edu.uniquindio.poo.models;

import java.io.Serializable;

public class Adulto extends Miembro implements Serializable {

    public Adulto(String nombre, String email, String id) {
        super(nombre, email, id);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean puedeInscribirse(Deporte deporte) {
        return true; // Los adultos pueden inscribirse en cualquier deporte
    }
}