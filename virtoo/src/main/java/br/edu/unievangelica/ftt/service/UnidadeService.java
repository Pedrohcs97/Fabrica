package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Unidade;
import br.edu.unievangelica.ftt.repository.UnidadeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public void salvar(Unidade unidade) {
        unidadeRepository.save(unidade);
    }

    public void excluir(long id) throws Exception {
        unidadeRepository.delete(id);
    }

    public Unidade visualizar(long id) {
        return unidadeRepository.findOne(id);
    }

    public List<Unidade> Listar() {
        return unidadeRepository.findAll();
    }
}
