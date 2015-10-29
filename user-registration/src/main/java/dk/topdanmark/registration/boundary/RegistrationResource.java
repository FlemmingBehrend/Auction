package dk.topdanmark.registration.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/registration")
public class RegistrationResource {

    @GET
    public Response register() {
        return Response.ok("register").build();
    }

}
