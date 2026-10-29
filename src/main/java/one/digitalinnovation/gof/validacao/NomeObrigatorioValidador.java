package one.digitalinnovation.gof.validacao;

import one.digitalinnovation.gof.model.Cliente;

public class NomeObrigatorioValidador extends ValidadorCliente {

	@Override
	protected void verificar(Cliente cliente) {
		if (cliente.getNome() == null || cliente.getNome().isBlank()) {
			throw new ValidacaoException("O nome do cliente é obrigatório.");
		}
	}
}
