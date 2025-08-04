package com.project.mvc.DTO;

import com.project.mvc.model.Medidas;

import java.util.List;
//Classe 'AreaRequest' com campos que serão requisitados.
//O cliente escolhera o tipo de superficie, colocara as medidas e depois o valor pelo metro quadrado.
public class AreaRequest{

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

