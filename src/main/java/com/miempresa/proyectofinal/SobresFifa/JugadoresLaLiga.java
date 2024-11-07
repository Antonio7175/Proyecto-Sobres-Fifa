package com.miempresa.proyectofinal.SobresFifa;

import java.util.*;

public class JugadoresLaLiga {

    private static List<Jugador> jugadores = new ArrayList<>();
    
    public static List<Jugador> crearListaJugadores() {
    	
  
    	jugadores.add(new Jugador("Lionel Messi", 90, Posicion.ED));
        jugadores.add(new Jugador("Sergio Ramos", 89, Posicion.DFC));
        jugadores.add(new Jugador("Karim Benzema", 88, Posicion.DC));
        jugadores.add(new Jugador("Luis Suárez", 87, Posicion.DC));
        jugadores.add(new Jugador("Antoine Griezmann", 86, Posicion.DC));
        jugadores.add(new Jugador("Jan Oblak", 86, Posicion.POR));
        jugadores.add(new Jugador("Gerard Piqué", 85, Posicion.DFC));
        jugadores.add(new Jugador("Frenkie de Jong", 85, Posicion.MC));
        jugadores.add(new Jugador("Sergio Busquets", 84, Posicion.MC));
        jugadores.add(new Jugador("Marc-André ter Stegen", 84, Posicion.POR));
        jugadores.add(new Jugador("Thibaut Courtois", 83, Posicion.POR));
        jugadores.add(new Jugador("Jordi Alba", 83, Posicion.LI));
        jugadores.add(new Jugador("Raphael Varane", 82, Posicion.DFC));
        jugadores.add(new Jugador("Dani Carvajal", 82, Posicion.LD));
        jugadores.add(new Jugador("Toni Kroos", 81, Posicion.MC));
        jugadores.add(new Jugador("Luka Modric", 81, Posicion.MC));
        jugadores.add(new Jugador("Vinícius Júnior", 80, Posicion.EI));
        jugadores.add(new Jugador("Ivan Rakitic", 80, Posicion.MC));
        jugadores.add(new Jugador("Eden Hazard", 79, Posicion.EI));
        jugadores.add(new Jugador("Ansu Fati", 79, Posicion.EI));
        jugadores.add(new Jugador("Casemiro", 78, Posicion.MC));
        jugadores.add(new Jugador("Philippe Coutinho", 78, Posicion.MCO));
        jugadores.add(new Jugador("Marco Asensio", 78, Posicion.ED));
        jugadores.add(new Jugador("Isco", 77, Posicion.MC));
        jugadores.add(new Jugador("Rodrygo", 77, Posicion.ED));
        jugadores.add(new Jugador("Sergi Roberto", 77, Posicion.MC));
        jugadores.add(new Jugador("Lucas Vázquez", 85, Posicion.MD));
        jugadores.add(new Jugador("Samuel Umtiti", 80, Posicion.DFC));
        jugadores.add(new Jugador("Nelson Semedo", 75, Posicion.LD));
        jugadores.add(new Jugador("Clément Lenglet", 81, Posicion.DFC));
        jugadores.add(new Jugador("Ousmane Dembélé", 86, Posicion.ED));
        jugadores.add(new Jugador("Martin Ødegaard", 87, Posicion.MC));
        jugadores.add(new Jugador("Mikel Oyarzabal", 83, Posicion.EI));
        jugadores.add(new Jugador("Iago Aspas", 83, Posicion.DC));
        jugadores.add(new Jugador("Raúl García", 82, Posicion.MC));
        jugadores.add(new Jugador("Ángel Correa", 82, Posicion.ED));
        jugadores.add(new Jugador("José Luis Gayà", 81, Posicion.LI));
        jugadores.add(new Jugador("Dani Parejo", 81, Posicion.MC));
        jugadores.add(new Jugador("Ángel Rodríguez", 80, Posicion.DC));
        jugadores.add(new Jugador("Maxi Gómez", 80, Posicion.DC));
        jugadores.add(new Jugador("Enes Ünal", 79, Posicion.DC));
        jugadores.add(new Jugador("Roberto Soldado", 78, Posicion.DC));
        jugadores.add(new Jugador("Jaume Costa", 78, Posicion.LI));
        jugadores.add(new Jugador("Joaquín Sánchez", 77, Posicion.MD));
        jugadores.add(new Jugador("Fabián Ruiz", 76, Posicion.MCO));
        jugadores.add(new Jugador("José Campaña", 76, Posicion.MC));
        jugadores.add(new Jugador("Fernando Reges", 75, Posicion.MC));
        jugadores.add(new Jugador("Jorge Molina", 75, Posicion.DC));
        jugadores.add(new Jugador("Adnan Januzaj", 75, Posicion.ED));
        jugadores.add(new Jugador("Santi Cazorla", 85, Posicion.MC));
        jugadores.add(new Jugador("Fernando Torres", 84, Posicion.DC));
        jugadores.add(new Jugador("Diego Costa", 83, Posicion.DC));
        jugadores.add(new Jugador("Dani Olmo", 82, Posicion.MC));
        jugadores.add(new Jugador("Marc Bartra", 81, Posicion.DFC));
        jugadores.add(new Jugador("Gerard Deulofeu", 80, Posicion.EI));
        jugadores.add(new Jugador("Sergio Asenjo", 79, Posicion.POR));
        jugadores.add(new Jugador("Jesús Navas", 78, Posicion.LD));
        jugadores.add(new Jugador("David Villa", 77, Posicion.DC));
        jugadores.add(new Jugador("Alberto Moreno", 76, Posicion.LI));
        jugadores.add(new Jugador("Manu Trigueros", 75, Posicion.MC));
        jugadores.add(new Jugador("Carlos Soler", 84, Posicion.MC));
        jugadores.add(new Jugador("David Soria", 83, Posicion.POR));
        jugadores.add(new Jugador("Gabriel Paulista", 82, Posicion.DFC));
        jugadores.add(new Jugador("Carlos Bacca", 81, Posicion.DC));
        jugadores.add(new Jugador("Vicente Iborra", 80, Posicion.MC));
        jugadores.add(new Jugador("Koke", 82, Posicion.MC));
        jugadores.add(new Jugador("Pau López", 78, Posicion.POR));
        jugadores.add(new Jugador("Roberto Soriano", 77, Posicion.MC));
        jugadores.add(new Jugador("Juan Mata", 76, Posicion.MC));
        jugadores.add(new Jugador("Álvaro Negredo", 75, Posicion.DC));
        jugadores.add(new Jugador("Asier Illarramendi", 68, Posicion.MC));
        jugadores.add(new Jugador("Gonçalo Guedes", 68, Posicion.MCO));
        jugadores.add(new Jugador("Nabil Fekir", 67, Posicion.MCO));
        jugadores.add(new Jugador("Sergio Canales", 67, Posicion.MC));
        jugadores.add(new Jugador("Youssef En-Nesyri", 66, Posicion.DC));
        jugadores.add(new Jugador("David García", 66, Posicion.DFC));
        jugadores.add(new Jugador("Raúl Albiol", 65, Posicion.DFC));
        jugadores.add(new Jugador("Nacho Monreal", 65, Posicion.LI));
        jugadores.add(new Jugador("Adnan Januzaj", 64, Posicion.ED));
        jugadores.add(new Jugador("Manu Trigueros", 64, Posicion.MC));
        jugadores.add(new Jugador("Vicente Iborra", 63, Posicion.MC));
        jugadores.add(new Jugador("Raúl de Tomás", 63, Posicion.DC));
        jugadores.add(new Jugador("Cristhian Stuani", 62, Posicion.DC));
        jugadores.add(new Jugador("Joselu", 62, Posicion.DC));
        jugadores.add(new Jugador("Aleix Vidal", 61, Posicion.MD));
        jugadores.add(new Jugador("Antonio Barragán", 61, Posicion.LD));
        jugadores.add(new Jugador("Óscar Rodríguez", 60, Posicion.MCO));
        jugadores.add(new Jugador("Roberto Torres", 60, Posicion.MCO));
        jugadores.add(new Jugador("Carlos Fernández", 59, Posicion.DC));
        jugadores.add(new Jugador("Kenedy", 59, Posicion.EI));
        jugadores.add(new Jugador("Luis Milla", 58, Posicion.MC));
        jugadores.add(new Jugador("Antonio Puertas", 58, Posicion.MD));
        jugadores.add(new Jugador("Claudio Bravo", 57, Posicion.POR));
        jugadores.add(new Jugador("Rubén Rochina", 57, Posicion.MC));
        jugadores.add(new Jugador("Adrián Embarba", 56, Posicion.ED));
        jugadores.add(new Jugador("Álex Moreno", 56, Posicion.LI));
        jugadores.add(new Jugador("Antonio Adán", 55, Posicion.POR));
        jugadores.add(new Jugador("Alfonso Pedraza", 55, Posicion.LI));
        jugadores.add(new Jugador("Yeray Álvarez", 54, Posicion.DFC));
        jugadores.add(new Jugador("Álvaro Negredo", 54, Posicion.DC));
        jugadores.add(new Jugador("Paco Alcácer", 53, Posicion.DC));
        jugadores.add(new Jugador("Álex Fernández", 53, Posicion.MC));
        jugadores.add(new Jugador("Daniel Wass", 52, Posicion.MD));
        jugadores.add(new Jugador("Papu Gómez", 52, Posicion.MCO));
        jugadores.add(new Jugador("Carlos Soler", 51, Posicion.MC));
        jugadores.add(new Jugador("Kevin Rodrigues", 51, Posicion.LI));
        jugadores.add(new Jugador("Lucas Pérez", 50, Posicion.DC));
        jugadores.add(new Jugador("Jaume Doménech", 50, Posicion.POR));

        return jugadores;
    }




}

