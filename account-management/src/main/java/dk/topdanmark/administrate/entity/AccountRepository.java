package dk.topdanmark.administrate.entity;

import dk.topdanmark.domain.types.DDDRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.UUID;

@ApplicationScoped
@DDDRepository
public class AccountRepository implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public AccountId nextAccountId() {
        String uuid = UUID.randomUUID().toString();
        System.out.println("uuid = " + uuid);
        return new AccountId(uuid);
    }

    public void store(Account account) {
        entityManager.persist(account.getAccountHolder());
        entityManager.persist(account);
    }

}
