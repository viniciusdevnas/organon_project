package LogosTech.com.organon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.dto.request.CadastroRequestDTO;
import LogosTech.com.organon.dto.response.CadastroResponseDTO;
import LogosTech.com.organon.services.AuthService;
import LogosTech.com.organon.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("./usuario")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}
