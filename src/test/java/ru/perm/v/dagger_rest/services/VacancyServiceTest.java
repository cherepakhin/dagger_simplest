package ru.perm.v.dagger_rest.services;

import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.entity.VacancyEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VacancyServiceTest {

    @Test
    void getVacancies() {
        VacancyService vacancyService = new VacancyService();
        List<VacancyEntity> vacancies = vacancyService.getAll();
        assertEquals(2, vacancies.size());
        assertEquals(new VacancyEntity(1L, "Vacancy 1"), vacancies.get(0));
        assertEquals(new VacancyEntity(2L, "Vacancy 2"), vacancies.get(1));
    }

    @Test
    void getVacancyById() {
        Long ID = 2L;
        VacancyService vacancyService = new VacancyService();
        VacancyEntity foundVacancy = vacancyService.getVacancyById(ID);

        assertEquals(ID, foundVacancy.getId());
    }

    @Test
    void getNotFoundVacancyById() {
        VacancyService vacancyService = new VacancyService();

        assertThrows(
                RuntimeException.class,
                () -> vacancyService.getVacancyById(100L)
        );
    }

    @Test
    void checkNotFoundMessageVacancyById() {
        VacancyService vacancyService = new VacancyService();
        Long ID = 100L;
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> vacancyService.getVacancyById(100L)
        );

        assertEquals("Vacancy not found", exception.getMessage());
    }
}