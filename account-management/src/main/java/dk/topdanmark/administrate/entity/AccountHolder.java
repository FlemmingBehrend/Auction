package dk.topdanmark.administrate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccountHolder {

    @Id
    @GeneratedValue
    private Long id;

    private AccountHolderId accountHolderId;

    private String firstName;

    private String lastName;

    private String ssn;

    public AccountHolderId getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(AccountHolderId accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
