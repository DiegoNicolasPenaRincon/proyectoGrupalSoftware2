package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.exceptions.ContraseniaException;
import co.edu.uniquindio.alquiler.exceptions.CorreoInvalidoException;
import co.edu.uniquindio.alquiler.model.Ciudadano;
import co.edu.uniquindio.alquiler.model.DatosSesion;
import co.edu.uniquindio.alquiler.model.TiendaUQ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private PasswordField contraseniaPassField;
    @FXML
    private Button ingresarButton;
    @FXML
    private Label correoLbl;
    @FXML
    private Label contraseniaLbl;
    @FXML
    private TextField correoTxtfield;

    public TiendaUQ tienda= TiendaUQ.getInstance();
    public DatosSesion datos=DatosSesion.getInstance();

    public void ingresarOnAction(ActionEvent actionEvent) {
        String correo=correoTxtfield.getText();
        String contrasenia=contraseniaPassField.getText();

        try
        {
            if(correo.isEmpty())
            {
                throw new AtributoVacioException("Debe ingresar su correo");
            }

            if(contrasenia.isEmpty())
            {
                throw new AtributoVacioException("Debe ingresar su contrasenia");
            }

            Ciudadano ciudadano=tienda.verificarUsuario(correo,contrasenia);

            if(ciudadano==null)
            {
                throw new CorreoInvalidoException("El estudiante no se encuentra registrado");
            }
            else
            {
                datos.setCiudadanoSeleccionado(ciudadano);
                inicializarComprasInterfaz();

            }
        }
        catch (AtributoVacioException | ContraseniaException | CorreoInvalidoException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void inicializarComprasInterfaz() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/Compra.fxml"));
        Parent root = loader.load();

        CompraController compras =loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
