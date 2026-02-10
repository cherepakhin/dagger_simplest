package ru.perm.v.dagger_rest.resources;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldResourceTest {

    @Test
    public void testEchoMessage() {
        HelloWorldResource resource = new HelloWorldResource();
        Response response = resource.getMessage("Hello World");
        assertEquals("Hello World", response.getEntity());
    }

    @Test
    public void testEchoStatus() {
        HelloWorldResource resource = new HelloWorldResource();
        Response response = resource.getMessage("Hello World");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void forEmptyMessage() {
        HelloWorldResource resource = new HelloWorldResource();
        Response response = resource.getMessage("");
        assertEquals(400, response.getStatus());
        assertEquals("Message must be not null", response.getEntity());
    }

    @Test
    public void forNullMessage() {
        HelloWorldResource resource = new HelloWorldResource();
        Response response = resource.getMessage(null);
        assertEquals(400, response.getStatus());
        assertEquals("Message must be not null", response.getEntity());
    }

}