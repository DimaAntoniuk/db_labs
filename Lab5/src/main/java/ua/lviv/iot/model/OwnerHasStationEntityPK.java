package ua.lviv.iot.model;

import javax.persistence.*;
import java.io.Serializable;

public class OwnerHasStationEntityPK implements Serializable {
    private int ownerId;
    private int stationId;

    public OwnerHasStationEntityPK() {

    }

    public OwnerHasStationEntityPK(int ownerId, int stationId) {
        this.ownerId = ownerId;
        this.stationId = stationId;
    }

    @Column(name = "owner_id")
    @Id
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Column(name = "station_id")
    @Id
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

        OwnerHasStationEntityPK that = (OwnerHasStationEntityPK) o;

        if (stationId != that.stationId) return false;
        if (ownerId != that.ownerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stationId;
        result = 31 * result + ownerId;
        return result;
    }
}
