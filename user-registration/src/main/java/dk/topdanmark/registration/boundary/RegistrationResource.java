package dk.topdanmark.registration.boundary;

import dk.topdanmark.registration.entity.User;
import dk.topdanmark.registration.entity.UserFactory;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/registration")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class RegistrationResource {

    @Inject
    UserFactory userFactory;

    @Inject
    Event<User> userCreatedEvent;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(JsonObject user, @Context UriInfo info) {
        User registeredUser = userFactory
                .withName(user.getString("name"))
                .withEmail(user.getString("email"))
                .build();
        URI uri = info.getAbsolutePathBuilder().path("/" + registeredUser.getEmail().getAddress()).build();
        userCreatedEvent.fire(registeredUser);
        return Response.created(uri).build();
    }

}
