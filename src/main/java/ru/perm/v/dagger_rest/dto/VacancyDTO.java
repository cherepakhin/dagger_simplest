package ru.perm.v.dagger_rest.dto;

import java.util.Objects;

public class VacancyDTO extends ADTO {
    private String name;

    public VacancyDTO(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VacancyDTO)) return false;
        if (!super.equals(o)) return false;
        VacancyDTO that = (VacancyDTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "VacancyDTO{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
