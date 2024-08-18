package co.edu.uniquindio.poo;


public class Adulto extends Miembro {

    public Adulto(String nombre, String email, String id) {
        super(nombre, email, id);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean puedeInscribirse(Deporte deporte) {
        return true; // Los adultos pueden inscribirse en cualquier deporte
    }
}