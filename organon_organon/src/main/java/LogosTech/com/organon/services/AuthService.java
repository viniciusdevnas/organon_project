package LogosTech.com.organon.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import LogosTech.com.organon.domain.exceptions.CredenciaisInvalidasException;
import LogosTech.com.organon.domain.repositories.UsuarioRepository;
import LogosTech.com.organon.domain.usuario.Usuario;

@Service
public class AuthService {

	private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;

    public AuthService(UsuarioRepository usuarioRepository,
                       PasswordService passwordService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordService = passwordService;
    }

    public Usuario autenticar(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(CredenciaisInvalidasException::new);

        if (!passwordService.verificar(senha, usuario.getSenhaHash())) {
            throw new CredenciaisInvalidasException();
        }

        return usuario;
    }
}
