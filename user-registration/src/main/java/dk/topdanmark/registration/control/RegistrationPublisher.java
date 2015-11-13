package dk.topdanmark.registration.control;

import dk.topdanmark.JMSResources;
import dk.topdanmark.registration.entity.User;

import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import java.util.HashMap;
import java.util.Map;

public class RegistrationPublisher {

    @Resource(lookup = JMSResources.REGISTERED)
    Topic topic;

    @Inject
    JMSContext jmsContext;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void process(User user) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", user.getName());
        payload.put("email", user.getEmail().getAddress());
        jmsContext.createProducer().send(topic, payload);
    }

}
