package br.edu.unievangelica.ftt.service;

import br.edu.unievangelica.ftt.entity.Instituicao;
import br.edu.unievangelica.ftt.repository.InstituicaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    public void salvar(Instituicao instituicao) {
        instituicaoRepository.save(instituicao);
    }

    public void excluir(long id) throws Exception {
        instituicaoRepository.delete(id);
    }

    public Instituicao visualizar(long id) {
        return instituicaoRepository.findOne(id);
    }

    public List<Instituicao> Listar() {
        return instituicaoRepository.findAll();
    }
}
