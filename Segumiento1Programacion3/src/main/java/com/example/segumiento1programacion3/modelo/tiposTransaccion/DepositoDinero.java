package com.example.segumiento1programacion3.modelo.tiposTransaccion;

import com.example.segumiento1programacion3.modelo.Cuenta;
import com.example.segumiento1programacion3.modelo.Empleado;
import com.example.segumiento1programacion3.modelo.EstadoTransaccion;
import com.example.segumiento1programacion3.modelo.Transaccion;

import java.util.Date;

public class DepositoDinero extends Transaccion {


    private double dineroDepositado;


    public DepositoDinero(Double registroValor, Date hora, Date fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, String numCuenta, double dineroDepositado) {
        super(registroValor, hora, fecha, estadoTransaccion, empleado, numCuenta);
        this.dineroDepositado = dineroDepositado;
    }


    public void agregarSaldo(Cuenta cuenta){
        cuenta.agregarSaldo(dineroDepositado);
    }
}
