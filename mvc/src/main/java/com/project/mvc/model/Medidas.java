package com.project.mvc.model;

import jakarta.validation.constraints.Positive;

public class Medidas {
    @Positive(message = "Altura deve ser maior que zero")
    private double altura;
    @Positive(message = "Largura deve ser maior que zero")
    private double largura;

    public Medidas(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public Medidas() {
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
