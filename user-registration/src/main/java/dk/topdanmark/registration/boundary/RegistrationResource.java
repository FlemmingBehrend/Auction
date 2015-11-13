package dk.topdanmark.registration.boundary;

import dk.topdanmark.registration.control.RegistrationPublisher;
import dk.topdanmark.registration.entity.User;
import dk.topdanmark.registration.entity.UserFactory;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    @Inject
    RegistrationPublisher registrationPublisher;

    static final String NAME_KEY = "name";
    static final String EMAIL_KEY = "email";

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(JsonObject user, @Context UriInfo info) {

        if (!user.containsKey(NAME_KEY) || user.isNull(NAME_KEY)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .header("error", NAME_KEY + " is required")
                    .build();
        }

        if (!user.containsKey(EMAIL_KEY) || user.isNull(EMAIL_KEY)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .header("error", EMAIL_KEY + " is required")
                    .build();
        }

        User registeredUser = userFactory
                .withName(user.getString(NAME_KEY))
                .withEmail(user.getString(EMAIL_KEY))
                .build();

        userCreatedEvent.fire(registeredUser);
        registrationPublisher.process(registeredUser);
        URI uri = info.getAbsolutePathBuilder().path("/" + registeredUser.getEmail().getAddress()).build();
        return Response.created(uri).build();
    }

}
