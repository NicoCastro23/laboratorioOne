package co.edu.uniquindio.poo.models;

public class Juvenil extends Miembro {

    public Juvenil(String nombre, String email, String id) {
        super(nombre, email, id);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean puedeInscribirse(Deporte deporte) {
        return deporte.getNivelDificultad() != NivelDificultad.ALTA;
    }
}