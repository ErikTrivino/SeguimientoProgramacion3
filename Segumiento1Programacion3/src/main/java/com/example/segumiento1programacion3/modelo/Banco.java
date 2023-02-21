package com.example.segumiento1programacion3.modelo;

import com.example.segumiento1programacion3.exceptions.ErrorValor;
import com.example.segumiento1programacion3.modelo.tiposTransaccion.DepositoDinero;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

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

    public void setListaTransaccion(ArrayList<Transaccion> listaTransaccion) {this.listaTransaccion = listaTransaccion;}

    public ArrayList<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public void crearTransaccion(Double valorRetiro, Cuenta cuentaOperacion, Transaccion tipoTransaccion){

    }


    public Optional<Cliente> buscarClienteByNumeroIdentificacion(String numeriIdentificacion) {


        return listaClientes.stream()
                .filter(cliente -> cliente.getCedula().equals(numeriIdentificacion))
                .findFirst();
    }
    public Cuenta verificarCuenta(Cliente cliente, String numCuenta) throws ErrorValor {
        boolean res = true;

        if(!cliente.getCuenta().getNumeroCuenta().equals(numCuenta)){
            throw new ErrorValor();
        }

        return cliente.getCuenta();
    }

    /**METODOS TRANSACCION**/


    public void depositarDinero(Double registroValor, Date hora, Date fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, String numCuenta, Double valorDepositado){
        listaCuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numCuenta))
                .findFirst().get().agregarSaldo(valorDepositado);
        DepositoDinero depositoDinero = new DepositoDinero(registroValor, hora, fecha, estadoTransaccion, empleado, numCuenta, valorDepositado);

        listaTransaccion.add(depositoDinero);

    }

    public void depositarDineroV2(Double registroValor, Date hora, Date fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, Cuenta cuenta, Double valorDepositado){

        DepositoDinero depositoDinero = new DepositoDinero(registroValor, hora, fecha, estadoTransaccion, empleado, cuenta.getNumeroCuenta(), valorDepositado);

        depositoDinero.agregarSaldo(cuenta);
        listaTransaccion.add(depositoDinero);

    }










}
