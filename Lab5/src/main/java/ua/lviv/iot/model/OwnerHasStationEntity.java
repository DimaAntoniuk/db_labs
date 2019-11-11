package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "owner_has_station", schema = "antoniuk_db")
@IdClass(OwnerHasStationEntityPK.class)
public class OwnerHasStationEntity {
    private int ownerId;
    private int stationId;

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

        OwnerHasStationEntity that = (OwnerHasStationEntity) o;

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
