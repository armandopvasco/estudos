package br.com.alura.screenmatchfrases.screenmatchfrases.service;

import br.com.alura.screenmatchfrases.screenmatchfrases.dto.FraseDTO;
import br.com.alura.screenmatchfrases.screenmatchfrases.model.Frase;
import br.com.alura.screenmatchfrases.screenmatchfrases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {
    @Autowired
    private FraseRepository repositorio;

    public FraseDTO obtemFrase() {
        Frase f = repositorio.obtemFrase();
        return new FraseDTO(f.getId(), f.getTitulo(), f.getFrase(), f.getPersonagem(), f.getPoster());
    }
}
