package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Aluno;
import br.edu.unievangelica.ftt.repository.AlunoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public void excluir(long id) throws Exception {
        alunoRepository.delete(id);
    }

    public Aluno visualizar(long id) {
        return alunoRepository.findOne(id);
    }

    public List<Aluno> Listar() {
        return alunoRepository.findAll();
    }
}
