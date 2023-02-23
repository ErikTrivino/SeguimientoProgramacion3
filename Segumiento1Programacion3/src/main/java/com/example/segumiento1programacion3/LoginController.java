package com.example.segumiento1programacion3;

import com.example.segumiento1programacion3.exceptions.ErrorValor;
import com.example.segumiento1programacion3.modelo.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {
    public ImageView imagenLogin;
    @FXML
    private TextField numeroIdentificacion;
    @FXML
    private TextField numeroCuenta;




    @FXML
    public void initialize() {
        //Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("UNIBANCO.png")));
        //imagenLogin.setImage(image1);
    }


    @FXML
    public void verificarIngreso(ActionEvent actionEvent) throws ErrorValor, IOException {
        try{
            if(AppController.INSTANCE.getBanco().verificarCuenta(numeroIdentificacion.getText(), numeroCuenta.getText())){

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("transacciones.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                TransaccionController inicioForm = loader.getController();
                //inicioForm.init(user,cargoUsuario(user, pass));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                //stage.setTitle("Tu Finca Raíz | Inicio");
                stage.setScene(scene);

                inicioForm.init(numeroCuenta.getText(), stage, this);

                stage.setResizable(false);
                stage.centerOnScreen();
                limpiarCampos();
                stage.show();



            }

        }catch (ErrorValor e){
            mostrarMensaje(e.getMessage());
            limpiarCampos();
        }




    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    public void limpiarCampos(){
        numeroIdentificacion.setText("");
        numeroCuenta.setText("");
    }
}
