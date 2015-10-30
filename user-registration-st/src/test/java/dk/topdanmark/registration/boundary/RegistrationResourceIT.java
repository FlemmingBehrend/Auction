package dk.topdanmark.registration.boundary;

import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
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
    public void whenUserIsValid_thenReturn201UserCreated() {
        JsonObject userObject = Json.createObjectBuilder()
                .add("name", "Flemming")
                .add("email", "topfeb@gmail.com")
//                .add("dateOfBirth", Json.createObjectBuilder().add("date", new Date()))
                .build();
        Response response = this.cut.request().post(Entity.json(userObject));

        assertThat(response.getStatus(), is(201));
        String location = response.getHeaderString("location");
        System.out.println("location = " + location);
        assertThat(location, notNullValue());
    }

}
