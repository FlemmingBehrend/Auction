package dk.topdanmark.registration.boundary;

import dk.topdanmark.registration.control.RegistrationPublisher;
import dk.topdanmark.registration.entity.User;
import dk.topdanmark.registration.entity.UserFactory;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Stateless
public class Registrations {

    @Inject
    UserFactory userFactory;

    @Inject
    Event<User> userCreatedEvent;

    @Inject
    RegistrationPublisher registrationPublisher;

    public User register(String name, String email) {
        User registeredUser = userFactory
                .withName(name)
                .withEmail(email)
                .build();
        userCreatedEvent.fire(registeredUser);
        registrationPublisher.process("Topic message sent");
        return registeredUser;
    }

}
