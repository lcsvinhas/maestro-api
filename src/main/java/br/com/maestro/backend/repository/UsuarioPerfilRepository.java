package br.com.maestro.backend.repository;

import br.com.maestro.backend.entity.UsuarioPerfil;
import br.com.maestro.backend.entity.pk.UsuarioPerfilPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, UsuarioPerfilPK> {
}
