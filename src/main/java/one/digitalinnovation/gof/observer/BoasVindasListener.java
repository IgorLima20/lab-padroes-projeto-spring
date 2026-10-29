package one.digitalinnovation.gof.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Observador do {@link ClienteCadastradoEvent}. Quem publica o evento não
 * conhece este listener, então novos observadores (e-mail, SMS, auditoria...)
 * podem ser adicionados sem alterar o serviço de cliente.
 */
@Component
public class BoasVindasListener {

	private static final Logger LOG = LoggerFactory.getLogger(BoasVindasListener.class);

	@EventListener
	public void aoCadastrarCliente(ClienteCadastradoEvent event) {
		LOG.info("Bem-vindo(a), {}! Cliente cadastrado com id {} na cidade de {}.",
				event.getCliente().getNome(),
				event.getCliente().getId(),
				event.getCliente().getEndereco().getLocalidade());
	}
}
