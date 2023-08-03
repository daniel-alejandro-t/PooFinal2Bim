package com.utpl.model;

public class PlanPostPagoMinutosMegas extends Plan {
    protected int minutos;
    protected double costo_minutos, gigas, costo_por_gigas;

    // constructor
    public PlanPostPagoMinutosMegas(String id, String nombre, double precio, int minutos, double costo_minutos,
            double gigas, double costo_por_gigas) {
        super(id, nombre, precio);
        this.minutos = minutos;
        this.costo_minutos = costo_minutos;
        this.gigas = gigas;
        this.costo_por_gigas = costo_por_gigas;
    }

    // getters y setters
    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public double getCosto_minutos() {
        return costo_minutos;
    }

    public void setCosto_minutos(double costo_minutos) {
        this.costo_minutos = costo_minutos;
    }

    public double getGigas() {
        return gigas;
    }

    public void setGigas(double gigas) {
        this.gigas = gigas;
    }

    public double getCosto_por_gigas() {
        return costo_por_gigas;
    }

    public void setCosto_por_gigas(double costo_por_gigas) {
        this.costo_por_gigas = costo_por_gigas;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "PlanPostPagoMinutosMegas{" + "minutos=" + minutos + ", costo_minutos=" + costo_minutos
                + ", gigas=" + gigas + ", costo_por_gigas=" + costo_por_gigas + '}';
    }

}