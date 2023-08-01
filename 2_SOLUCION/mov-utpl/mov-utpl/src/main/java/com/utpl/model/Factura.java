package com.utpl.model;

import com.utpl.model.Cliente;

public class Factura {
    private String id;
    private Cliente cliente;
    private double total;

    // constructor
    public Factura(String id, Cliente cliente, double total) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
    }

    // getters y setters
    public String getNombre() {
        return id;
    }

    public void setNombre(String nombre) {
        this.id = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente pasaporte) {
        this.cliente = pasaporte;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double pagoMensual) {
        this.total = pagoMensual;
    }

    // toString
    @Override
    public String toString() {
        return "Factura{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }
    


}