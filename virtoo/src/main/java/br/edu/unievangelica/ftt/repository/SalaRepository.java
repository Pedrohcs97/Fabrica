package br.edu.unievangelica.ftt.repository;

import br.edu.unievangelica.ftt.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    public Sala findByNome(String nome);

}
