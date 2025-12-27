package LogosTech.com.organon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.services.AuthService;

import java.util.Map;

@RestController
public class TestAuthController {

    @Autowired
    private AuthService authService;

    public record LoginRequest(String email, String senha) {}

    @PostMapping("/test-login")
    public ResponseEntity<String> testLogin(@RequestBody LoginRequest request) {
        try {
            Usuario usuario = authService.autenticar(request.email, request.senha);
            return ResponseEntity.ok("SUCESSO! Usuário logado: " + usuario.getNome() 
                + " (email: " + usuario.getEmail() + ", ID: " + usuario.getIdUser() + ")");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("FALHA: " + e.getMessage());
        }
    }
}