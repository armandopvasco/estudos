package br.com.alura.screenmatchfrases.screenmatchfrases.controller;

import br.com.alura.screenmatchfrases.screenmatchfrases.dto.FraseDTO;
import br.com.alura.screenmatchfrases.screenmatchfrases.model.Frase;
import br.com.alura.screenmatchfrases.screenmatchfrases.repository.FraseRepository;
import br.com.alura.screenmatchfrases.screenmatchfrases.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.cfg.MapperBuilder;

@RestController
@RequestMapping("/series")
public class FraseController {

    @Autowired
    private FraseService servico;

    @GetMapping("/frases")
    private FraseDTO obtemFrases() {
        return servico.obtemFrase();
    }
}
