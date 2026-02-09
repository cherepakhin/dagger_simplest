package ru.perm.v.demo;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.EchoResource;

import static org.junit.jupiter.api.Assertions.*;

public class EchoResourceTest {

    @Test
    public void testEcho() {
        EchoResource echoResource = new EchoResource();
        Response response = echoResource.getMessage("Hello World");
        assertEquals("Hello World", response.getEntity());
    }

}