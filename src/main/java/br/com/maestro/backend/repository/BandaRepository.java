package br.com.maestro.backend.repository;

import br.com.maestro.backend.entity.Banda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandaRepository extends JpaRepository<Banda, Long> {
}
