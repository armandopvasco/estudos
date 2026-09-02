package br.com.alura.outros.Outros.model;

public enum Moeda {
    // Definir os valores
    DOLAR (5.10),
    EURO (5.50),
    REAL (1.00);

    private Double fatorConversao;

    Moeda (Double fatorConversao) {
        this.fatorConversao = fatorConversao;
    }

    public Double getFatorConversao() {
        // Implementar aqui
        return fatorConversao;
    }

    public double converterPara(double valorEmReais) {
        // Implementar aqui
        return valorEmReais / getFatorConversao();
    }

}
