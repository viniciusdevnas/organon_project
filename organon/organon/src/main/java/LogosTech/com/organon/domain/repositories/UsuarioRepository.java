package LogosTech.com.organon.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import LogosTech.com.organon.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

		boolean existsByEmail(String email);

		Usuario findByEmail(String email);

}
