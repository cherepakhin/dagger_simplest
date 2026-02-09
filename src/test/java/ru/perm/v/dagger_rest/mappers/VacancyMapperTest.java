package ru.perm.v.dagger_rest.mappers;

import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.dto.VacancyDTO;
import ru.perm.v.dagger_rest.entity.VacancyEntity;

import static org.junit.jupiter.api.Assertions.*;

class VacancyMapperTest {

    @Test
    void toDTO() {
        VacancyMapper mapper = new VacancyMapper();
        VacancyEntity entity = new VacancyEntity();
        entity.setId(1L);
        entity.setName("Vacancy 1");
        VacancyDTO dto = mapper.toDTO(entity);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
    }

    @Test
    void toEntity() {
        VacancyMapper mapper = new VacancyMapper();

        VacancyDTO dto = new VacancyDTO();
        dto.setId(1L);
        dto.setName("Vacancy 1");

        VacancyEntity entity = mapper.toEntity(dto);

        assertEquals(1L, entity.getId());
        assertEquals("Vacancy 1", entity.getName());
    }
}