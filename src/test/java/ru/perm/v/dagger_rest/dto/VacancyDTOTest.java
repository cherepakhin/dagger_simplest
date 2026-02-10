package ru.perm.v.dagger_rest.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VacancyDTOTest {

    @Test
    void testConstructorAndGetters() {
        Long id = 1L;
        String name = "Java Developer";

        VacancyDTO vacancy = new VacancyDTO(id, name);

        assertEquals(id, vacancy.getId());
        assertEquals(name, vacancy.getName());
    }

    @Test
    void testSetters() {
        VacancyDTO vacancy = new VacancyDTO(null, null);

        Long id = 2L;
        String name = "Senior Developer";

        vacancy.setId(id);
        vacancy.setName(name);

        assertEquals(id, vacancy.getId());
        assertEquals(name, vacancy.getName());
    }

    @Test
    void testEquals_SameObject() {
        VacancyDTO vacancy = new VacancyDTO(1L, "Dev");
        assertEquals(vacancy, vacancy);
    }

    @Test
    void testEquals_Null() {
        VacancyDTO vacancy = new VacancyDTO(1L, "Dev");
        assertFalse(vacancy.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        VacancyDTO vacancy = new VacancyDTO(1L, "Dev");
        Object obj = new Object();
        assertFalse(vacancy.equals(obj));
    }

    @Test
    void testEquals_SuperNotEqual() {
        VacancyDTO vacancy1 = new VacancyDTO(1L, "Dev");
        VacancyDTO vacancy2 = new VacancyDTO(2L, "Dev"); // different ID
        assertFalse(vacancy1.equals(vacancy2));
    }

    @Test
    void testEquals_NameNotEqual() {
        VacancyDTO vacancy1 = new VacancyDTO(1L, "Dev1");
        VacancyDTO vacancy2 = new VacancyDTO(1L, "Dev2");
        assertFalse(vacancy1.equals(vacancy2));
    }

    @Test
    void testEquals_Equal() {
        VacancyDTO vacancy1 = new VacancyDTO(1L, "Dev");
        VacancyDTO vacancy2 = new VacancyDTO(1L, "Dev");
        assertTrue(vacancy1.equals(vacancy2));
    }

    @Test
    void testHashCode_EqualObjects() {
        VacancyDTO vacancy1 = new VacancyDTO(1L, "Dev");
        VacancyDTO vacancy2 = new VacancyDTO(1L, "Dev");
        assertEquals(vacancy1.hashCode(), vacancy2.hashCode());
    }

    @Test
    void testHashCode_DifferentId() {
        VacancyDTO vacancy1 = new VacancyDTO(1L, "Dev");
        VacancyDTO vacancy2 = new VacancyDTO(2L, "Dev");
        assertNotEquals(vacancy1.hashCode(), vacancy2.hashCode());
    }

    @Test
    void testHashCode_DifferentName() {
        VacancyDTO vacancy1 = new VacancyDTO(1L, "Dev1");
        VacancyDTO vacancy2 = new VacancyDTO(1L, "Dev2");
        assertNotEquals(vacancy1.hashCode(), vacancy2.hashCode());
    }

    @Test
    void testToString_IncludesFields() {
        VacancyDTO vacancy = new VacancyDTO(1L, "Java Dev");
        String toString = vacancy.toString();
        assertTrue(toString.contains("id=1"));
        assertTrue(toString.contains("name='Java Dev'"));
    }
}