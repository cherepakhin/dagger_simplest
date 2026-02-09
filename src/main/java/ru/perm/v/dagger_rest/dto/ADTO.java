package ru.perm.v.dagger_rest.dto;

import java.util.Objects;

public abstract class ADTO {
    private Long id;

    public ADTO() {
        super();
    }

    public ADTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ADTO)) return false;
        ADTO adto = (ADTO) o;
        return Objects.equals(id, adto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ADTO{" +
                "id=" + id +
                '}';
    }
}
