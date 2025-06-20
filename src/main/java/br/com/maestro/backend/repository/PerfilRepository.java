package br.com.maestro.backend.repository;

import br.com.maestro.backend.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
