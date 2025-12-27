package LogosTech.com.organon.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

	
	private final PasswordEncoder passowordEnconder; //recebo o comportamento
	
	public PasswordService(PasswordEncoder passwordEncoder) {
		this.passowordEnconder = passwordEncoder; //injeção do objeto(comportamentos) das secConfig gerenciado pelo spring
	}
	
	public String criptografar(String senhaPura) {
		return passowordEnconder.encode(senhaPura);
	}
	
	public boolean verificar(String senhaPura, String senhaCriptografada) {
        return passowordEnconder.matches(senhaPura, senhaCriptografada);
    }
}
