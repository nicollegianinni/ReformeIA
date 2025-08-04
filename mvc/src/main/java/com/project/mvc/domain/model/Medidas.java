package com.project.mvc.domain.model;

public class Medidas {
    private double altura;
    private double largura;


    public Medidas(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
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
