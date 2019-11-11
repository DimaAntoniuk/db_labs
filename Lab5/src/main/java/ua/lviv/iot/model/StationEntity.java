package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "station", schema = "antoniuk_db")
public class StationEntity {
    private int id;
    private int numberOfPanels;
    private String address;
    private int timeOfUsage;
    private List<OwnerEntity> owners = new LinkedList<>();

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

    @ManyToMany(mappedBy = "stations")
    public List<OwnerEntity> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerEntity> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationEntity that = (StationEntity) o;
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
