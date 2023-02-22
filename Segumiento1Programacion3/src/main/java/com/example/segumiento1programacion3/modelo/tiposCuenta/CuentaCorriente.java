package com.example.segumiento1programacion3.modelo.tiposCuenta;

import com.example.segumiento1programacion3.exceptions.ErrorRetiro;
import com.example.segumiento1programacion3.modelo.Cuenta;

public class CuentaCorriente extends Cuenta  {
    private Double impuesto;

    public CuentaCorriente(String numeroCuenta, Double impuesto) {
        super(numeroCuenta);
        this.impuesto = impuesto;
    }
    @Override
    public void retirarSaldo(Double valor) throws ErrorRetiro {
        if ( this.Saldo < (valor + (getSaldo()*impuesto)/100)){

            throw new ErrorRetiro();
        }

        this.Saldo -= (valor +((getSaldo()*impuesto)/100));
    }


}
