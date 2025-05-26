package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.exceptions.CorreoInvalidoException;
import co.edu.uniquindio.alquiler.model.Ciudadano;
import co.edu.uniquindio.alquiler.model.DatosSesion;
import co.edu.uniquindio.alquiler.model.TiendaUQ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Button ingresarButton;
    @FXML
    private Label correoLbl;
    @FXML
    private Label contraseniaLbl;
    @FXML
    private TextField correoTxtfield;
    @FXML
    private TextField contraseniaTxtField;

    public TiendaUQ tienda= TiendaUQ.getInstance();
    public DatosSesion datos=DatosSesion.getInstance();

    public void ingresarOnAction(ActionEvent actionEvent) {
        String correo=correoTxtfield.getText();
        String contrasenia=contraseniaTxtField.getText();

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
            }
        }
        catch (AtributoVacioException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }


    }
}
