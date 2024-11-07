package com.miempresa.proyectofinal.SobresFifa;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InicioController {

    @FXML
    private TextField usuarioField;

    @FXML
    private TextField equipoField;

    @FXML
    private void empezar() throws IOException {
        String usuario = usuarioField.getText();
        String equipo = equipoField.getText();
        UsuarioEquipo.setNombreUsuario(usuario);
        UsuarioEquipo.setNombreEquipo(equipo);
        UsuarioEquipo.resetEquipo(); // Reinicia el equipo en caso de que se vuelva a jugar
        App.setRoot("primary");
    }
}
