package dk.topdanmark.registration.entity;

import dk.topdanmark.domain.types.DDDAggregateRoot;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@DDDAggregateRoot
public class User implements Serializable {

    @NotNull
    @Size(min = 2)
    private String name;

    private Email email;

    public User(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email=" + email +
                '}';
    }
}
