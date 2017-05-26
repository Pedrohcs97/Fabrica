package br.edu.unievangelica.ftt.repository;

import br.edu.unievangelica.ftt.entity.Mantenedora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenedoraRepository extends JpaRepository<Mantenedora, Long>{
    
}
