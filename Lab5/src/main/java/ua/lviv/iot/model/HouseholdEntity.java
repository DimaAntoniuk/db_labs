package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "household", schema = "antoniuk_db")
public class HouseholdEntity {
    private int id;
    private String name;

    public HouseholdEntity() {
    }

    public HouseholdEntity(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseholdEntity that = (HouseholdEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }
}
