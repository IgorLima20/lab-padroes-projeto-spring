package one.digitalinnovation.gof.validacao;

import one.digitalinnovation.gof.model.Cliente;

public class CepValidador extends ValidadorCliente {

	@Override
	protected void verificar(Cliente cliente) {
		if (cliente.getEndereco() == null || cliente.getEndereco().getCep() == null) {
			throw new ValidacaoException("O CEP do cliente é obrigatório.");
		}
		String cep = cliente.getEndereco().getCep().replace("-", "");
		if (!cep.matches("\\d{8}")) {
			throw new ValidacaoException("CEP inválido: deve conter 8 dígitos.");
		}
		cliente.getEndereco().setCep(cep);
	}
}
