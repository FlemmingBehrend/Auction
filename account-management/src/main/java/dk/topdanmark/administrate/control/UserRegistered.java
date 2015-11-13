package dk.topdanmark.administrate.control;

import dk.topdanmark.JMSResources;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = JMSResources.REGISTERED)
public class UserRegistered implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("First topic listener");
        try {
            String body = message.getBody(String.class);
            System.out.println("body = " + body);
        } catch (JMSException e) {
            e.printStackTrace();
        }
   }

}
