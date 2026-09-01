package br.com.alura.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;

public class Veiculo {
    private String valor;
    private String marca;
    private String modelo;
    private String ano;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;

    public Veiculo(String valor, String marca, String modelo, String ano, String combustivel, String codigoFipe, String mesReferencia) {
        this.valor = valor;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
        this.codigoFipe = codigoFipe;
        this.mesReferencia = mesReferencia;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    @Override
    public String toString() {
        return "Veiculo[" +
                "valor=" + valor +
                ", marca=" + marca +
                ", modelo=" + modelo +
                ", ano=" + ano +
                ", combustivel=" + combustivel +
                ", codigoFipe=" + codigoFipe +
                ", mesReferencia=" + mesReferencia +
                ']';
    }
}
