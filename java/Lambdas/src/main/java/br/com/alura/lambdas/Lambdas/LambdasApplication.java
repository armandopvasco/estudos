package br.com.alura.lambdas.Lambdas;

import br.com.alura.lambdas.Lambdas.lambda.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class LambdasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LambdasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//LAMBDA
		System.out.println("QUESTÃO 1: multiplicação");
		IOperacao op = (a, b) -> a * b;
		System.out.println(op.multiplicacao(3,5));

		System.out.println("QUESTÃO 2: verifica se é número primo");
		INumeroPrimo primo = n -> {
			if (n <= 1) return "Não é primo";
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) return "Não é primo";
			}
			return "É primo";
		};
		System.out.println(primo.EhPrimo(11));
		System.out.println(primo.EhPrimo(12));

		System.out.println("QUESTÃO 3: converte maiúsculo");
		IUpper up = s -> s.toUpperCase(Locale.ROOT);
		System.out.println(up.upper("teste"));

		System.out.println("QUESTÃO 4: Palíndromo");
		IPalindromo p = s -> {
			if (s.toString().equals(s.reverse().toString())) {
				return true;
			} else {
				return false;
			}
		};
		System.out.println(p.palindromo(new StringBuilder("teste")));

		System.out.println("QUESTÃO 5: Lista modificada multiplicada por 3");
		List<Integer> lista = new ArrayList<>();
		lista.add(10);
		lista.add(20);
		lista.replaceAll(i -> i*3);
		lista.forEach(System.out::println);

		System.out.println("QUESTÃO 6: Lista ordenada alfabeticament");
		List<String> listaString = new ArrayList<>();
		listaString.add("Xavier");
		listaString.add("Beatriz");
		listaString.add("Armando");
		listaString.sort((a,b) -> a.compareTo(b));
		listaString.forEach(System.out::println);

		System.out.println("QUESTÃO 7: Divisão com exceção");
		IDivisao div = (a, b) -> {
			try {
                return a / b;
            } catch (ArithmeticException e) {
				System.out.println("Erro: "+e.getMessage());
				return 0;
			}
		};
		System.out.println(div.divisao(10,0));
	}
}
