package LogosTech.com.organon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import LogosTech.com.organon.domain.exceptions.CredenciaisInvalidasException;
import LogosTech.com.organon.domain.repositories.UsuarioRepository;
import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.security.jwt.JwtService;

@Service
public class AuthService {

	private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String login(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(senha, usuario.getSenhaHash())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtService.gerarToken(usuario);
    }
}
