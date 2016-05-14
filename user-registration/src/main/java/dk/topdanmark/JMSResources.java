package dk.topdanmark;


import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

@JMSDestinationDefinitions({
        @JMSDestinationDefinition(
                // TODO: make this injectable with producers
                name = JMSResources.REGISTERED,
                resourceAdapter = "jmsra",
                interfaceName = "javax.jms.Topic",
                destinationName = "Registered",
                description = "Used for publishing registered users"
        )
})
public class JMSResources {
    public static final String REGISTERED = "java:global/jms/Registered";
}
