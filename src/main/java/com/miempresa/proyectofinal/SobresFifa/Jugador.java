package com.miempresa.proyectofinal.SobresFifa;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Jugador {
    private static final Random random = new Random();
    private String nombre;
    private int valoracion;
    private Posicion posicion;
    private Map<Atributo, Integer> atributos;

    public Jugador(String nombre, int valoracion, Posicion posicion) {
        this.nombre = nombre;
        this.valoracion = valoracion;
        this.posicion = posicion;
        this.atributos = crearJugador(valoracion);
    }

    public String getNombre() {
        return nombre;
    }

    public int getValoracion() {
        return valoracion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public Map<Atributo, Integer> getAtributos() {
        return atributos;
    }
    
    private static int generarAtributo(int valoracion) {
        return 50 + (int)((valoracion - 50) * random.nextDouble());
    }
    
    private static Map<Atributo, Integer> crearJugador(int valoracion) {
        Map<Atributo, Integer> atributos = new HashMap<>();
        atributos.put(Atributo.RITMO, generarAtributo(valoracion));
        atributos.put(Atributo.TIRO, generarAtributo(valoracion));
        atributos.put(Atributo.PASE, generarAtributo(valoracion));
        atributos.put(Atributo.REGATE, generarAtributo(valoracion));
        atributos.put(Atributo.DEFENSA, generarAtributo(valoracion));
        atributos.put(Atributo.FISICO, generarAtributo(valoracion));
        
        return atributos;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Valoración: ").append(valoracion).append("\n");
        sb.append("Posición: ").append(posicion).append("\n");
        sb.append("Atributos:\n");
        for (Map.Entry<Atributo, Integer> atributo : atributos.entrySet()) {
            sb.append(" \n ").append(atributo.getKey()).append(": ").append(atributo.getValue()).append("\n");
        }
        return sb.toString();
    }
}
