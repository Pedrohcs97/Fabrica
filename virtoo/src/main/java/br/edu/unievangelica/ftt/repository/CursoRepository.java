package br.edu.unievangelica.ftt.repository;

import br.edu.unievangelica.ftt.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
