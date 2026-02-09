package ru.perm.v.dagger_rest.services;

import ru.perm.v.dagger_rest.entity.VacancyEntity;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class VacancyService {
    private List<VacancyEntity> allVacancies;

    public VacancyService() {
        allVacancies = new ArrayList<VacancyEntity>();
        allVacancies.add(new VacancyEntity(1L, "Vacancy 1"));
        allVacancies.add(new VacancyEntity(2L, "Vacancy 2"));
    }

    public List<VacancyEntity> getAll() {
        return allVacancies;
    }

    public VacancyEntity getVacancyById(Long id) {
        Optional<VacancyEntity> foundVacancy = allVacancies.stream().filter(item -> item.getId().equals(id)).findFirst();
        if (foundVacancy.isPresent()) {
            return foundVacancy.get();
        } else {
            throw new RuntimeException("Vacancy not found");
        }
    }
}
