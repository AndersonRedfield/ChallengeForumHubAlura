package br.com.forumhub.alura.challenge.challenge.alura.forumhub.service;

import br.com.forumhub.alura.challenge.challenge.alura.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        return usuarioRepository.findByLogin(login);
    }
}
