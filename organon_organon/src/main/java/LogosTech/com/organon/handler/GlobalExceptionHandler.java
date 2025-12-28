package LogosTech.com.organon.handler;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class GlobalExceptionHandler {

	@NotBlank(message = "Campo email é obrigatório.")
	@Email(message = "Email inválido.")
	private String email;
	
	@NotBlank(message = "Campo senha é obrigatório.")
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
