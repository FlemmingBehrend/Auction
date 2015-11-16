package dk.topdanmark.administrate.entity;

import dk.topdanmark.domain.types.DDDEntity;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

@Entity
@DDDEntity
public class AccountHolder implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String ssn;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@Past Date birthDate) {
        this.birthDate = birthDate;
    }

}
