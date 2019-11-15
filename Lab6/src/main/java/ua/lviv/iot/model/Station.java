package ua.lviv.iot.model;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "station", schema = "antoniuk_db")
public class Station {
    private int id;
    private int numberOfPanels;
    private String address;
    private int timeOfUsage;
    private List<Owner> owners = new LinkedList<>();
    private List<Household> households = new LinkedList<>();

    public Station() {
    }

    public Station(int numberOfPanels, String address, int timeOfUsage) {
        this.numberOfPanels = numberOfPanels;
        this.address = address;
        this.timeOfUsage = timeOfUsage;

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query1 = session.createQuery("SELECT ownerId FROM OwnerHasStationEntity AS ohs WHERE ohs.stationId = :id");
        query1.setParameter("id", this.id);
        owners = query1.list();

        Query query2 = session.createQuery("SELECT householdId FROM StationHasHouseholdEntity AS shh WHERE shh.stationId = :id");
        query2.setParameter("id", this.id);
        households = query2.list();

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
    @Column(name = "number_of_panels")
    public int getNumberOfPanels() {
        return numberOfPanels;
    }

    public void setNumberOfPanels(int numberOfPanels) {
        this.numberOfPanels = numberOfPanels;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "time_of_usage")
    public int getTimeOfUsage() {
        return timeOfUsage;
    }

    public void setTimeOfUsage(int timeOfUsage) {
        this.timeOfUsage = timeOfUsage;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "owner_has_station",
            joinColumns = { @JoinColumn(name = "station_id") },
            inverseJoinColumns = { @JoinColumn(name = "owner_id") }
    )
    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "station_has_household",
            joinColumns = { @JoinColumn(name = "station_id") },
            inverseJoinColumns = { @JoinColumn(name = "household_id") }
    )
    public List<Household> getHouseholds() {
        return households;
    }

    public void setHouseholds(List<Household> households) {
        this.households = households;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station that = (Station) o;
        return numberOfPanels == that.numberOfPanels &&
                timeOfUsage == that.timeOfUsage &&
                address.equals(that.address) &&
                owners.equals(that.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPanels, address, timeOfUsage, owners);
    }
}
