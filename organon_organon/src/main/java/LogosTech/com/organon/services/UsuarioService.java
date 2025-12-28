package LogosTech.com.organon.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import LogosTech.com.organon.domain.repositories.UsuarioRepository;
import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.exception.EmailJaCadastradoException;

@Service
public class UsuarioService {
	
    private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;
    
    public UsuarioService(
    		UsuarioRepository usuarioRepository,
    		PasswordService passwordService) {
    	
    	this.usuarioRepository = usuarioRepository;
    	this.passwordService = passwordService;
    }
    
    
   
    	public Usuario cadastrar( String email, String senha, String nome, boolean ativo) {
    	    if (usuarioRepository.existsByEmail(email)) {
    	        throw new EmailJaCadastradoException("Email já cadastrado");
    	    }

    	    String senhaHash = passwordService.criptografar(senha);

    	    Usuario usuario = new Usuario();
    	    usuario.setEmail(email);
    	    usuario.setSenhaHash(senhaHash);
    	    usuario.setNome(nome);          // ← Novo: define o nome
    	    usuario.setAtivo(true);

    	
    	return usuarioRepository.save(usuario); //retorna a entidade salva
    	
    }
    
	
}
