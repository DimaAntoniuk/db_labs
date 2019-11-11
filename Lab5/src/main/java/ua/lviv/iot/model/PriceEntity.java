package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "price", schema = "antoniuk_db")
public class PriceEntity {
    private int id;
    private int value;
    private Time timeOfPriceBegin;
    private Time timeOfPriceEnd;

    public PriceEntity(int id, int value, Time timeOfPriceBegin, Time timeOfPriceEnd) {
        this.id = id;
        this.value = value;
        this.timeOfPriceBegin = timeOfPriceBegin;
        this.timeOfPriceEnd = timeOfPriceEnd;
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
    @Column(name = "value")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Time getTimeOfPriceBegin() {
        return timeOfPriceBegin;
    }

    @Basic
    @Column(name = "time_of_price_begin")
    public void setTimeOfPriceBegin(Time timeOfPriceBegin) {
        this.timeOfPriceBegin = timeOfPriceBegin;
    }

    @Basic
    @Column(name = "time_of_price_end")
    public Time getTimeOfPriceEnd() {
        return timeOfPriceEnd;
    }

    public void setTimeOfPriceEnd(Time timeOfPriceEnd) {
        this.timeOfPriceEnd = timeOfPriceEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceEntity)) return false;
        PriceEntity that = (PriceEntity) o;
        return getId() == that.getId() &&
                getValue() == that.getValue() &&
                getTimeOfPriceBegin().equals(that.getTimeOfPriceBegin()) &&
                getTimeOfPriceEnd().equals(that.getTimeOfPriceEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getTimeOfPriceBegin(), getTimeOfPriceEnd());
    }
}
