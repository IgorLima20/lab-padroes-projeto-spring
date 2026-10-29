package one.digitalinnovation.gof.validacao;

import one.digitalinnovation.gof.model.Cliente;

/**
 * Elo base do padrão <b>Chain of Responsibility</b>. Cada validador verifica
 * uma única regra e, se tudo estiver certo, repassa o {@link Cliente} para o
 * próximo elo da corrente.
 */
public abstract class ValidadorCliente {

	private ValidadorCliente proximo;

	public ValidadorCliente setProximo(ValidadorCliente proximo) {
		this.proximo = proximo;
		return proximo;
	}

	public void validar(Cliente cliente) {
		verificar(cliente);
		if (proximo != null) {
			proximo.validar(cliente);
		}
	}

	protected abstract void verificar(Cliente cliente);
}
