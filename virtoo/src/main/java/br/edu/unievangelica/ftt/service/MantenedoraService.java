package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Mantenedora;
import br.edu.unievangelica.ftt.repository.MantenedoraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MantenedoraService {

    @Autowired
    private MantenedoraRepository mantenedoraRepository;

    public void salvar(Mantenedora mantenedora) {
        mantenedoraRepository.save(mantenedora);
    }

    public void excluir(long id) throws Exception {
        mantenedoraRepository.delete(id);
    }

    public Mantenedora visualizar(long id) {
        return mantenedoraRepository.findOne(id);
    }

    public List<Mantenedora> Listar() {
        return mantenedoraRepository.findAll();
    }
}
