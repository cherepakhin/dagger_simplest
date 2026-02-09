package ru.perm.v.dagger_rest.entity;

import java.util.Objects;

public class VacancyEntity {
    private Long id = -1L;
    private String name = "";

    public VacancyEntity() {

    }

    public VacancyEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof VacancyEntity)) return false;
        VacancyEntity that = (VacancyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "VacancyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
