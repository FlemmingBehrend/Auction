package dk.topdanmark.administrate.control;

import dk.topdanmark.JMSResources;
import dk.topdanmark.administrate.entity.Account;
import dk.topdanmark.administrate.entity.AccountRepository;

import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Map;

@MessageDriven(mappedName = JMSResources.REGISTERED)
public class UserRegistered implements MessageListener {

    @Inject
    AccountRepository accountRepository;

    @Override
    public void onMessage(Message message) {
        System.out.println("First topic listener");
        try {
            Map payload = message.getBody(Map.class);
            String name = (String) payload.get("name");
            String email = (String) payload.get("email");
            Account account = new Account(accountRepository.nextAccountId(), email);
            if (nameContainsFirstAndLastName(name)) {
                String[] names = name.split(" ");
                account.getAccountHolder().setFirstName(names[0]);
                account.getAccountHolder().setLastName(names[1]);
            } else {
                account.getAccountHolder().setFirstName(name);
            }
            accountRepository.store(account);
        } catch (JMSException e) {
//            e.printStackTrace();
        }
   }

    private boolean nameContainsFirstAndLastName(String name) {
        return name.contains(" ");
    }

}
