package LogosTech.com.organon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class GlobalExceptionHandler {

	//Regra de dominio: Email duplicado
	@ExceptionHandler(EmailJaCadastradoException.class)
	public ResponseEntity<ErrorResponseDTO> handleEmailJaCadastrado(EmailJaCadastradoException ex){
		
		ErrorResponseDTO error = new ErrorResponseDTO(
				ex.getMessage(), //mensagem do erro
				HttpStatus.CONFLICT.value()); //codigo http
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error); //Mensagem de erro + Tipo de erro em JSON
		
	}
	
	// Erros de validação (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationError(
            MethodArgumentNotValidException ex
    ) {
        String mensagem = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        ErrorResponseDTO error = new ErrorResponseDTO(
                mensagem,
                HttpStatus.BAD_REQUEST.value()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
	
 // Erro genérico (fallback)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDTO> handleRuntime(
            RuntimeException ex
    ) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
}
