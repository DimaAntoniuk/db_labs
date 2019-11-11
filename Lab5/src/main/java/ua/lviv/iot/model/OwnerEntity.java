package ua.lviv.iot.model;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.DAO.Owner;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "owner", schema = "antoniuk_db")
public class OwnerEntity {
    private int id;
    private String firstName;
    private String lastName;
    private List<StationEntity> stations = new LinkedList<>();

    public OwnerEntity() {
    }

    public OwnerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("SELECT stationId FROM OwnerHasStationEntity AS ohs WHERE ohs.ownerId = :id");
        query.setParameter("id", this.id);
        stations = query.list();
        session.close();
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
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(mappedBy = "owners")
    public List<StationEntity> getStations() {
        return this.stations;
    }

    public void setStations(List<StationEntity> stations) {
        this.stations = stations;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerEntity that = (OwnerEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
