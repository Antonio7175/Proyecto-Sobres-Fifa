package com.miempresa.proyectofinal.SobresFifa;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class App extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bienvenida.fxml"));
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setFullScreen(true); // Configurar la etapa para iniciar en pantalla completa
        stage.show();
    
    
    // Manejar el evento de cierre para todas las ventanas posteriores
    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            event.consume(); // Deshabilitar el botón de cerrar
        }
    });
}

    public static void setRoot(String fxml) throws IOException {
        Parent newRoot = FXMLLoader.load(App.class.getResource(fxml + ".fxml"));
        scene.setRoot(newRoot);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
