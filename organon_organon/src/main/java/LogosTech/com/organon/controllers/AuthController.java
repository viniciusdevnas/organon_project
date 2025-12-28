package LogosTech.com.organon.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.dto.request.LoginRequestDTO;
import LogosTech.com.organon.dto.response.LoginResponseDTO;
import LogosTech.com.organon.services.AuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	public ResponseEntity<LoginResponseDTO> login (@Valid @RequestBody LoginRequestDTO dto) {
		
		Usuario usuario = authService.autenticar(dto.getEmail(), dto.getSenha());
		
		LoginResponseDTO response = new LoginResponseDTO(usuario.getIdUser(), usuario.getEmail());
		
		return ResponseEntity.ok(response);
	}
	
}
