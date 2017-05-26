package br.edu.unievangelica.ftt.repository;

import br.edu.unievangelica.ftt.entity.Piso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PisoRepository extends JpaRepository<Piso, Long> {

}
