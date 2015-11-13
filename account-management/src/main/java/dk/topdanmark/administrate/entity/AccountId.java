package dk.topdanmark.administrate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class AccountId implements Serializable {

    @Column(name = "account_id", unique = true, updatable = false)
    private String id;

    public AccountId() {
    }

    public AccountId(@NotNull String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AccountId accountId = (AccountId) o;

        return id.equals(accountId.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AccountId{" +
                "id='" + id + '\'' +
                '}';
    }

}
