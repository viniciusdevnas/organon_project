package LogosTech.com.organon.dto.response;

public class UsuarioResponseDTO {

	private Long id;
    private String email;
    private String nome;

    public UsuarioResponseDTO(Long id, String email, String nome) {
        this.id = id;
        this.email = email;
        this.nome = nome;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
