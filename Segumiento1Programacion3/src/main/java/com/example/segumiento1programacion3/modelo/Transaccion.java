package com.example.segumiento1programacion3.modelo;

import java.util.Date;

public class Transaccion {
    private Double registroValor;
    private Date hora;
    //private Transaccion tipoTransaccion;
    private Date fecha;
    private EstadoTransaccion estadoTransaccion;

    private Empleado empleado;

    private String numCuenta;

    public Transaccion(Double registroValor, Date hora, Date fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, String numCuenta) {
        this.registroValor = registroValor;
        this.hora = hora;
        this.fecha = fecha;
        this.estadoTransaccion = estadoTransaccion;
        this.empleado = empleado;
        this.numCuenta = numCuenta;
    }

    public Double getRegistroValor() {
        return registroValor;
    }

    public void setRegistroValor(Double registroValor) {
        this.registroValor = registroValor;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoTransaccion getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(EstadoTransaccion estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }
}
