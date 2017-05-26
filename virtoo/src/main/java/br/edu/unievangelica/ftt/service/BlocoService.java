package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Bloco;
import br.edu.unievangelica.ftt.repository.BlocoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlocoService {

    @Autowired
    private BlocoRepository blocoRepository;

    public void salvar(Bloco bloco) {
        blocoRepository.save(bloco);
    }

    public void excluir(long id) throws Exception {
        blocoRepository.delete(id);
    }

    public Bloco visualizar(long id) {
        return blocoRepository.findOne(id);
    }

    public List<Bloco> Listar() {
        return blocoRepository.findAll();
    }
}
