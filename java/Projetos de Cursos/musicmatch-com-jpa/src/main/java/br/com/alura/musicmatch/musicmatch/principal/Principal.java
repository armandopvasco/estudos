package br.com.alura.musicmatch.musicmatch.principal;

import br.com.alura.musicmatch.musicmatch.model.Artista;
import br.com.alura.musicmatch.musicmatch.model.Musica;
import br.com.alura.musicmatch.musicmatch.model.TipoArtista;
import br.com.alura.musicmatch.musicmatch.repository.ArtistaRepository;
import br.com.alura.musicmatch.musicmatch.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepository repositorioArtista;
    private MusicaRepository repositorioMusica;

    public Principal(ArtistaRepository repositorioArtista, MusicaRepository repositorioMusica) {
        this.repositorioArtista = repositorioArtista;
        this.repositorioMusica = repositorioMusica;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    *** Screen Sound Mpusicas ***
                    
                    1 - Cadastrar artistas
                    2 - cadastrar musicas
                    3 - Listar musicas
                    4 - Buscar musicas por artistas
                    5 - Pesquisar dados sobre um artista
                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void cadastrarArtista() {
        var retorno = "S";
        while (retorno.toUpperCase() == "S") {
            System.out.println("Informe o nome do artista: ");
            var nome = leitura.nextLine();
            System.out.println("Informe o tipo desse artista: (solo, dupla, banda): ");
            var tipo = leitura.nextLine();
            Artista artista = new Artista(nome, TipoArtista.fromString(tipo));
            repositorioArtista.save(artista);
            System.out.println("Cadastrar outro artista? (S/N) ");
            retorno = leitura.nextLine();;
        }
    }

    private void cadastrarMusicas() {
        listarTodosArtistas();
        var retorno = "S";
        while (retorno.toUpperCase().equals("S")) {
            System.out.println("Informe o código do Artista: ");
            Long id = leitura.nextLong();
            //Limpa o buffer
            leitura.nextLine();
            Optional<Artista> artista = repositorioArtista.findById(id);

            if (artista.isPresent()) {
                System.out.println("Informe o nome da música: ");
                var nome = leitura.nextLine();
                Musica musica = new Musica(nome);
                musica.setArtista(artista.get());
                repositorioMusica.save(musica);
                System.out.println("Cadastrar outra música? (S/N) ");
                retorno = leitura.nextLine();
            } else {
                System.out.println("Artista não encontrato!");
            }
        }
    }

    private void listarMusicas() {
        System.out.println("** Lista de Músicas **");
        List<Musica> musicas = repositorioMusica.findAll();
        musicas.forEach(a -> System.out.println("Música: " + a.getId() +
                " - " + a.getNome()));
    }

    private void buscarMusicasPorArtista() {
        listarTodosArtistas();
        System.out.println("Informe o código do Artista: ");
        Long id = leitura.nextLong();
        Optional<Artista> artista = repositorioArtista.findById(id);

        if (artista.isPresent()) {
            List<Musica> musicas = repositorioMusica.findByArtista(artista.get());
            System.out.println("** Lista de Músicas do Artista " + artista.get().getNome() + " **");
            musicas.forEach(a -> System.out.println("Música: " + a.getId() +
                    " - " + a.getNome()));
        } else {
            System.out.println("Artista não encontrato!");
        }
    }

    private void pesquisarDadosArtista() {
        
    }

    private void listarTodosArtistas() {
        System.out.println("** Lista de Artistas **");
        List<Artista> artistas = repositorioArtista.findAll();
        artistas.forEach(a -> System.out.println("Artista: " + a.getId() +
                " - " + a.getNome()));
    }
}
