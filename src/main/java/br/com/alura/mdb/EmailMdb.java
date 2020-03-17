package br.com.alura.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;
import br.com.alura.interception.Logger;


@Logger
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "ava:/jms/queue/EmailQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class EmailMdb implements MessageListener {
	
	@Inject
	private AgendamentoEmailBusiness business;

	@Override
	public void onMessage(Message message) {
		try {
			AgendamentoEmail email = message.getBody(AgendamentoEmail.class);
			business.enviarEmail(email);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}
