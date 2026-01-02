package LogosTech.com.organon.dto.response;

import LogosTech.com.organon.domain.usuario.Funcao;

public class LoginResponseDTO {

    private String token;
    private String tipo;
    private String email;
    private Funcao funcao;

    public LoginResponseDTO(String token, String email, Funcao funcao) {
        this.token = token;
        this.tipo = "Bearer";
        this.email = email;
        this.funcao = funcao;
    }

    public String getEmail() {
		return email;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
}
