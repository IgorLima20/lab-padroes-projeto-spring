package one.digitalinnovation.gof.validacao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;

class ValidadorClienteTest {

	private ValidadorCliente validador;

	@BeforeEach
	void montarCorrente() {
		validador = new NomeObrigatorioValidador();
		validador.setProximo(new CepValidador());
	}

	@Test
	void clienteValidoPassaPorTodaACorrente() {
		Cliente cliente = cliente("Maria", "01001-000");
		assertDoesNotThrow(() -> validador.validar(cliente));
		assertEquals("01001000", cliente.getEndereco().getCep());
	}

	@Test
	void nomeVazioEhBarradoNoPrimeiroElo() {
		ValidacaoException e = assertThrows(ValidacaoException.class, () -> validador.validar(cliente(" ", "01001000")));
		assertEquals("O nome do cliente é obrigatório.", e.getMessage());
	}

	@Test
	void cepInvalidoEhBarradoNoSegundoElo() {
		assertThrows(ValidacaoException.class, () -> validador.validar(cliente("Maria", "123")));
	}

	@Test
	void cepAusenteEhBarrado() {
		Cliente cliente = new Cliente();
		cliente.setNome("Maria");
		assertThrows(ValidacaoException.class, () -> validador.validar(cliente));
	}

	private static Cliente cliente(String nome, String cep) {
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
		return cliente;
	}
}
