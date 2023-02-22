package com.example.segumiento1programacion3;

import com.example.segumiento1programacion3.exceptions.ErrorRetiro;
import com.example.segumiento1programacion3.modelo.AppController;
import com.example.segumiento1programacion3.modelo.Cuenta;
import com.example.segumiento1programacion3.modelo.Empleado;
import com.example.segumiento1programacion3.modelo.EstadoTransaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class TransaccionController {
    @FXML
    private TextField txtDepositar;
    @FXML
    private TextField txtValorRetiro;
    private String numCuenta;
    private Cuenta cuenta;
    private Empleado empleado;





    public void init(String numCuenta, Stage stage, LoginController loginController) {

        this.cuenta = AppController.INSTANCE.getBanco().buscarCuentaByNumeroIdentificacion(numCuenta);

        this.empleado = AppController.INSTANCE.getBanco().getListaEmpleado().get(0);
    }


    public void salirVentana(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login-Unibanco.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        LoginController inicioForm = loader.getController();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }

    public void retirarSaldo(ActionEvent actionEvent) throws ErrorRetiro {
        try {
            AppController.INSTANCE.getBanco().retirarSaldo(Double.valueOf(txtValorRetiro.getText()), LocalTime.now(), LocalDate.now(), EstadoTransaccion.ACEPTADO, empleado, cuenta, Double.valueOf(txtValorRetiro.getText()));
            limpiarCampos();

        }catch (Exception e){
            mostrarMensaje(e.getMessage());
            AppController.INSTANCE.getBanco().retirarSaldo(Double.valueOf(txtValorRetiro.getText()), LocalTime.now(), LocalDate.now(), EstadoTransaccion.RECHAZADO, empleado, cuenta, Double.valueOf(txtValorRetiro.getText()));
        }




    }

    public void depositarDinero(ActionEvent actionEvent) {

        AppController.INSTANCE.getBanco().depositarDineroV2(Double.valueOf(txtDepositar.getText()), LocalTime.now(), LocalDate.now(), EstadoTransaccion.ACEPTADO, empleado, cuenta, Double.valueOf(txtDepositar.getText()));
        limpiarCampos();
    }

    public void mostarSaldo(ActionEvent actionEvent) {

        AppController.INSTANCE.getBanco().mostrarSaldo(LocalTime.now(), LocalDate.now(), EstadoTransaccion.ACEPTADO, empleado, cuenta);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("SALDO");
        alert.setContentText("Este es su saldo actual "+ cuenta.getSaldo() );
        alert.showAndWait();
    }

    public void limpiarCampos(){
        txtDepositar.setText("");
        txtValorRetiro.setText("");
    }
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
