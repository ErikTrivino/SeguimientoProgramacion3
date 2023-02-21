package com.example.segumiento1programacion3.exceptions;

public class ErrorValor extends Exception{
    public ErrorValor() {
        super(String.format("El valor ingresado es incorrecto"));
    }
}
