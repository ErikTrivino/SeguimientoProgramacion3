package com.example.segumiento1programacion3.exceptions;

public class ErrorRetiro extends Exception
{
    public ErrorRetiro(){
        super("El valor ha retirar excede los fondos de la cuenta");
    }
}
