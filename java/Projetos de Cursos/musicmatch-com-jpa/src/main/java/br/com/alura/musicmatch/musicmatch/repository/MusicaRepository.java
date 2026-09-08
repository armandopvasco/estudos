package br.com.alura.musicmatch.musicmatch.repository;

import br.com.alura.musicmatch.musicmatch.model.Artista;
import br.com.alura.musicmatch.musicmatch.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    List<Musica> findByArtista(Artista artista);
}
