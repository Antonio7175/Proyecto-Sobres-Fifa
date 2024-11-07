package com.miempresa.proyectofinal.SobresFifa;

import java.util.ArrayList;
import java.util.List;

public class UsuarioEquipo {
    private static String nombreUsuario;
    private static String nombreEquipo;
    private static List<Jugador> equipo = new ArrayList<>();

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        UsuarioEquipo.nombreUsuario = nombreUsuario;
    }

    public static String getNombreEquipo() {
        return nombreEquipo;
    }

    public static void setNombreEquipo(String nombreEquipo) {
        UsuarioEquipo.nombreEquipo = nombreEquipo;
    }

    public static List<Jugador> getEquipo() {
        return equipo;
    }

    public static void agregarJugadorAlEquipo(Jugador jugador) {
        equipo.add(jugador);
    }

    public static void resetEquipo() {
        equipo.clear();
    }
}
