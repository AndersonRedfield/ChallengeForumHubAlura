package br.com.forumhub.alura.challenge.challenge.alura.forumhub.infra.security;

public record DadosTokenJWT(
        String token,
        String tipo
) {}