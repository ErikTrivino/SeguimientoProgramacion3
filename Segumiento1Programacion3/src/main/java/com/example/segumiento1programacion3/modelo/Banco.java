package com.example.segumiento1programacion3.modelo;

import java.util.ArrayList;

public class Banco {

    private String nombre;
    private ArrayList<Cliente> listaClientes ;
    private ArrayList<Cuenta> listaCuentas ;
    private ArrayList<Transaccion> listaTransaccion ;
    private ArrayList<Empleado> listaEmpleado ;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.listaClientes = new ArrayList<>();
        this.listaCuentas = new ArrayList<>();
        this.listaTransaccion = new ArrayList<>();
        this.listaEmpleado = new ArrayList<>();
    }




    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public ArrayList<Transaccion> getListaTransaccion() {
        return listaTransaccion;
    }

    public void setListaTransaccion(ArrayList<Transaccion> listaTransaccion) {
        this.listaTransaccion = listaTransaccion;
    }

    public ArrayList<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }
}
