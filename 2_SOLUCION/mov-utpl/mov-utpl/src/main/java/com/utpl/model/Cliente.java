package com.utpl.model;

public class Cliente {
    private String cedula;
    private String nombres;
    private String ciudad;
    private String provincia;
    private String canton;
    private String marca;
    private String modelo;
    private String numeroCelular;
    private double pagoMensual;

    // constructor
    public Cliente(String cedula, String nombres, String ciudad, String provincia, String canton, String marca, String modelo, String numeroCelular, double pagoMensual) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.canton = canton;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroCelular = numeroCelular;
        this.pagoMensual = pagoMensual;
    }

    // getters y setters

    public Cliente() {
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String pasaporte) {
        this.cedula = pasaporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton(){
        return canton;
    }

    public void setCanton(String canton){
        this.canton = canton;
    }

}
