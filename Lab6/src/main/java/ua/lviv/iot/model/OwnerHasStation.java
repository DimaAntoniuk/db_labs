package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "owner_has_station", schema = "antoniuk_db")
@IdClass(OwnerHasStationPK.class)
public class OwnerHasStation {
    private int ownerId;
    private int stationId;

    public OwnerHasStation() {
    }

    public OwnerHasStation(int ownerId, int stationId) {
        this.ownerId = ownerId;
        this.stationId = stationId;
    }

    @Id
    @Column(name = "owner_id")
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Id
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

        OwnerHasStation that = (OwnerHasStation) o;

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
