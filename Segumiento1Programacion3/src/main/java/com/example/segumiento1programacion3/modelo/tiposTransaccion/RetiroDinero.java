package com.example.segumiento1programacion3.modelo.tiposTransaccion;

import com.example.segumiento1programacion3.exceptions.ErrorRetiro;
import com.example.segumiento1programacion3.modelo.Cuenta;
import com.example.segumiento1programacion3.modelo.Empleado;
import com.example.segumiento1programacion3.modelo.EstadoTransaccion;
import com.example.segumiento1programacion3.modelo.Transaccion;

import java.time.LocalDate;
import java.time.LocalTime;

public class RetiroDinero extends Transaccion {


    private double dineroRetirado;


    public RetiroDinero(Double registroValor, LocalTime hora, LocalDate fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, String numCuenta, double dineroRetirado) {
        super(registroValor, hora, fecha, estadoTransaccion, empleado, numCuenta);
        this.dineroRetirado = dineroRetirado;
    }

    public void retirarDinero(Cuenta cuenta, Double valorRetirar) throws ErrorRetiro {
         cuenta.retirarSaldo(valorRetirar);
    }
}
