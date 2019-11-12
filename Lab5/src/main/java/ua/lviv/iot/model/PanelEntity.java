package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "panel", schema = "antoniuk_db")
public class PanelEntity {
    private int id;
    private String type;
    private int capacity;
    private int stationId;

    public PanelEntity() {
    }

    public PanelEntity(String type, int capacity, int stationId) {
        this.type = type;
        this.capacity = capacity;
        this.stationId = stationId;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "station_id")
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanelEntity that = (PanelEntity) o;
        return id == that.id &&
                capacity == that.capacity &&
                stationId == that.stationId &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, capacity, stationId);
    }
}
