package ru.perm.v.dagger_rest.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class VacancyEntityTest {
    @Test
    public void defaultConstructor() {
        VacancyEntity vacancyEntity = new VacancyEntity();

        assertEquals(-1L, vacancyEntity.getId());
        assertEquals("", vacancyEntity.getName());
    }

    @Test
    public void parameterizedConstructor() {
        VacancyEntity vacancyEntity = new VacancyEntity(1L, "name");

        assertEquals(1L, vacancyEntity.getId());
        assertEquals("name", vacancyEntity.getName());
    }

    @Test
    public void equals() {
        VacancyEntity vacancyEntity1 = new VacancyEntity(1L, "name");
        VacancyEntity vacancyEntity2 = new VacancyEntity(1L, "name");

        assertEquals(vacancyEntity1, vacancyEntity2);
    }

    @Test
    public void notEqualsByIdTest() {
        VacancyEntity vacancyEntity1 = new VacancyEntity(1L, "name");
        VacancyEntity vacancyEntity2 = new VacancyEntity(2L, "name");

        assertNotEquals(vacancyEntity1, vacancyEntity2);
    }

    @Test
    public void notEqualsByNameTest() {
        VacancyEntity vacancyEntity1 = new VacancyEntity(1L, "name1");
        VacancyEntity vacancyEntity2 = new VacancyEntity(1L, "name2");

        assertNotEquals(vacancyEntity1, vacancyEntity2);
    }

    @Test
    public void setId() {
        VacancyEntity vacancyEntity = new VacancyEntity();
        vacancyEntity.setId(1L);

        assertEquals(1L, vacancyEntity.getId());
    }

    @Test
    public void testHashCode() {
        VacancyEntity vacancyEntity1 = new VacancyEntity(1L, "name");
        VacancyEntity vacancyEntity2 = new VacancyEntity(1L, "name");

        assertEquals(vacancyEntity1.hashCode(), vacancyEntity2.hashCode());
    }

}
