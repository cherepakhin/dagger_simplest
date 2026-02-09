package ru.perm.v.dagger_rest.mappers;

import ru.perm.v.dagger_rest.dto.VacancyDTO;
import ru.perm.v.dagger_rest.entity.VacancyEntity;

public class VacancyMapper {
    public static VacancyDTO toDTO(VacancyEntity vacancyEntity) {
        if (vacancyEntity == null) {
            return null;
        }
        return new VacancyDTO(vacancyEntity.getId(), vacancyEntity.getName());
    }

    public static VacancyEntity toEntity(VacancyDTO vacancyDTO) {
        if (vacancyDTO == null) {
            return null;
        } else {
            return new VacancyEntity(vacancyDTO.getId(), vacancyDTO.getName());
        }
    }
}
