package co.edu.uniquindio.alquiler.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProyectoGrupalApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(ProyectoGrupalApp.class.getResource("/ventanas/Compra.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Comprar");
        stage.show();


    }

    public static void main(String[] args) {
        launch(ProyectoGrupalApp.class, args);
    }

}