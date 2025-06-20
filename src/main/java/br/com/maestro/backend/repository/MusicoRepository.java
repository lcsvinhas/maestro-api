package br.com.maestro.backend.repository;

import br.com.maestro.backend.entity.Musico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicoRepository extends JpaRepository<Musico, Long> {
}
