package ru.perm.v.dagger_rest.vacancy;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.dto.VacancyDTO;
import ru.perm.v.dagger_rest.resources.HelloWorldResource;
import ru.perm.v.dagger_rest.resources.VacancyResource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacancyResourceTest {

    @Test
    public void testEchoMessage() {
        Long ID = 100L;
        VacancyResource resource = new VacancyResource();
        Response response = resource.getById(ID);
        assertEquals(new VacancyDTO(ID, "test"+ID), response.getEntity());
    }

    /*
    @Test
    public void testEchoStatus() {
        HelloWorldResource resource = new HelloWorldResource();
        Response response = resource.getMessage("Hello World");
        assertEquals(200, response.getStatus());
    }

     */
}