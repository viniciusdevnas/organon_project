package LogosTech.com.organon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import LogosTech.com.organon.domain.exceptions.CredenciaisInvalidasException;
import LogosTech.com.organon.domain.repositories.UsuarioRepository;
import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.dto.request.LoginRequestDTO;
import LogosTech.com.organon.dto.response.LoginResponseDTO;
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

    public LoginResponseDTO login(LoginRequestDTO dto) {

        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenhaHash())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.gerarToken(usuario);
        
        return new LoginResponseDTO(token, usuario.getEmail(), usuario.getFuncao());
    }
}
