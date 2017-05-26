package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Sala;
import br.edu.unievangelica.ftt.repository.SalaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public void salvar(Sala sala) {
        salaRepository.save(sala);
    }

    public void excluir(long id) throws Exception {
        salaRepository.delete(id);
    }

    public Sala visualizar(long id) {
        return salaRepository.findOne(id);
    }

    public List<Sala> Listar() {
        return salaRepository.findAll();
    }

}
