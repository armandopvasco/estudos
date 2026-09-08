package br.com.alura.musicmatch.musicmatch.repository;

import br.com.alura.musicmatch.musicmatch.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
