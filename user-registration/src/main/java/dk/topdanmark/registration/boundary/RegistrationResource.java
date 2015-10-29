package dk.topdanmark.registration.boundary;

import dk.topdanmark.registration.entity.Email;
import dk.topdanmark.registration.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/registration")
@Stateless
public class RegistrationResource {

    @Inject
    Validator validator;

    @GET
    public Response register() {
        Email email = new Email("fdfs");
        Set<ConstraintViolation<Email>> validate = validator.validate(email);
        System.out.println("validate.toString() = " + validate.toString());
        User user = new User("flemming", email);
        return Response.ok("register ny").build();
    }

}
