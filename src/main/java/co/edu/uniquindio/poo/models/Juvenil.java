package co.edu.uniquindio.poo.models;

public class Juvenil extends Miembro {

    public Juvenil(String nombre, String email, String id) {
        super(nombre, email, id);
    }

    @Override
    public boolean puedeInscribirse(Deporte deporte) {
        return deporte.getNivelDificultad() != NivelDificultad.ALTA;
    }//Este método asegura que los miembros pertenecientes a la categoría juvenil solo puedan inscribirse a deportes de intensidad media y baja.
}