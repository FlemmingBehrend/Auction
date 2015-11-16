package dk.topdanmark;

import dk.topdanmark.administrate.entity.Account;
import dk.topdanmark.administrate.entity.AccountRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Date;

@Startup
@Singleton
public class Starter {

    @Inject
    AccountRepository accountRepository;

    @PostConstruct
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void load() {
        Account account = new Account(accountRepository.nextAccountId(), "testmail@test.dk");
        account.getAccountHolder().setFirstName("Flemming");
        account.getAccountHolder().setLastName("Behrend");
        account.getAccountHolder().setBirthDate(new Date());
        account.getAccountHolder().setSsn("1234567890");
        accountRepository.store(account);
    }

}
