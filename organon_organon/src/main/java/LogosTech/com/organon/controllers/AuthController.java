package LogosTech.com.organon.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.dto.request.LoginRequestDTO;
import LogosTech.com.organon.dto.request.CadastroRequestDTO;
import LogosTech.com.organon.dto.response.CadastroResponseDTO;
import LogosTech.com.organon.dto.response.LoginResponseDTO;
import LogosTech.com.organon.services.AuthService;
import LogosTech.com.organon.services.UsuarioService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;
	private final UsuarioService usuarioService;
	
	public AuthController(AuthService authService, UsuarioService usuarioService) {
		this.authService = authService;
		this.usuarioService = usuarioService;
	}
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {

	    LoginResponseDTO response = authService.login(dto);

	    return ResponseEntity.ok(response);
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<CadastroResponseDTO> cadastro(@Valid @RequestBody CadastroRequestDTO dto){
		
		Usuario usuario = usuarioService.cadastrar(dto.getEmail(), dto.getSenha(), dto.getNome());
		
		CadastroResponseDTO response = new CadastroResponseDTO(usuario.getIdUser(), usuario.getEmail(), 
				usuario.getNome(), usuario.getFuncao());
		
		return ResponseEntity.ok(response);
	}


	
}
