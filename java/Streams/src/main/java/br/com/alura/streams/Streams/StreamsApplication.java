package br.com.alura.streams.Streams;

import br.com.alura.streams.Streams.model.Pessoa;
import br.com.alura.streams.Streams.model.Produto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n1 - Da lista de números, filtrar apenas os pares");
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
		numeros.stream()
				.filter(n -> n%2 == 0)
				.forEach(System.out::println);

		System.out.println("\n2 - Converta os nomes da lista para maiúsculo");
		List<String> palavras = Arrays.asList("java", "stream", "lambda");
		palavras.stream()
				.forEach(n -> System.out.println(n.toUpperCase()));

		System.out.println("\n3 - Filtrar ímpares, multipliacr por 2 e coletar os dados numa nova lista");
		List<Integer> numeros3 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> numerosImpares = numeros3.stream()
				.filter(n -> n%2 != 0)
				.map(n -> n*2)
				.collect(Collectors.toList());
		numerosImpares.forEach(System.out::println);

		System.out.println("\n4 - Remova as duplicadas e imprima");
		List<String> palavras4 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
		palavras4.stream()
				.distinct()
				.forEach(System.out::println);

		System.out.println("\n5 - Dada a lista de sublistas, extraia os números primos em uma única lista e ordene em ordem crescente.");
		List<List<Integer>> listaDeNumeros = Arrays.asList(
				Arrays.asList(1, 2, 3, 4),
				Arrays.asList(5, 6, 7, 8),
				Arrays.asList(9, 10, 11, 12)
		);
		List<Integer> numerosPrimos = listaDeNumeros.stream()
				.flatMap(List::stream)  // Achatar as sublistas em uma única stream
				.filter(nn -> ehPrimo(nn))  // Filtrar apenas números primos
				.sorted()               // Ordenar em ordem crescente
				.collect(Collectors.toList()); // Coletar em uma lista

		System.out.println(numerosPrimos); // Saída esperada: [2, 3, 5, 7, 11]

		System.out.println("\n6 - Filtre pessoas com mais de 18 anos, extraia os nomes e imprima-os em ordem alfabética");
		List<Pessoa> pessoas = Arrays.asList(
				new Pessoa("Charlie", 19),
				new Pessoa("Alice", 22),
				new Pessoa("Bob", 17)

		);
		pessoas.stream()
				.filter(p -> p.getIdade() >18)
				.map(p -> p.getNome())
				.sorted()
				.forEach(System.out::println);

		System.out.println("\n7 - 7 - Você tem uma lista de objetos do tipo Produto, onde cada produto possui os atributos nome (String), preco (double) e categoria (String). Filtre todos os produtos da categoria \"Eletrônicos\" com preço menor que R$ 1000, ordene-os pelo preço em ordem crescente e colete o resultado em uma nova lista.");
		List<Produto> produtos = Arrays.asList(
				new Produto("Smartphone", 800.0, "Eletrônicos"),
				new Produto("Notebook", 1500.0, "Eletrônicos"),
				new Produto("Teclado", 200.0, "Eletrônicos"),
				new Produto("Cadeira", 300.0, "Móveis"),
				new Produto("Monitor", 900.0, "Eletrônicos"),
				new Produto("Mesa", 700.0, "Móveis")
		);
		
		List<Produto> novaListaProdutos = produtos.stream()
				.filter(p -> p.getCategoria() == "Eletrônicos" && p.getPreco() < 1000.0)
				.sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
				.collect(Collectors.toList());

		novaListaProdutos.forEach(System.out::println);

		System.out.println("\n8 - 8 - Tomando o mesmo código do exercício anterior como base, modifique o código para que a saída mostre apenas os três produtos mais baratos da categoria Eletrônicos.");

		produtos.stream()
				.filter(p -> p.getCategoria() == "Eletrônicos")
				.sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
				.limit(4)
				.forEach(System.out::println);

	}

	// Função para verificar se um número é primo
	private static boolean ehPrimo(int numero) {
		if (numero < 2) return false; // Números menores que 2 não são primos
		for (int i = 2; i <= Math.sqrt(numero); i++) {
			if (numero % i == 0) {
				return false; // Divisível por outro número que não 1 e ele mesmo
			}
		}
		return true;
	}
}
