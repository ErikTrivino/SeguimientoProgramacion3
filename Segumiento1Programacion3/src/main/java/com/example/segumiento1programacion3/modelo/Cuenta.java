package com.example.segumiento1programacion3.modelo;

public class Cuenta {
    private String numeroCuenta;
    private Double Saldo;

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
    public void retirarSaldo(Double valor){
        this.Saldo -= valor;
    }




}
