package br.com.forumhub.alura.challenge.challenge.alura.forumhub;

import br.com.forumhub.alura.challenge.challenge.alura.forumhub.domain.curso.Curso;
import br.com.forumhub.alura.challenge.challenge.alura.forumhub.domain.curso.CursoRepository;
import br.com.forumhub.alura.challenge.challenge.alura.forumhub.domain.usuario.Usuario;
import br.com.forumhub.alura.challenge.challenge.alura.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ChallengeAluraForumHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeAluraForumHubApplication.class, args);
	}

	@Bean
	CommandLineRunner iniciarDados(
			CursoRepository cursoRepository,
			UsuarioRepository usuarioRepository,
			PasswordEncoder passwordEncoder
	) {
		return args -> {

			if (cursoRepository.count() == 0) {
				cursoRepository.save(new Curso("Java"));
				cursoRepository.save(new Curso("Spring"));
				cursoRepository.save(new Curso("API REST"));
				System.out.println(">> Cursos iniciais criados!");
			}

			if (usuarioRepository.findByLogin("admin") == null) {
				var senhaCriptografada = passwordEncoder.encode("123456");
				var admin = new Usuario();
				admin.setLogin("admin");
				admin.setSenha(senhaCriptografada);
				usuarioRepository.save(admin);
				System.out.println(">> Usuário admin criado com senha 123456");
			}
		};
	}
}
