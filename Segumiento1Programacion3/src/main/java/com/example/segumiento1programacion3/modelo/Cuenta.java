package com.example.segumiento1programacion3.modelo;

import com.example.segumiento1programacion3.exceptions.ErrorRetiro;

public class Cuenta {
    private String numeroCuenta;
    protected Double Saldo;

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.Saldo = 50.0;

    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public Double getSaldo() {
        return Saldo;
    }



    public void agregarSaldo(Double valor){
        this.Saldo += valor;
    }
    public void retirarSaldo(Double valor) throws ErrorRetiro {
        if(this.Saldo < valor){
            throw new ErrorRetiro();

        }

        this.Saldo -= valor;
    }

    @Override
    public String toString() {
        return "Cuenta hola{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", Saldo=" + Saldo +
                '}';
    }
}
