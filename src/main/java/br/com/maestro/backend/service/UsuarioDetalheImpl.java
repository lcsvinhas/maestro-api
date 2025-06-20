package br.com.maestro.backend.service;

import br.com.maestro.backend.entity.Usuario;
import br.com.maestro.backend.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetalheImpl implements UserDetailsService {
    private UsuarioRepository repository;

    public UsuarioDetalheImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email não encontrado."));
        return usuario;
    }
}
