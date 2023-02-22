package com.example.segumiento1programacion3.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaccion {
    private Double registroValor;
    private LocalTime hora;
    //private Transaccion tipoTransaccion;
    private LocalDate fecha;
    private EstadoTransaccion estadoTransaccion;

    private Empleado empleado;

    private String numCuenta;

    public Transaccion(Double registroValor, LocalTime hora, LocalDate fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, String numCuenta) {
        this.registroValor = registroValor;
        this.hora = hora;
        this.fecha = fecha;
        this.estadoTransaccion = estadoTransaccion;
        this.empleado = empleado;
        this.numCuenta = numCuenta;
    }

    public Transaccion(LocalTime hora, LocalDate fecha, EstadoTransaccion estadoTransaccion, Empleado empleado, String numCuenta) {
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

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public EstadoTransaccion getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(EstadoTransaccion estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "registroValor=" + registroValor +
                ", hora=" + hora +
                ", fecha=" + fecha +
                ", estadoTransaccion=" + estadoTransaccion +
                ", empleado=" + empleado +
                ", numCuenta='" + numCuenta + '\'' +
                '}';
    }
}
