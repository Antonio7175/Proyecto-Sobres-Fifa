package com.miempresa.proyectofinal.SobresFifa;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class SecondaryController {

    private static List<Jugador> jugadoresDelSobre;
    private PrimaryController primaryController;

    @FXML
    private VBox contenedor;

    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }

    public static void setJugadores(List<Jugador> jugadores) {
        jugadoresDelSobre = jugadores;
    }

    @FXML
    public void initialize() {
        contenedor.getChildren().clear(); // Asegúrate de limpiar el contenedor para evitar duplicados

        // Mostrar botones para cada jugador en el sobre
        for (Jugador jugador : jugadoresDelSobre) {
            Button boton = new Button("Jugador: " + jugador.getNombre() + " (" + jugador.getValoracion() + ")");

            boton.setOnAction(event -> {
                try {
                    if (UsuarioEquipo.getEquipo().size() < 11) {
                        UsuarioEquipo.agregarJugadorAlEquipo(jugador);
                        primaryController.jugadorSeleccionado();
                        PrimaryController.getJugadores().remove(jugador);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Jugador agregado al equipo.");
                        alert.showAndWait();

                        // Cerrar la ventana secundaria
                        Stage stage = (Stage) boton.getScene().getWindow();
                        stage.close();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ya has seleccionado todos los jugadores.");
                        alert.showAndWait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            contenedor.getChildren().add(boton);
        }
        
        
    }
}
