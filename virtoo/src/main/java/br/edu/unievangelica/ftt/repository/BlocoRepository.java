package br.edu.unievangelica.ftt.repository;

import br.edu.unievangelica.ftt.entity.Bloco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long> {

}
