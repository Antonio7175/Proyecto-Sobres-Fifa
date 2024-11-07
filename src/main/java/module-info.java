module com.miempresa.proyectofinal.SobresFifa {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.pdfbox;
	requires org.apache.poi.ooxml;
	requires javafx.graphics;
	requires javafx.base;

    opens com.miempresa.proyectofinal.SobresFifa to javafx.fxml;
    exports com.miempresa.proyectofinal.SobresFifa;
}
