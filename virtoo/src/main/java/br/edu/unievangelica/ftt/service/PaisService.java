package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Pais;
import br.edu.unievangelica.ftt.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public void salvar(Pais pais) {
        paisRepository.save(pais);
    }

    public void excluir(long id) throws Exception {
        paisRepository.delete(id);
    }

    public Pais visualizar(long id) {
        return paisRepository.findOne(id);
    }

    public List<Pais> Listar() {
        return paisRepository.findAll();
    }
}
