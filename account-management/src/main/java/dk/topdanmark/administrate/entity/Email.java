package dk.topdanmark.administrate.entity;

import dk.topdanmark.domain.types.DDDValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@DDDValueObject
@Embeddable
public class Email implements Serializable{

    @Transient
    private final String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,63}$";

    @NotNull
    @Pattern(regexp = emailPattern)
    private String address;

    private Email() {}

    public Email(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                '}';
    }

}
