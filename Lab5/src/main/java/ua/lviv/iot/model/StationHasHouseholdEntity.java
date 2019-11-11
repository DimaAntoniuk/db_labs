package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "station_has_household", schema = "antoniuk_db")
@IdClass(StationHasHouseholdEntityPK.class)
public class StationHasHouseholdEntity {
    private int stationId;
    private int householdId;

    public StationHasHouseholdEntity() {

    }

    public StationHasHouseholdEntity(int stationId, int householdId) {
        this.stationId = stationId;
        this.householdId = householdId;
    }

    @Id
    @Column(name = "station_id")
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Id
    @Column(name = "household_id")
    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StationHasHouseholdEntity that = (StationHasHouseholdEntity) o;

        if (stationId != that.stationId) return false;
        if (householdId != that.householdId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = householdId;
        result = 31 * result + stationId;
        return result;
    }
}
