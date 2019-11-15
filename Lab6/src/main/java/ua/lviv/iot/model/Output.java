package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "output", schema = "antoniuk_db")
public class Output {
    private int id;
    private int powerPerHour;
    private Date timeStart;
    private Date timeEnd;
    private int stationId;
    private int priceId;

    public Output() {
    }

    public Output(int powerPerHour, Date timeStart, Date timeEnd, int stationId, int priceId) {
        this.powerPerHour = powerPerHour;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.stationId = stationId;
        this.priceId = priceId;
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
    @Column(name = "power_per_hour")
    public int getPowerPerHour() {
        return powerPerHour;
    }

    public void setPowerPerHour(int powerPerHour) {
        this.powerPerHour = powerPerHour;
    }

    @Basic
    @Column(name = "time_start")
    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    @Basic
    @Column(name = "time_end")
    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Basic
    @Column(name = "station_id")
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Basic
    @Column(name = "price_id")
    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Output that = (Output) o;
        return id == that.id &&
                powerPerHour == that.powerPerHour &&
                stationId == that.stationId &&
                priceId == that.priceId &&
                timeStart.equals(that.timeStart) &&
                timeEnd.equals(that.timeEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, powerPerHour, timeStart, timeEnd, stationId, priceId);
    }
}
