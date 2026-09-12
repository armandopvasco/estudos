package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDTO> obterSeries() {
        return servico.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5Series() {
        return servico.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentosSeries() {
        return servico.obterLancamentosSeries();
    }

    @GetMapping("/{id}")
    public SerieDTO obterPorId(@PathVariable Long id) {
        return servico.obterPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    private List<EpisodioDTO> obterTodasTemporadas(@PathVariable Long id){
        return servico.obterTodasTeporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    private List<EpisodioDTO> obterTemporada(@PathVariable Long id, @PathVariable Long numero){
        return servico.obterTeporada(id, numero);
    }

    @GetMapping("/categoria/{nomeGenero}")
    private List<SerieDTO> obterSeriesPorCategoria(@PathVariable String nomeGenero){
        return servico.obterSeriesPorCategoria(nomeGenero);
    }

    @GetMapping("/{id}/temporadas/top")
    private List<EpisodioDTO> obterTop5Temporadas(@PathVariable Long id){
        return servico.obterTop5Temporadas(id);
    }
}
