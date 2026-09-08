package br.com.alura.musicmatch.musicmatch;

import br.com.alura.musicmatch.musicmatch.principal.Principal;
import br.com.alura.musicmatch.musicmatch.repository.ArtistaRepository;
import br.com.alura.musicmatch.musicmatch.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicmatchApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repositorioArtista;
	@Autowired
	private MusicaRepository repositorioMusica;

	public static void main(String[] args) {
		SpringApplication.run(MusicmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorioArtista, repositorioMusica);
		principal.exibeMenu();
	}
}
