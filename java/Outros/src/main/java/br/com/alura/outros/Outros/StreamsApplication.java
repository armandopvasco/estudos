package br.com.alura.outros.Outros;

import br.com.alura.outros.Outros.model.CodigoErro;
import br.com.alura.outros.Outros.model.Mes;
import br.com.alura.outros.Outros.model.Moeda;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\nCAPÍTULO 1");
		System.out.println("\n1 - Imagine que você tem uma lista de strings. "+
				"Algumas das strings são números, mas outras não. Queremos converter "+
				"a lista de strings para uma lista de números. Se a conversão falhar, "+
				"você deve ignorar o valor. Por exemplo, na lista a seguir, a saída "+
				"deve ser [10, 20]:");
		List<String> input = Arrays.asList("10", "abc", "20", "30x");
		List<Integer> numeros = input.stream()
				.map(str ->
					{ try {
							return Optional.of(Integer.parseInt(str));
						} catch (NumberFormatException e) {
							return Optional.<Integer>empty();
						}
					})
				.filter(Optional::isPresent)
				.map(Optional::get)
				.toList();
		numeros.stream().forEach(System.out::println);

		System.out.println("\n2 - Implemente um método que recebe um número inteiro "+
				"dentro de um Optional. Se o número estiver presente e for positivo, "+
				"calcule seu quadrado. Caso contrário, retorne Optional.empty.");
		System.out.println(processaNumero(Optional.of(5))); // Saída: Optional[25]
		System.out.println(processaNumero(Optional.of(-3))); // Saída: Optional.empty
		System.out.println(processaNumero(Optional.empty())); // Saída: Optional.empty

		System.out.println("\n3 - Implemente um método que recebe uma String representando "+
				"um nome completo separado por espaços. O método deve retornar "+
				"o primeiro e o último nome após remover os espaços desnecessários.");
		System.out.println(obterPrimeiroEUltimoNome("  João Carlos Silva   ")); // Saída: "João Silva"
		System.out.println(obterPrimeiroEUltimoNome("Maria   ")); // Saída: "Maria"

		System.out.println("\n4 - Implemente um método que verifica se uma frase é um "+
				"palíndromo. Um palíndromo é uma palavra/frase que, quando lida de trás "+
				"pra frente, é igual à leitura normal. Um exemplo:");
		System.out.println(ehPalindromo("socorram me subi no onibus em marrocos")); // Saída: true
		System.out.println(ehPalindromo("Java")); // Saída: false

		System.out.println("\n5 - Implemente um método que recebe uma lista de e-mails (String) e retorna uma nova lista onde cada e-mail está convertido para letras minúsculas.");
		List<String> emails = Arrays.asList("TESTE@EXEMPLO.COM", "exemplo@Java.com ", "Usuario@teste.Com");
		System.out.println(converterEmails(emails));
		// Saída: ["teste@exemplo.com", "exemplo@java.com", "usuario@teste.com"]

		System.out.println("\n6 - Crie um enum Mes que represente os meses do ano. Adicione um método que retorna o número de dias de cada mês, considerando anos não bissextos.");
		System.out.println(Mes.FEVEREIRO.getNumeroDeDias()); // 28
		System.out.println(Mes.JULHO.getNumeroDeDias()); // 31

		System.out.println("\n7 - Crie um enum Moeda com valores como DOLAR, EURO, REAL. Cada moeda deve ter uma taxa de conversão para reais. Adicione um método que recebe um valor em reais e retorna o valor convertido para a moeda.");
		System.out.println(Moeda.DOLAR.converterPara(100)); // 19.60 (aproximado)
		System.out.println(Moeda.EURO.converterPara(100)); // 18.18 (aproximado)

		System.out.println("\n8 - Crie um enum CodigoErro com valores de erros HTTP, como NOT_FOUND, BAD_REQUEST, INTERNAL_SERVER_ERROR. Cada valor deve ter um código numérico e uma descrição associados. Adicione métodos para acessar o código e a descrição. Dica: consulte o site https://http.cat/ para conhecer os vários erros HTTP e conseguir descrevê-los melhor.");
		System.out.println(CodigoErro.NOT_FOUND.getCodigo()); // 404
		System.out.println(CodigoErro.BAD_REQUEST.getDescricao()); // Requisição inválida
	}

	public static Optional<Integer> processaNumero(Optional<Integer> numero) {
		// Implementar aqui
//		if (numero.isPresent() && numero.get() >= 0) {
//			return Optional.of(numero.get() * numero.get());
//		} else {
//			return Optional.empty();
//		}
		return numero.filter(n -> n > 0).map(n -> n * n);
	}

	public static String obterPrimeiroEUltimoNome(String nomeCompleto) {
		// Implementar aqui
		String[] nomes = nomeCompleto.trim().split(" ");
		String primeiroNome = "";
		String ultimoNome = "";
		for (int i = 0; i < nomes.length; i++) {
			if (i == 0) {
				primeiroNome = nomes[i];
			} else if (i == nomes.length - 1) {
				ultimoNome = nomes[i];
			}
		}

		return primeiroNome + " " + ultimoNome;

//		String[] nomes = nomeCompleto.trim().split("\\s+");
//		if (nomes.length == 1) {
//			return nomes[0]; // Apenas um nome
//		}
//		return nomes[0] + " " + nomes[nomes.length - 1]; // Primeiro e último
	}

	public static boolean ehPalindromo(String palavra) {
		// Implementar aqui
//		StringBuilder st = new StringBuilder(palavra.replaceAll(" ", ""));
//		if (st.toString().equals(st.reverse().toString())){
//			return true;
//		} else {
//			return false;
//		}

		String semEspacos = palavra.replace(" ", "").toLowerCase();
		return new StringBuilder(semEspacos).reverse().toString().equalsIgnoreCase(semEspacos);
	}

	public List<String> converterEmails(List<String> emails) {
		// Implementar aqui
		return emails.stream()
				.map(e -> e.toLowerCase())
				.collect(Collectors.toList());
	}
}
