package com.example.domumsistemainmobiliario;

public class ItemListaContratos {

    private String fechaInicio;
    private String fechaFin;

    public ItemListaContratos(String fechaInicio, String fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }
}
