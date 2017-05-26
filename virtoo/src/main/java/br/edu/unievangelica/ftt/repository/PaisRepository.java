package br.edu.unievangelica.ftt.repository;

import br.edu.unievangelica.ftt.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    
}
