package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Curso;
import br.edu.unievangelica.ftt.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public void salvar(Curso curso) {
        cursoRepository.save(curso);
    }

    public void excluir(long id) throws Exception {
        cursoRepository.delete(id);
    }

    public Curso visualizar(long id) {
        return cursoRepository.findOne(id);
    }

    public List<Curso> Listar() {
        return cursoRepository.findAll();
    }
}
