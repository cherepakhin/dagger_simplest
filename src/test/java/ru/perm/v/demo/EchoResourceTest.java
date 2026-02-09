package ru.perm.v.demo;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.echo.EchoResource;

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
}