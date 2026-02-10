package ru.perm.v.dagger_rest.mappers;

import ru.perm.v.dagger_rest.dto.VacancyDTO;
import ru.perm.v.dagger_rest.entity.VacancyEntity;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

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

    public static List<VacancyDTO> toDTOs(List<VacancyEntity> entities) {
        return entities.stream().map(VacancyMapper::toDTO).collect(Collectors.toList());
    }

    public static List<VacancyEntity> toEntities(List<VacancyDTO> dtos) {
        return dtos.stream().map(VacancyMapper::toEntity).collect(Collectors.toList());
    }
}
