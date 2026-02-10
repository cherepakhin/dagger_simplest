package ru.perm.v.dagger_rest.echo;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.resources.EchoResource;

import static org.junit.jupiter.api.Assertions.*;

public class EchoResourceTest {

    @Test
    public void testEchoMessage() {
        EchoResource echoResource = new EchoResource();

        Response response = echoResource.getMessage("Hello World");

        assertEquals("Hello World", response.getEntity());
    }

    @Test
    public void testEchoStatus() {
        EchoResource echoResource = new EchoResource();

        Response response = echoResource.getMessage("Hello World");

        assertEquals(200, response.getStatus());
    }

    @Test
    public void testNullMessage() {
        EchoResource echoResource = new EchoResource();

        Response response = echoResource.getMessage(null);

        assertEquals(400, response.getStatus());
        assertEquals("Message must be not null", response.getEntity());
    }

    @Test
    public void testForShortMessage() {
        EchoResource echoResource = new EchoResource();

        Response response = echoResource.getMessage("aaa");

        assertEquals(400, response.getStatus());
        assertEquals("Length of the Message must be greater than 4", response.getEntity());
    }
}