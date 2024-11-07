package com.miempresa.proyectofinal.SobresFifa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class PrimaryController {

    private static List<Jugador> jugadores;
    private Sobres sobres;
    private int sobresAbiertos = 0;
    private int jugadoresSeleccionados = 0;
    private Stage primaryStage;

    @FXML
    private VBox Contenedor;

    @FXML
    private Label usuarioLabel;

    @FXML
    private Label equipoLabel;

    @FXML
    private Button enfrentarseARivalButton;

    @FXML
    private Button reiniciarButton;

    @FXML
    private void verEquipoRival() {
        List<Jugador> jugadoresRivales = generarEquipoRivalAleatorio();
        mostrarEquipos("Equipo rival", jugadoresRivales);
    }

    @FXML
    private void verMiEquipo() {
        List<Jugador> miEquipo = UsuarioEquipo.getEquipo();
        mostrarEquipos("Tu equipo", miEquipo);
    }

    public static List<Jugador> getJugadores() {
        return jugadores;
    }

    @FXML
    private void initialize() {
        jugadores = JugadoresLaLiga.crearListaJugadores();
        sobres = new Sobres(jugadores);
        usuarioLabel.setText("Usuario: " + UsuarioEquipo.getNombreUsuario());
        equipoLabel.setText("Equipo: " + UsuarioEquipo.getNombreEquipo());
        enfrentarseARivalButton.setDisable(true); // Asegurarse de que el botón está deshabilitado al iniciar
    }

    @FXML
    private void selectSobre1() throws IOException {
        abrirSobre();
    }

    @FXML
    private void selectSobre2() throws IOException {
        abrirSobre();
    }

    @FXML
    private void selectSobre3() throws IOException {
        abrirSobre();
    }

    private void abrirSobre() throws IOException {
        if (sobresAbiertos < 11 && jugadoresSeleccionados < 11) {
            List<Jugador> sobre = sobres.generarSobre();
            sobresAbiertos++;
            SecondaryController.setJugadores(sobre); // Establecer jugadores en el controlador secundario
            mostrarSecondaryStage(); // Mostrar la ventana secundaria
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "Ya has abierto todos los sobres o seleccionado todos los jugadores.");
            alert.showAndWait();
        }
    }

    private void mostrarSecondaryStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent root = loader.load();
        SecondaryController secondaryController = loader.getController();
        secondaryController.setPrimaryController(this);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void jugadorSeleccionado() {
        jugadoresSeleccionados++;
        if (jugadoresSeleccionados == 11) {
            enfrentarseARivalButton.setDisable(false); // Habilitar el botón
            generarDocumentos();
        }
    }

    @FXML
    private void enfrentarseARival() {
        List<Jugador> jugadoresRivales = generarEquipoRivalAleatorio();

        int valoracionTotalUsuario = UsuarioEquipo.getEquipo().stream().mapToInt(Jugador::getValoracion).sum();
        int valoracionTotalRival = jugadoresRivales.stream().mapToInt(Jugador::getValoracion).sum();

        String resultado;
        if (valoracionTotalUsuario > valoracionTotalRival) {
            resultado = "¡Has ganado!";
        } else if (valoracionTotalUsuario < valoracionTotalRival) {
            resultado = "Has perdido.";
        } else {
            resultado = "Es un empate.";
        }

        // Crear un mensaje con el resultado y los botones para ver los equipos
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Valoración total de tu equipo: ").append(valoracionTotalUsuario).append("\n");
        mensaje.append("Valoración total del equipo rival: ").append(valoracionTotalRival).append("\n\n");
        mensaje.append(resultado).append("\n");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultado");
        alert.setHeaderText(null);
        alert.setContentText(mensaje.toString());

        ButtonType buttonCompararEquipos = new ButtonType("Comparar Equipos");

        alert.getButtonTypes().setAll(buttonCompararEquipos);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonCompararEquipos) {
            compararEquipos();
        }
    }

    private void mostrarEquipos(String nombreEquipo, List<Jugador> jugadores) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(nombreEquipo).append(":\n");
        for (Jugador jugador : jugadores) {
            mensaje.append(jugador.getNombre()).append(" - ").append(jugador.getValoracion()).append("\n");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(nombreEquipo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje.toString());
        alert.showAndWait();
    }

    @FXML
    private void compararEquipos() {
        List<Jugador> miEquipo = UsuarioEquipo.getEquipo();
        List<Jugador> jugadoresRivales = generarEquipoRivalAleatorio();

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Mi Equipo:\n");
        for (Jugador jugador : miEquipo) {
            mensaje.append(jugador.getNombre()).append(" - ").append(jugador.getValoracion()).append("\n");
        }

        mensaje.append("\nEquipo Rival:\n");
        for (Jugador jugador : jugadoresRivales) {
            mensaje.append(jugador.getNombre()).append(" - ").append(jugador.getValoracion()).append("\n");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Comparación de Equipos");
        alert.setHeaderText(null);
        alert.setContentText(mensaje.toString());
        alert.showAndWait();
    }

    private List<Jugador> generarEquipoRivalAleatorio() {
        List<Jugador> jugadoresRivales = new ArrayList<>();
        Random random = new Random();
        List<Jugador> todosLosJugadores = JugadoresLaLiga.crearListaJugadores();
        Collections.shuffle(todosLosJugadores);

        for (int i = 0; i < 11; i++) {
            jugadoresRivales.add(todosLosJugadores.get(i));
        }

        return jugadoresRivales;
    }

    private void generarDocumentos() {
        String nombreUsuario = UsuarioEquipo.getNombreUsuario();
        String nombreEquipo = UsuarioEquipo.getNombreEquipo();
        List<Jugador> jugadoresSeleccionados = UsuarioEquipo.getEquipo();

        // Generar el PDF y el Word con la información
        try {
            generarPdf(nombreUsuario, nombreEquipo, jugadoresSeleccionados);
            generarWord(nombreUsuario, nombreEquipo, jugadoresSeleccionados);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Se han generado los documentos con éxito.");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ha ocurrido un error al generar los documentos.");
            alert.showAndWait();
        }
    }

    private void generarPdf(String nombreUsuario, String nombreEquipo, List<Jugador> jugadores) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
            contentStream.newLineAtOffset(50, 750);
            contentStream.showText("Equipo de " + nombreUsuario);
            contentStream.newLineAtOffset(0, -30);
            contentStream.setFont(PDType1Font.HELVETICA, 16);
            contentStream.showText("Nombre del Equipo: " + nombreEquipo);
            contentStream.newLineAtOffset(0, -20);

            for (Jugador jugador : jugadores) {
                contentStream.setFont(PDType1Font.HELVETICA, 8);
                contentStream.showText("Nombre: " + jugador.getNombre() + " Posición: " + jugador.getPosicion() + " Valoracion: " + jugador.getValoracion() + " Atributos: " + jugador.getAtributos().toString());
                contentStream.newLineAtOffset(0, -20);
            }
            contentStream.endText();
        }

        document.save("Equipo_" + nombreUsuario + ".pdf");
        document.close();
    }

    private void generarWord(String nombreUsuario, String nombreEquipo, List<Jugador> jugadores) throws IOException {
        XWPFDocument document = new XWPFDocument();

        XWPFParagraph title = document.createParagraph();
        XWPFRun titleRun = title.createRun();
        titleRun.setText("Equipo de " + nombreUsuario);
        titleRun.setBold(true);
        titleRun.setFontSize(20);

        XWPFParagraph teamName = document.createParagraph();
        XWPFRun teamNameRun = teamName.createRun();
        teamNameRun.setText("Nombre del Equipo: " + nombreEquipo);
        teamNameRun.setFontSize(16);

        for (Jugador jugador : jugadores) {
            XWPFParagraph jugadorParrafo = document.createParagraph();
            XWPFRun jugadorRun = jugadorParrafo.createRun();
            jugadorRun.setText("Nombre: " + jugador.getNombre() + " Posición: " + jugador.getPosicion() + " Valoracion: " + jugador.getValoracion() + " Atributos: " + jugador.getAtributos().toString());
            jugadorRun.setFontSize(12);
        }

        try (FileOutputStream out = new FileOutputStream("Equipo_" + nombreUsuario + ".docx")) {
            document.write(out);
        }
    }
    

    @FXML
    private void reiniciar() {
        sobresAbiertos = 0;
        jugadoresSeleccionados = 0;
        UsuarioEquipo.getEquipo().clear();
        enfrentarseARivalButton.setDisable(true); // Deshabilitar el botón nuevamente

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "El juego se ha reiniciado.");
        alert.showAndWait();
    }

    @FXML
    private void salirDeLaApp() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de que deseas salir?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirmar salida");
        alert.setHeaderText(null);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            Stage stage = (Stage) Contenedor.getScene().getWindow();
            stage.close();
        }
    }

}

