package ru.perm.v.dagger_rest.services;

import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.entity.VacancyEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VacancyServiceTest {

    @Test
    void getVacancies() {
        VacancyService vacancyService = new VacancyService();

        assertEquals(2, vacancyService.getVacancies().size());
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