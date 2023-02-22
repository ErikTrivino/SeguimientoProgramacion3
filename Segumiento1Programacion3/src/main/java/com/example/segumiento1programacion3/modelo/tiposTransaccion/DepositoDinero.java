package com.example.segumiento1programacion3.modelo.tiposTransaccion;

import com.example.segumiento1programacion3.modelo.Cuenta;
import com.example.segumiento1programacion3.modelo.Empleado;
import com.example.segumiento1programacion3.modelo.EstadoTransaccion;
import com.example.segumiento1programacion3.modelo.Transaccion;

import java.time.LocalDate;
import java.time.LocalTime;

public class DepositoDinero extends Transaccion {


    private double dineroDepositado;


    public DepositoDinero(Double registroValor, LocalTime hora, LocalDate fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, String numCuenta, double dineroDepositado) {
        super(registroValor, hora, fecha, estadoTransaccion, empleado, numCuenta);
        this.dineroDepositado = dineroDepositado;
    }


    public void agregarSaldo(Cuenta cuenta){
        cuenta.agregarSaldo(dineroDepositado);
    }
}
