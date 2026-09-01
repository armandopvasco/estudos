package br.com.alura.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculos(@JsonAlias("TipoVeiculo") Integer TipoVeiculo,
                            @JsonAlias("Valor") String Valor,
                            @JsonAlias("Marca") String Marca,
                            @JsonAlias("Modelo") String Modelo,
                            @JsonAlias("AnoModelo") String AnoModelo,
                            @JsonAlias("Combustivel") String Combustivel,
                            @JsonAlias("CodigoFipe") String CodigoFipe,
                            @JsonAlias("MesReferencia") String MesReferencia,
                            @JsonAlias("SiglaCombustivel") String SiglaCombustivel) {
}
