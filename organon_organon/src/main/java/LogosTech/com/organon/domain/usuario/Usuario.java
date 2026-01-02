package LogosTech.com.organon.domain.usuario;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	@Column(nullable = false, length = 255)
	private String nome;
	
	@Column(nullable = false, unique = true, length = 255)
	private String email;
	
	@Column(name = "senha_hash", nullable  = false)
	private String senhaHash;
	
	@Column(nullable = false)
	private boolean ativo = true;
	
	 @Enumerated(EnumType.STRING)
	 @Column(name = "funcao",nullable = false)
	 private Funcao funcao;
	 
	 @Column(name = "data_criacao", updatable = false, nullable = false)
	 private LocalDateTime dataCriacao;
	 
	 @PrePersist
	    protected void onCreate() {
	        this.dataCriacao = LocalDateTime.now();
	    }

	 public Long getIdUser() {
			return idUser;
		}



		public void setIdUser(Long idUser) {
			this.idUser = idUser;
		}



		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getSenhaHash() {
			return senhaHash;
		}



		public void setSenhaHash(String senhaHash) {
			this.senhaHash = senhaHash;
		}



		public boolean isAtivo() {
			return ativo;
		}



		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		}



		public Funcao getFuncao() {
			return funcao;
		}



		public void setFuncao(Funcao funcao) {
			this.funcao = funcao;
		}



		public LocalDateTime getDataCriacao() {
			return dataCriacao;
		}
	
	
	
}
