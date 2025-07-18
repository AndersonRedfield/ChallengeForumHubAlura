package br.com.forumhub.alura.challenge.challenge.alura.forumhub.controller;

import br.com.forumhub.alura.challenge.challenge.alura.forumhub.domain.usuario.DadosAutenticacao;
import br.com.forumhub.alura.challenge.challenge.alura.forumhub.domain.usuario.Usuario;
import br.com.forumhub.alura.challenge.challenge.alura.forumhub.infra.security.DadosTokenJWT;
import br.com.forumhub.alura.challenge.challenge.alura.forumhub.infra.security.dto.TokenService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> autenticar(@RequestBody @Valid DadosAutenticacao dados) {
        var tokenAutenticacao = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        Authentication authentication = authenticationManager.authenticate(tokenAutenticacao);
        Usuario usuario = (Usuario) authentication.getPrincipal();
        String jwt = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new DadosTokenJWT(jwt, "Bearer"));
    }
}