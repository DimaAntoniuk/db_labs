package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "price", schema = "antoniuk_db")
public class Price {
    private int id;
    private int value;
    private Time timeOfPriceBegin;
    private Time timeOfPriceEnd;
    private List<Output> outputs = new LinkedList<>();

    public Price() {
    }

    public Price(int value, Time timeOfPriceBegin, Time timeOfPriceEnd) {
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

    @Basic
    @Column(name = "time_of_price_begin")
    public Time getTimeOfPriceBegin() {
        return timeOfPriceBegin;
    }

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
        if (o == null || getClass() != o.getClass()) return false;
        Price that = (Price) o;
        return id == that.id &&
                value == that.value &&
                timeOfPriceBegin.equals(that.timeOfPriceBegin) &&
                timeOfPriceEnd.equals(that.timeOfPriceEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, timeOfPriceBegin, timeOfPriceEnd);
    }
}
