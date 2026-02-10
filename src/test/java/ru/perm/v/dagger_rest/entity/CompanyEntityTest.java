package ru.perm.v.dagger_rest.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyEntityTest {

    @Test
    public void getId() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(1L);

        assertEquals(1L, companyEntity.getId());
    }

    @Test
    public void setId() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(1L);

        assertEquals(1L, companyEntity.getId());
    }

    @Test
    public void getName() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName("name");

        assertEquals("name", companyEntity.getName());
    }

    @Test
    public void setName() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName("name");

        assertEquals("name", companyEntity.getName());
    }

    @Test
    public void testEquals() {
        CompanyEntity companyEntity1 = new CompanyEntity();
        companyEntity1.setId(1L);
        companyEntity1.setName("name");

        CompanyEntity companyEntity2 = new CompanyEntity();
        companyEntity2.setId(1L);
        companyEntity2.setName("name");

        assertEquals(companyEntity1, companyEntity2);
    }

    @Test
    public void testNotEquals() {
        CompanyEntity companyEntity1 = new CompanyEntity();
        companyEntity1.setId(1L);
        companyEntity1.setName("name");

        CompanyEntity companyEntity2 = new CompanyEntity();
        companyEntity2.setId(2L);
        companyEntity2.setName("name");

        assertNotEquals(companyEntity1, companyEntity2);
    }

    @Test
    public void testHashCode() {
        CompanyEntity companyEntity1 = new CompanyEntity();
        companyEntity1.setId(1L);
        companyEntity1.setName("name");

        CompanyEntity companyEntity2 = new CompanyEntity();
        companyEntity2.setId(1L);
        companyEntity2.setName("name");

        assertEquals(companyEntity1.hashCode(), companyEntity2.hashCode());
    }
}