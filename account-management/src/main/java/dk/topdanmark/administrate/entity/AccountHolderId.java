package dk.topdanmark.administrate.entity;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AccountHolderId implements Serializable {

    @Column(name = "account_holder_id", unique = true, updatable = false)
    private String id;

    public AccountHolderId() {
    }

    public AccountHolderId(@NotNull String id) {
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

        AccountHolderId accountHolderId = (AccountHolderId) o;

        if (!id.equals(accountHolderId.id))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AccountHolderId{" +
                "id='" + id + '\'' +
                '}';
    }

}
