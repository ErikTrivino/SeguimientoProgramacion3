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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class TransaccionController {

    public Label txtNumcuenta;
    public Label txtNumcuenta2;
    public Label txtNumcuenta1;
    @FXML
    private TextField txtDepositar;
    @FXML
    private TextField txtValorRetiro;
    private String numCuenta;
    private Cuenta cuenta;
    private Empleado empleado;


    @FXML
    public void initialize() {


    }



    public void init(String numCuenta, Stage stage, LoginController loginController) {

        this.cuenta = AppController.INSTANCE.getBanco().buscarCuentaByNumeroIdentificacion(numCuenta);
        txtNumcuenta.setText("Numero de la cuenta "+ numCuenta);
        txtNumcuenta1.setText("Numero de la cuenta "+ numCuenta);
        txtNumcuenta2.setText("Numero de la cuenta "+ numCuenta);

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

        if(txtValorRetiro.getText()!= ""){
            try {
                AppController.INSTANCE.getBanco().retirarSaldo(Double.valueOf(txtValorRetiro.getText()), LocalTime.now(), LocalDate.now(), EstadoTransaccion.ACEPTADO, empleado, cuenta, Double.valueOf(txtValorRetiro.getText()));
                limpiarCampos();

            }catch (Exception e){
                mostrarMensaje(e.getMessage());
                AppController.INSTANCE.getBanco().retirarSaldo(Double.valueOf(txtValorRetiro.getText()), LocalTime.now(), LocalDate.now(), EstadoTransaccion.RECHAZADO, empleado, cuenta, Double.valueOf(txtValorRetiro.getText()));
            }

            mostrarMensajeTransaccion("Se ha completado el retiro y su saldo actual es "+ cuenta.getSaldo());
        }else {
            mostrarMensaje("Ingrese por favor el valor a retirar");
        }





    }

    public void depositarDinero(ActionEvent actionEvent) {
        if(txtDepositar.getText()!=""){
            AppController.INSTANCE.getBanco().depositarDineroV2(Double.valueOf(txtDepositar.getText()), LocalTime.now(), LocalDate.now(), EstadoTransaccion.ACEPTADO, empleado, cuenta, Double.valueOf(txtDepositar.getText()));
            mostrarMensajeTransaccion("Se ha completado el deposito de dinero y su saldo actual es "+ cuenta.getSaldo());
            limpiarCampos();
        }else {
            mostrarMensaje("Ingrese por favor el valor a depositar");
        }


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
    private void mostrarMensajeTransaccion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
