package dk.topdanmark.registration.boundary;

import dk.topdanmark.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationResourceIT extends BaseTest {


    private Client client;
    private WebTarget cut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.cut = this.client.target("http://localhost:8080/user-registration/resources/registration");
    }

    public class register {

        @Test
        public void whenUserIsValid_thenReturn201UserCreatedWithUrlForTheCreatedResource() {
            JsonObject userObject = Json.createObjectBuilder()
                    .add("name", "Flemming")
                    .add("email", "fb@email.com")
                    .build();
            Response response = cut.request().post(Entity.json(userObject));
            assertThat(response.getStatus(), is(201));
            String location = response.getHeaderString("location");
            assertThat(location, notNullValue());
        }

        @Test
        public void whenNameIsMissing_thenReturn400BadRequestWithReason() {
            JsonObject userObject = Json.createObjectBuilder()
                    .add("email", "fb@email.com")
                    .build();
            Response response = cut.request().post(Entity.json(userObject));
            assertThat(response.getStatus(), is(400));
            String error = response.getHeaderString("error");
            assertThat(error, notNullValue());
        }

        @Test
        public void whenNameIsDefinedButContainsNull_thenReturn400BadRequestWithReason() {
            JsonObject userObject = Json.createObjectBuilder()
                    .add("name", JsonValue.NULL)
                    .add("email", "fb@email.com")
                    .build();
            Response response = cut.request().post(Entity.json(userObject));
            assertThat(response.getStatus(), is(400));
            String error = response.getHeaderString("error");
            assertThat(error, notNullValue());
        }

        @Test
        public void whenEmailIsMissing_thenReturn400BadRequestWithReason() {
            JsonObject userObject = Json.createObjectBuilder()
                    .add("name", "Flemming")
                    .build();
            Response response = cut.request().post(Entity.json(userObject));
            assertThat(response.getStatus(), is(400));
            String error = response.getHeaderString("error");
            assertThat(error, notNullValue());
        }

        @Test
        public void whenEmailIsDefinedButContainsNull_thenReturn400BadRequestWithReason() {
            JsonObject userObject = Json.createObjectBuilder()
                    .add("name", "Flemming")
                    .add("email", JsonValue.NULL)
                    .build();
            Response response = cut.request().post(Entity.json(userObject));
            assertThat(response.getStatus(), is(400));
            String error = response.getHeaderString("error");
            assertThat(error, notNullValue());
        }

        @Test
        public void whenUsernameIsLessThan2Characters_thenReturn400BadRequestWithValidationMessage() {
            JsonObject userObject = Json.createObjectBuilder()
                    .add("name", "f")
                    .add("email", "fb@email.dk")
                    .build();
            Response response = cut.request().post(Entity.json(userObject));
            assertThat(response.getStatus(), is(400));
        }

    }

}
