package LogosTech.com.organon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import LogosTech.com.organon.domain.usuario.Usuario;
import LogosTech.com.organon.exception.EmailJaCadastradoException;
import LogosTech.com.organon.services.AuthService;
import LogosTech.com.organon.services.PasswordService;
import LogosTech.com.organon.services.UsuarioService;


@SpringBootApplication
public class OrganonApplication {

    public static void main(String[] args) {

      
        ConfigurableApplicationContext context = SpringApplication.run(OrganonApplication.class, args);
    }
}