package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClubDeportivoApp {

    private static List<Deporte> deportes = new ArrayList<>();
    private static List<Entrenador> entrenadores = new ArrayList<>();
    private static List<Miembro> miembros = new ArrayList<>();
    private static List<SesionEntrenamiento> sesiones = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Administrador admin = new Administrador("Pedro", "123");

        while (true) {
            System.out.println("1. Crear Deporte");
            System.out.println("2. Crear Entrenador");
            System.out.println("3. Crear Miembro");
            System.out.println("4. Programar Sesión de Entrenamiento");
            System.out.println("5. Gestionar Sesión");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> crearDeporte(scanner);
                case 2 -> crearEntrenador(scanner);
                case 3 -> crearMiembro(scanner);
                case 4 -> programarSesion(scanner, admin);
                case 5 -> gestionarSesion(scanner, admin);
                case 6 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción no válida");
            }
        }
    }

    private static void crearDeporte(Scanner scanner) {
        System.out.print("Nombre del deporte: ");
        String nombre = scanner.next();
        System.out.print("Descripción: ");
        String descripcion = scanner.next();
        System.out.print("Nivel de dificultad (1. BAJA, 2. MEDIA, 3. ALTA): ");
        int nivel = scanner.nextInt();
        NivelDificultad nivelDificultad = switch (nivel) {
            case 1 -> NivelDificultad.BAJA;
            case 2 -> NivelDificultad.MEDIA;
            case 3 -> NivelDificultad.ALTA;
            default -> throw new IllegalArgumentException("Nivel no válido");
        };
        deportes.add(new Deporte(nombre, descripcion, nivelDificultad, new ArrayList<>()));
        System.out.println("Deporte creado exitosamente.");
    }

    private static void crearEntrenador(Scanner scanner) {
        System.out.print("Nombre del entrenador: ");
        String nombre = scanner.next();
        System.out.print("Especialidad: ");
        String especialidad = scanner.next();
        entrenadores.add(new Entrenador(nombre, especialidad, new ArrayList<>()));
        System.out.println("Entrenador creado exitosamente.");
    }

    private static void crearMiembro(Scanner scanner) {
        System.out.print("Nombre del miembro: ");
        String nombre = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("ID: ");
        String id = scanner.next();
        System.out.print("Tipo de miembro (1. Juvenil, 2. Adulto): ");
        int tipo = scanner.nextInt();
        Miembro miembro = switch (tipo) {
            case 1 -> new Juvenil(nombre, email, id);
            case 2 -> new Adulto(nombre, email, id);
            default -> throw new IllegalArgumentException("Tipo no válido");
        };
        miembros.add(miembro);
        System.out.println("Miembro creado exitosamente.");
    }

    private static void programarSesion(Scanner scanner, Administrador admin) {
        System.out.print("Fecha (YYYY-MM-DD HH:MM): ");
        String fecha = scanner.next() + " " + scanner.next();
        System.out.print("Duración (en minutos): ");
        int duracion = scanner.nextInt();
        System.out.print("Deporte: ");
        String deporteNombre = scanner.next();
        Deporte deporte = deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(deporteNombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Deporte no encontrado"));
        System.out.print("Entrenador: ");
        String entrenadorNombre = scanner.next();
        Entrenador entrenador = entrenadores.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(entrenadorNombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Entrenador no encontrado"));

        SesionEntrenamiento sesion = new SesionEntrenamiento(LocalDateTime.parse(fecha), duracion, TipoEstado.PROGRAMADA, deporte, entrenador);
        admin.programarSesion(sesiones, sesion);
        System.out.println("Sesión programada exitosamente.");
    }

    private static void gestionarSesion(Scanner scanner, Administrador admin) {
        System.out.print("Deporte de la sesión: ");
        String deporteNombre = scanner.next();
        SesionEntrenamiento sesion = admin.buscarSesion(sesiones, s -> s.getDeporte().getNombre().equalsIgnoreCase(deporteNombre))
                .orElseThrow(() -> new IllegalArgumentException("Sesión no encontrada"));

        System.out.print("Nuevo estado (1. PROGRAMADA, 2. COMPLETADA): ");
        int estado = scanner.nextInt();
        TipoEstado nuevoEstado = estado == 1 ? TipoEstado.PROGRAMADA : TipoEstado.COMPLETADA;
        admin.gestionarSesion(sesion, nuevoEstado);
        System.out.println("Sesión actualizada exitosamente.");
    }
}
