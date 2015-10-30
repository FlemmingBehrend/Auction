package dk.topdanmark.registration.boundary;

import dk.topdanmark.registration.entity.User;
import dk.topdanmark.registration.entity.UserFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/registration")
@Stateless
public class RegistrationResource {

    @Inject
    UserFactory userFactory;

    @GET
    public Response register() {
        User flemming = userFactory.withName(null).withEmail("flemming@gmail.com").build();

        return Response.ok("register ny").build();
    }

}
