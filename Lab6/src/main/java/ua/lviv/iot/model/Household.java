package ua.lviv.iot.model;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "household", schema = "antoniuk_db")
public class Household {
    private int id;
    private String name;
    private List<Station> stations = new LinkedList<>();

    public Household() {
    }

    public Household(String name) {
        this.name = name;

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("SELECT stationId FROM StationHasHouseholdEntity AS shh WHERE shh.householdId = :id");
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "households")
    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Household that = (Household) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
