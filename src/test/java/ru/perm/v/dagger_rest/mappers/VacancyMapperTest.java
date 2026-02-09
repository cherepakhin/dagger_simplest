package ru.perm.v.dagger_rest.mappers;

import org.junit.jupiter.api.Test;
import ru.perm.v.dagger_rest.dto.VacancyDTO;
import ru.perm.v.dagger_rest.entity.VacancyEntity;

import java.util.List;

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

    @Test
    void toDTOs() {
        VacancyMapper mapper = new VacancyMapper();
        VacancyEntity entity1 = new VacancyEntity(1L, "Vacancy 1");
        VacancyEntity entity2 = new VacancyEntity(2L, "Vacancy 2");

        List<VacancyDTO> dtos = mapper.toDTOs(List.of(entity1, entity2));

        assertEquals(2, dtos.size());

        assertEquals(1L, dtos.get(0).getId());
        assertEquals("Vacancy 1", dtos.get(0).getName());

        assertEquals(2L, dtos.get(1).getId());
        assertEquals("Vacancy 2", dtos.get(1).getName());
    }

    @Test
    void toEntities() {
        VacancyMapper mapper = new VacancyMapper();
        VacancyDTO dto1 = new VacancyDTO(1L, "Vacancy 1");
        VacancyDTO dto2 = new VacancyDTO(2L, "Vacancy 2");

        List<VacancyEntity> entityList = mapper.toEntities(List.of(dto1, dto2));

        assertEquals(2, entityList.size());

        assertEquals(1L, entityList.get(0).getId());
        assertEquals("Vacancy 1", entityList.get(0).getName());

        assertEquals(2L, entityList.get(1).getId());
        assertEquals("Vacancy 2", entityList.get(1).getName());
    }
}