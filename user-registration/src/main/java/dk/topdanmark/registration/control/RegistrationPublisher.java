package dk.topdanmark.registration.control;

import dk.topdanmark.JMSResources;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.TextMessage;
import javax.jms.Topic;

@Stateless
public class RegistrationPublisher {

    @Resource(lookup = JMSResources.REGISTERED)
    Topic topic;

    @Inject
    JMSContext jmsContext;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void process(String message) {
        TextMessage text = jmsContext.createTextMessage(message);
        jmsContext.createProducer().send(topic, text);
    }

}
