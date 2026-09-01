package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import tools.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();

		//----------------
		//Exercício 4
//		Tarefa tarefa = new Tarefa("Descrição Tarefa 1", true, "Armando");
//
//		ObjectMapper mapper = new ObjectMapper();

		// Escreve o objeto diretamente em um arquivo JSON
//		Files.read("C:\\tarefa.json");
//		tarefa = mapper.readValue(new File("C:\\tarefa.json"), tarefa.getClass());
//		System.out.println("Arquivo lido: "+tarefa.toString());

	}
}
