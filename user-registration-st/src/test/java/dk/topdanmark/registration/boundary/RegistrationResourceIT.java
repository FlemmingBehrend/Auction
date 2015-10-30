package dk.topdanmark.registration.boundary;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationResourceIT {


    private Client client;
    private WebTarget cut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.cut = this.client.target("http://localhost:8080/user-registration/resources/registration");
    }

    @Test
    public void tester() {
        Response response = this.cut.request(MediaType.TEXT_PLAIN).get();
        assertThat(response.getStatus(), is(200));
        String payload = response.readEntity(String.class);
        System.out.println("payload = " + payload);
    }

}
