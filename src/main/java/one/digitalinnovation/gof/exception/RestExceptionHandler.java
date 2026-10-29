package one.digitalinnovation.gof.exception;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import one.digitalinnovation.gof.validacao.ValidacaoException;

/**
 * Centraliza o tratamento de erros da API, devolvendo respostas HTTP
 * adequadas em vez de erros 500 genéricos.
 */
@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ValidacaoException.class)
	public ResponseEntity<Map<String, String>> validacao(ValidacaoException e) {
		return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Map<String, String>> naoEncontrado(NoSuchElementException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", "Cliente não encontrado."));
	}
}
