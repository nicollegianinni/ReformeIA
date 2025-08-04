package com.project.mvc.DTO;

import com.project.mvc.model.Medidas;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import javax.validation.Valid;
import java.util.List;
//Classe 'AreaRequest' com campos que serão requisitados.
//O cliente escolhera o tipo de superficie, colocara as medidas e depois o valor pelo metro quadrado.
public class AreaRequest{

    @NotBlank(message = "Tipo de superfície é obrigatório")
    private String tipoSuperficie;

    @NotEmpty(message = "Lista de medidas não pode estar vazia")
    @Valid
    private List<Medidas> medidas;

    @Positive(message = "O valor do metro quadrado deve ser maior que zero")
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

