package LogosTech.com.organon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.dto.request.UsuarioRequestDTO;
import LogosTech.com.organon.dto.response.UsuarioResponseDTO;
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
	
	public ResponseEntity<UsuarioResponseDTO> cadastro(@Valid @RequestBody UsuarioRequestDTO dto){
		
		Usuario usuario = usuarioService.cadastrar(dto.getEmail(), dto.getSenha(), dto.getNome());
		
		UsuarioResponseDTO response = new UsuarioResponseDTO(usuario.getIdUser(), usuario.getEmail(), usuario.getNome());
		
		return ResponseEntity.ok(response);
	}
}
