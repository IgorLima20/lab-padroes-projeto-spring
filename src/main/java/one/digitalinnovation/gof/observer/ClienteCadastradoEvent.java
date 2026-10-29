package one.digitalinnovation.gof.observer;

import one.digitalinnovation.gof.model.Cliente;

/**
 * Evento do padrão <b>Observer</b>: publicado sempre que um novo
 * {@link Cliente} é cadastrado.
 */
public class ClienteCadastradoEvent {

	private final Cliente cliente;

	public ClienteCadastradoEvent(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
}
