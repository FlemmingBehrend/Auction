package dk.topdanmark.shared.test.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/tester")
public class TestResource {

    @GET
    public Response getAll() {

        return Response.ok("tester tester test").build();
    }



}
