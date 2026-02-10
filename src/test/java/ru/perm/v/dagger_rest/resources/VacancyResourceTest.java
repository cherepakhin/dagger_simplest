package ru.perm.v.dagger_rest.resources;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.dto.VacancyDTO;
import ru.perm.v.dagger_rest.entity.VacancyEntity;
import ru.perm.v.dagger_rest.services.VacancyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacancyResourceTest {

    @Test
    public void getById() {
        Long ID = 1L;
        VacancyResource resource = new VacancyResource(new VacancyService());

        Response response = resource.getById(ID);

        assertEquals(new VacancyDTO(ID, "Vacancy " + ID), response.getEntity());
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

    @Test
    public void getAll() {
        VacancyResource resource = new VacancyResource(new VacancyService());
        Response response = resource.getAll();

        List<VacancyEntity> vacancyEntities = (List<VacancyEntity>) response.getEntity();

        assertEquals(2, vacancyEntities.size());
        assertEquals(new VacancyDTO(1L, "Vacancy 1"), vacancyEntities.get(0));
        assertEquals(new VacancyDTO(2L, "Vacancy 2"), vacancyEntities.get(1));
    }
}