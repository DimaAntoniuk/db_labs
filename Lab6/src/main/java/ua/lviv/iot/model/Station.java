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

    public Station() {
    }

    public Station(int numberOfPanels, String address, int timeOfUsage) {
        this.numberOfPanels = numberOfPanels;
        this.address = address;
        this.timeOfUsage = timeOfUsage;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station that = (Station) o;
        return numberOfPanels == that.numberOfPanels &&
                timeOfUsage == that.timeOfUsage &&
                address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPanels, address, timeOfUsage);
    }
}
