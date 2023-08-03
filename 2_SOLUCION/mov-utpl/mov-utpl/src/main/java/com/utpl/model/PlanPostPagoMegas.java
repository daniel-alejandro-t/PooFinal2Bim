package com.utpl.model;

public class PlanPostPagoMegas extends Plan{
    private double gigas, costoPorGiga, tarifaBase;

    // constructor
    public PlanPostPagoMegas(String id, String nombre, double precio, double gigas, double costoPorGiga, double tarifaBase) {
        super(id,nombre, precio);
        this.gigas = gigas;
        this.costoPorGiga = costoPorGiga;
        this.tarifaBase = tarifaBase;
    }

    // getters y setters

    public double getGigas() {
        return gigas;
    }

    public void setGigas(double gigas) {
        this.gigas = gigas;
    }

    public double getCostoPorGiga() {
        return costoPorGiga;
    }

    public void setCostoPorGiga(double costoPorGiga) {
        this.costoPorGiga = costoPorGiga;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    // toString
    @Override
    public String toString() {
        return "PlanPostPagoMegas{" +
                "gigas=" + gigas +
                ", costoPorGiga=" + costoPorGiga +
                ", tarifaBase=" + tarifaBase +
                '}';
    }
    
}