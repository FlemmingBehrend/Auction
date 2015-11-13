package dk.topdanmark;

import dk.topdanmark.administrate.entity.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

//@Startup
@Singleton
public class Starter {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void load() {
        Account account = new Account();
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setAccountHolderId(new AccountHolderId(UUID.randomUUID().toString()));
        accountHolder.setFirstName("Flemming");
        accountHolder.setLastName("Behrend");
        account.setAccountHolder(accountHolder);
        account.setAccountId(new AccountId(UUID.randomUUID().toString()));
        account.setStatus(AccountStatus.CREATED);
        em.persist(account);
        em.persist(accountHolder);
    }

}
