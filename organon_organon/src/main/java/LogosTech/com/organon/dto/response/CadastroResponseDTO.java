package LogosTech.com.organon.dto.response;

import LogosTech.com.organon.domain.usuario.Funcao;

public class CadastroResponseDTO {

	private Long id;
    private String email;
    private String nome;
    private Funcao funcao;

    public CadastroResponseDTO(Long id, String email, String nome, Funcao funcao) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.funcao = funcao;
    }

	public Funcao getFuncao() {
		return funcao;
	}

	public String getNome() {
		return nome;
	}


	public Long getId() {
		return id;
	}

	
	public String getEmail() {
		return email;
	}

}
