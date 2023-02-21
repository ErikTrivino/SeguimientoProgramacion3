package com.example.segumiento1programacion3.modelo.tiposTransaccion;

import com.example.segumiento1programacion3.modelo.Cuenta;
import com.example.segumiento1programacion3.modelo.Empleado;
import com.example.segumiento1programacion3.modelo.EstadoTransaccion;
import com.example.segumiento1programacion3.modelo.Transaccion;

import java.util.Date;

public class SolicitudSaldo extends Transaccion {

    public SolicitudSaldo(Double registroValor, Date hora, Date fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, String numCuenta) {
        super(registroValor, hora, fecha, estadoTransaccion, empleado, numCuenta);
    }

    public String mostrarSaldo(Cuenta cuenta){
        return ("Este es el saldo de su cuenta "+cuenta.getSaldo());
    }


}
