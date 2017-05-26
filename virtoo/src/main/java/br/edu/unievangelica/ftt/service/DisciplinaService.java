package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Disciplina;
import br.edu.unievangelica.ftt.repository.DisciplinaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void salvar(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    public void excluir(long id) throws Exception {
        disciplinaRepository.delete(id);
    }

    public Disciplina visualizar(long id) {
        return disciplinaRepository.findOne(id);
    }

    public List<Disciplina> Listar() {
        return disciplinaRepository.findAll();
    }
}
