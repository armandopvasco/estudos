package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);

    List<Serie> findTo5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(Integer totalTemporadas, Double avaliacao);

    @Query("Select s from Serie s where s.totalTemporadas <= :totalTemporadas and s.avaliacao >= :avaliacao")
    List<Serie> seriesPorTemporadaEAvaliacao(Integer totalTemporadas, Double avaliacao);

    @Query("Select e from Serie s JOIN s.episodios e where e.titulo ILIKE %:nomeEpisodio% ")
    List<Episodio> episodiosPorTrecho(String nomeEpisodio);

    @Query("Select e from Serie s JOIN s.episodios e where s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> topEpisodiorPorSerie(Serie serie);

    @Query("Select e from Serie s JOIN s.episodios e where s = :serie AND YEAR(e.dataLancamento) >= :anoLancamento ")
    List<Episodio> episodioPorSerieAno(@Param("serie") Serie serie, @Param("anoLancamento") int anoLancamento);
}
