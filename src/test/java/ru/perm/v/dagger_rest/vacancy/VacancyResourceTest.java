package ru.perm.v.dagger_rest.vacancy;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.dto.VacancyDTO;
import ru.perm.v.dagger_rest.resources.HelloWorldResource;
import ru.perm.v.dagger_rest.resources.VacancyResource;
import ru.perm.v.dagger_rest.services.VacancyService;

import static org.junit.jupiter.api.Assertions.*;

public class VacancyResourceTest {


    @Test
    public void getById() {
        Long ID = 1L;
        VacancyResource resource = new VacancyResource(new VacancyService());
        Response response = resource.getById(ID);
        assertEquals(new VacancyDTO(ID, "Vacancy "+ID), response.getEntity());
    }


    @Test
    public void getByIdErrorMessage() {
        Long ID = 100L;
        VacancyResource resource = new VacancyResource(new VacancyService());
        boolean isException = false;
        String message = "";
        try {
            resource.getById(ID);
        } catch (Exception e) {
            isException = true;
            message = e.getMessage();
        }

        assertTrue(isException);
        assertEquals("Vacancy not found", message);
    }
}