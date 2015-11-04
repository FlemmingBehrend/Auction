package dk.topdanmark.registration.control;

import dk.topdanmark.JMSResources;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = JMSResources.REGISTERED)
public class MyTopicListener2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("My second topic listener");
        String body = null;
        try {
            body = message.getBody(String.class);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        System.out.println(body);
    }
}
