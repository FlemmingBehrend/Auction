package dk.topdanmark.registration.entity;

import dk.topdanmark.domain.types.DDDFactory;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@DDDFactory
public class UserFactory {

    @Inject
    Validator validator;

    @Inject
    Logger logger;

    Email email;

    String name;

    public UserFactory withEmail(String emailAddress) {
        this.email = new Email(emailAddress);
        validate(this.email);
        return this;
    }

    public UserFactory withName(String name) {
        this.name = name;
        return this;
    }

    public User build() {
        User user = new User(name, email);
        validate(user);
        return user;
    }

    private void validate(Object object) {
        logger.log(Level.INFO, "Validating " + object.getClass().getName());
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (violations.isEmpty())
            return;
        throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
    }

}
