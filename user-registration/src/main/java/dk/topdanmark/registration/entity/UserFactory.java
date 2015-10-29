package dk.topdanmark.registration.entity;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Date;
import java.util.Set;

public class UserFactory {

    @Inject
    Validator validator;

    public  User create(String name, String emailAddress) {
        Email email = new Email(emailAddress);
        validateEmail(email);

        return null;
    }

    private  void validateEmail(Email email) throws ConstraintViolationException {
        Set<ConstraintViolation<Email>> validate = validator.validate(email);
        if (validate.isEmpty())
            return;
    }

    public  User create(String name, String email, Date dateOfBirth) {

        return null;
    }

}
