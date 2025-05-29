package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class CarritosCompraController {


    @FXML
    private Button regresarBtn;
    @FXML
    private TableView<Producto> productoTable;
    @FXML
    private Button eliminarCarritoBtn;

    public void regresarOnAction(ActionEvent actionEvent) {
    }

    public void eliminarCarritoOnAction(ActionEvent actionEvent) {
    }
}
