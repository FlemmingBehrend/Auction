package dk.topdanmark.registration.entity;

import org.junit.Test;

public class EmailTest {

    @Test
    public void givenValidEmail_thenNoValidationErrors() {
        Email email = new Email("anders@and.dk");
    }

}