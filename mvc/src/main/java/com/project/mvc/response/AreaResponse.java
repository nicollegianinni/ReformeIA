package com.project.mvc.response;
//Essa classe é a saida para o cliente a consumir o total das informações
public class AreaResponse {
    private double areaTotal;
    private double custoTotal;
    private  int totalCaixas;

    public AreaResponse(double areaTotal, double custoTotal, int totalCaixas) {
        this.areaTotal = areaTotal;
        this.custoTotal = custoTotal;
        this.totalCaixas = totalCaixas;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public int getTotalCaixas() {
        return totalCaixas;
    }

    public void setTotalCaixas(int totalCaixas) {
        this.totalCaixas = totalCaixas;
    }
}
