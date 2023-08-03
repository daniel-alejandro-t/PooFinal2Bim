package com.utpl.model;

public class PlanPostPagoMinutosMegasEconomico extends Plan {
    private double costoPorMinuto, gigas, costoPorGiga, porcentajeDescuento;
    private int minutos;

    // constructor
    public PlanPostPagoMinutosMegasEconomico(String id, String nombre, double precio, int minutos,
            double costoPorMinuto, double gigas, double costoPorGiga, double porcentajeDescuento) {
        super(id, nombre, precio);
        this.minutos = minutos;
        this.costoPorMinuto = costoPorMinuto;
        this.gigas = gigas;
        this.costoPorGiga = costoPorGiga;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    // getters y setters
    public int getMinutos() {
        return minutos;
    }

    public double getCostoPorMinuto() {
        return costoPorMinuto;
    }

    public double getGigas() {
        return gigas;
    }

    public double getCostoPorGiga() {
        return costoPorGiga;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setCostoPorMinuto(double costoPorMinuto) {
        this.costoPorMinuto = costoPorMinuto;
    }

    public void setGigas(double gigas) {
        this.gigas = gigas;
    }

    public void setCostoPorGiga(double costoPorGiga) {
        this.costoPorGiga = costoPorGiga;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "PlanPostPagoMinutosMegasEconomico{" +
                "costoPorMinuto=" + costoPorMinuto +
                ", gigas=" + gigas +
                ", costoPorGiga=" + costoPorGiga +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }

}