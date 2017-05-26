package br.edu.unievangelica.ftt.repository;

import br.edu.unievangelica.ftt.entity.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

}
