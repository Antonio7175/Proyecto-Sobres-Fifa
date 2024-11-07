package com.miempresa.proyectofinal.SobresFifa;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class BienvenidaController {
	
    @FXML
    private void irARegistro() throws IOException {
        App.setRoot("inicio");
    }
}


