package com.example.segumiento1programacion3.modelo;

public enum AppController {
    INSTANCE;

    private final Banco  banco;

    AppController() {
        banco = new Banco("Unibanco");
    }

    public Banco getBanco(){
        return banco;
    }
}
