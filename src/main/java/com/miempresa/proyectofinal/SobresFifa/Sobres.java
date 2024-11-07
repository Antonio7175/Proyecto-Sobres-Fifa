package com.miempresa.proyectofinal.SobresFifa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sobres {
    private final List<Jugador> jugadores;
    private final Random random;

    public Sobres(List<Jugador> jugadores) {
        this.jugadores = new ArrayList<>(jugadores);
        this.random = new Random();
    }

    public List<Jugador> generarSobre() {
        Collections.shuffle(PrimaryController.getJugadores());
        return new ArrayList<>(PrimaryController.getJugadores().subList(0, 5)); 
    }
}
