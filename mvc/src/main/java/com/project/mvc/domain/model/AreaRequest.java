package com.project.mvc.domain.model;

import java.util.List;

public class AreaRequest {

    private String tipoSuperficie;
    private List<Medidas> medidas;
    private double valorMetroQuadrado;



    public String getTipoSuperficie() {
        return tipoSuperficie;
    }

    public void setTipoSuperficie(String tipoSuperficie) {
        this.tipoSuperficie = tipoSuperficie;
    }

    public List<Medidas> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medidas> medidas) {
        this.medidas = medidas;
    }

    public double getValorMetroQuadrado() {
        return valorMetroQuadrado;
    }

    public void setValorMetroQuadrado(double valorMetroQuadrado) {
        this.valorMetroQuadrado = valorMetroQuadrado;
    }

}
