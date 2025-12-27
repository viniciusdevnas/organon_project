package LogosTech.com.organon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.services.AuthService;

@RestController
@RequestMapping("./usuario")
public class UsuarioController {
	
	@Autowired
    private AuthService authService;

    // DTO simples para receber JSON
    public static class LoginRequest {
        public String email;
        public String senha;
    }

	public ResponseEntity<String> getTeste(){
		return ResponseEntity.ok("Sucesso!");
	}
	
	@PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Usuario usuario = authService.autenticar(request.email, request.senha);
            return ResponseEntity.ok("Login bem-sucedido! Bem-vindo, " + usuario.getNome());
            // Futuro: return ResponseEntity.ok(jwtToken);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
