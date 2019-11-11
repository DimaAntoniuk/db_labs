package ua.lviv.iot.model;

import javax.persistence.*;

public class StationHasHouseholdEntityPK {
    private int stationId;
    private int householdId;

    public StationHasHouseholdEntityPK() {

    }

    public StationHasHouseholdEntityPK(int stationId, int householdId) {
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

        StationHasHouseholdEntityPK that = (StationHasHouseholdEntityPK) o;

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
