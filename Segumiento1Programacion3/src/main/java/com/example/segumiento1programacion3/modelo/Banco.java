package com.example.segumiento1programacion3.modelo;

import com.example.segumiento1programacion3.exceptions.ErrorRetiro;
import com.example.segumiento1programacion3.exceptions.ErrorValor;
import com.example.segumiento1programacion3.modelo.tiposCuenta.CuentaCorriente;
import com.example.segumiento1programacion3.modelo.tiposTransaccion.DepositoDinero;
import com.example.segumiento1programacion3.modelo.tiposTransaccion.RetiroDinero;
import com.example.segumiento1programacion3.modelo.tiposTransaccion.SolicitudSaldo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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


        Cuenta cuenta = new CuentaCorriente("1234", 5.0);
        Empleado empleado = new Empleado("Diego", "a", "148392", "bosques", "diegox@gmail", "43211", "kakaroto");
        listaClientes.add(new Cliente("Erik", "Tri", "1234", "carrera19", "e@gmail.com", cuenta ));
        listaCuentas.add(cuenta);
        listaEmpleado.add(empleado);
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
    public Cuenta buscarCuentaByNumeroIdentificacion(String numCuenta) {


        return listaCuentas.stream()
                .filter(x -> x.getNumeroCuenta().equals(numCuenta))
                .findFirst().get();
    }
    /*public Cuenta verificarCuenta(String numeroIndentificacion, String numCuenta) throws ErrorValor {


        if(!listaClientes.stream()
                .filter(cliente -> cliente.getCedula().equals(numeroIndentificacion))
                .findFirst().get().getCuenta().getNumeroCuenta().equals(numCuenta)){
            throw new ErrorValor();
        }

        return listaClientes.stream()
                .filter(cliente -> cliente.getCedula().equals(numeroIndentificacion))
                .findFirst().get().getCuenta();
    }*/

    public boolean verificarCuenta(String numeroIndentificacion, String numCuenta) throws ErrorValor {
        boolean res = true;
        Optional<Cliente> cliente1 = listaClientes.stream().filter(cliente -> cliente.getCedula().equals(numeroIndentificacion))
                .findFirst();

        if (cliente1.isPresent()){
            if(!cliente1.get().getCuenta().getNumeroCuenta().equals(numCuenta)){
                throw new ErrorValor();
            }


        }else{
            throw new ErrorValor();
        }





        return  res;
    }

    /**METODOS TRANSACCION**/


    public void depositarDinero(Double registroValor, LocalTime hora, LocalDate fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, String numCuenta, Double valorDepositado){
        listaCuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numCuenta))
                .findFirst().get().agregarSaldo(valorDepositado);
        DepositoDinero depositoDinero = new DepositoDinero(registroValor, hora, fecha, estadoTransaccion, empleado, numCuenta, valorDepositado);

        listaTransaccion.add(depositoDinero);

    }

    public void depositarDineroV2(Double registroValor, LocalTime hora, LocalDate fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, Cuenta cuenta, Double valorDepositado){
        DepositoDinero depositoDinero = new DepositoDinero(valorDepositado, hora, fecha, estadoTransaccion, empleado, cuenta.getNumeroCuenta(), valorDepositado);
        if (estadoTransaccion == EstadoTransaccion.ACEPTADO){
            depositoDinero.agregarSaldo(cuenta);
        }




        listaTransaccion.add(depositoDinero);

    }

    public void retirarSaldo(Double registroValor, LocalTime hora, LocalDate fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, Cuenta cuenta, Double dineroRetirado) throws ErrorRetiro {

        RetiroDinero retiroDinero = new RetiroDinero(registroValor, hora, fecha, estadoTransaccion, empleado, cuenta.getNumeroCuenta(), dineroRetirado );
        if(estadoTransaccion == EstadoTransaccion.ACEPTADO){
            retiroDinero.retirarDinero(cuenta,dineroRetirado);
        }



        listaTransaccion.add(retiroDinero);

    }

    public void mostrarSaldo( LocalTime hora, LocalDate fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, Cuenta cuenta){

        SolicitudSaldo solicitudSaldo = new SolicitudSaldo(hora, fecha, estadoTransaccion, empleado, cuenta.getNumeroCuenta() );
        System.out.println(solicitudSaldo.toString());
        System.out.println(fecha);
        listaTransaccion.add(solicitudSaldo);
    }












}
