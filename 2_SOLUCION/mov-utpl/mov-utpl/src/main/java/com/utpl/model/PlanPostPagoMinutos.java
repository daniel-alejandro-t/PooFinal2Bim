package com.utpl.model;

public class PlanPostPagoMinutos extends Plan {
    private int minutos_nacionales, minutos_internacionales;
    private double costo_minuto_nacional, costo_minuto_internacional;

    // constructor
    public PlanPostPagoMinutos(String id, String nombre, double precio, int minutos_nacionales,
            int minutos_internacionales, double costo_minuto_nacional, double costo_minuto_internacional) {
        super(id, nombre, precio);
        this.minutos_nacionales = minutos_nacionales;
        this.minutos_internacionales = minutos_internacionales;
        this.costo_minuto_nacional = costo_minuto_nacional;
        this.costo_minuto_internacional = costo_minuto_internacional;
    }



    // getters y setters
    public int getMinutos_nacionales() {
        return minutos_nacionales;
    }

    public void setMinutos_nacionales(int minutos_nacionales) {
        this.minutos_nacionales = minutos_nacionales;
    }

    public int getMinutos_internacionales() {
        return minutos_internacionales;
    }

    public void setMinutos_internacionales(int minutos_internacionales) {
        this.minutos_internacionales = minutos_internacionales;
    }

    public double getCosto_minuto_nacional() {
        return costo_minuto_nacional;
    }

    public void setCosto_minuto_nacional(double costo_minuto_nacional) {
        this.costo_minuto_nacional = costo_minuto_nacional;
    }

    public double getCosto_minuto_internacional() {
        return costo_minuto_internacional;
    }

    public void setCosto_minuto_internacional(double costo_minuto_internacional) {
        this.costo_minuto_internacional = costo_minuto_internacional;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "PlanPostPagoMinutos{" + "minutos_nacionales=" + minutos_nacionales + ", minutos_internacionales="
                + minutos_internacionales + ", costo_minuto_nacional=" + costo_minuto_nacional
                + ", costo_minuto_internacional=" + costo_minuto_internacional + '}';
    }

}