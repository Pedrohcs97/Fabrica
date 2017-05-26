package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Piso;
import br.edu.unievangelica.ftt.repository.PisoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PisoService {

    @Autowired
    private PisoRepository pisoRepository;

    public void salvar(Piso piso) {
        pisoRepository.save(piso);
    }

    public void excluir(long id) throws Exception {
        pisoRepository.delete(id);
    }

    public Piso visualizar(long id) {
        return pisoRepository.findOne(id);
    }

    public List<Piso> Listar() {
        return pisoRepository.findAll();
    }
}
