package com.utpl.model;

public class Plan{
    private String id;
    private String nombre;
    private double precio;

    // constructor
    public Plan(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String pasaporte) {
        this.id = pasaporte;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double pagoMensual) {
        this.precio = pagoMensual;
    }

    public void setCalcularCosto(double pagoMensual) {
        this.precio = pagoMensual;
    }

    // toString
    @Override
    public String toString() {
        return "Plan{" +
                "id='" + id + '\'' +
                ", nombre=" + nombre +
                ", precio=" + precio +
                '}';
    }

    
}