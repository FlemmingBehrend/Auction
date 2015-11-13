package dk.topdanmark.administrate.control;

import dk.topdanmark.JMSResources;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Map;

@MessageDriven(mappedName = JMSResources.REGISTERED)
public class UserRegistered implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("First topic listener");
        try {
            Map payload = message.getBody(Map.class);
            String name = (String) payload.get("name");
            String email = (String) payload.get("email");

        } catch (JMSException e) {
//            e.printStackTrace();
        }
   }

}
