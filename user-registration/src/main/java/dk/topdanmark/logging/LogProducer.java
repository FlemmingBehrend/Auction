package dk.topdanmark.logging;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

public class LogProducer {

    @Produces
    public Logger produceLogger(InjectionPoint ip) {
        Class<?> declaringClass = ip.getMember().getDeclaringClass();
        return Logger.getLogger(declaringClass.getName());
    }

}
