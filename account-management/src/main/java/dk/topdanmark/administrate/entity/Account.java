package dk.topdanmark.administrate.entity;

import dk.topdanmark.domain.types.DDDAggregateRoot;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

@SecondaryTable(name = "PICTURES")
@Entity
@DDDAggregateRoot
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private AccountId accountId;

    @OneToOne
    @Basic(optional = false, fetch = FetchType.EAGER)
    private AccountHolder accountHolder;

    @Lob
    @Column(table = "PICTURES")
    private byte[] picture;

    private AccountStatus status;

    public AccountId getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountId accountId) {
        this.accountId = accountId;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountId != null ? !accountId.equals(account.accountId) : account.accountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer test = new HashCodeBuilder().append("test").build();
        return accountId != null ? accountId.hashCode() : 0;
    }
}
