package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.model.*;
import br.com.alura.tabelafipe.service.ConsumoAPI;
import br.com.alura.tabelafipe.service.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String SEPARADOR = "/";
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private final String MARCAS = "/marcas";
    private final String MODELOS = "/modelos";
    private final String ANOS = "/anos";

    public void exibeMenu() throws JsonProcessingException {
        System.out.println("Tipo de Veículo - OPÇÕES:");
        System.out.println("carros");
        System.out.println("motos");
        System.out.println("caminhoes");

        System.out.println("Digite o tipo do veículo:");
        var tipoVeiculo = "carros";//leitura.nextLine(); -teste
        var jsonMarcas = consumo.obterDados(ENDERECO + tipoVeiculo + MARCAS);

        List<Dados> dadosMarcas = conversor.obterDados(jsonMarcas, new TypeReference<List<Dados>>() {});

        System.out.println("\nMarcas Disponíveis - OPÇÕES:");
        dadosMarcas.stream()
                .sorted((a,b) -> a.codigo().compareTo(b.codigo()))
                .forEach(d -> System.out.println(d.codigo()+ " - " +d.nome()));

        System.out.println("\nDigite o código da Marca do veículo:");
        var marcaVeiculo = "21";//leitura.nextLine(); -teste
        var jsonModelos = consumo.obterDados(ENDERECO + tipoVeiculo + MARCAS + SEPARADOR + marcaVeiculo + MODELOS);
        DadosModelos dadosModelos = conversor.obterDados(jsonModelos, DadosModelos.class);

        System.out.println("\nModelos Disponíveis - OPÇÕES:");
        dadosModelos.modelos()
                .stream()
                .sorted((a,b) -> a.codigo().compareTo(b.codigo()))
                .forEach(d -> System.out.println(d.codigo()+ " - " +d.nome()));

        System.out.println("\nDigite um trecho do nome do Modelo do veículo:");
        var trechoModelo = "PALIO";//leitura.nextLine(); -teste

        dadosModelos.modelos()
                .stream()
                .filter(d -> d.nome().toUpperCase().contains(trechoModelo.toUpperCase()))
                .sorted((a,b) -> a.codigo().compareTo(b.codigo()))
                .forEach(d -> System.out.println(d.codigo()+ " - " +d.nome()));

        System.out.println("\nDigite o código do Modelo do veículo para consultar valores:");
        var codigoModelo = "541";//leitura.nextLine(); -teste
        var jsonAnos = consumo.obterDados(ENDERECO + tipoVeiculo + MARCAS + SEPARADOR + marcaVeiculo + MODELOS + SEPARADOR + codigoModelo + ANOS);

        System.out.println("\nValores do modelo do veículo selecionado, por ano:");
        List<Dados> dadosAnos = conversor.obterDados(jsonAnos,  new TypeReference<List<Dados>>() {});

        List<Veiculo> veiculosPrecos = new ArrayList<>();

        for (int i = 0; i < dadosAnos.size(); i++) {
            var codigoAno = dadosAnos.get(i).codigo();
            var jsonVeiculos = consumo.obterDados(ENDERECO + tipoVeiculo + MARCAS + SEPARADOR + marcaVeiculo + MODELOS + SEPARADOR + codigoModelo + ANOS + SEPARADOR + codigoAno);
            DadosVeiculos dadosVeiculos = conversor.obterDados(jsonVeiculos, DadosVeiculos.class);
            veiculosPrecos.add(new Veiculo(dadosVeiculos.Valor(), dadosVeiculos.Marca(), dadosVeiculos.Modelo(), dadosVeiculos.AnoModelo(), dadosVeiculos.Combustivel(), dadosVeiculos.CodigoFipe(), dadosVeiculos.MesReferencia()));
        }

        veiculosPrecos.forEach(System.out::println);
    }
}
