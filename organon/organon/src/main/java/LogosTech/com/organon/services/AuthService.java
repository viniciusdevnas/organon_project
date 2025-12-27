package LogosTech.com.organon.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import LogosTech.com.organon.domain.repositories.UsuarioRepository;
import LogosTech.com.organon.domain.usuario.Usuario;

@Service
public class AuthService {

	private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;
    
    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordService passwordService
        ) {
            this.usuarioRepository = usuarioRepository;
            this.passwordService = passwordService;
        }
    
    public Usuario autenticar(String email, String senha) {
    	
    	Usuario usuario = Optional.ofNullable(usuarioRepository.findByEmail(email))
    	.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    	
    	if(!passwordService.verificar(senha, usuario.getSenhaHash())) {
    		throw new RuntimeException("Senha inválida");
    	}
    	
    	return usuario;
    }
}
