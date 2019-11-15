package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "panel_data", schema = "antoniuk_db")
public class PanelData {
    private int id;
    private Date date;
    private int angle;
    private int power;
    private int chargeLevel;
    private int panelId;

    public PanelData() {
    }

    public PanelData(Date date, int angle, int power, int chargeLevel, int panelId) {
        this.date = date;
        this.angle = angle;
        this.power = power;
        this.chargeLevel = chargeLevel;
        this.panelId = panelId;
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
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "angle")
    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Basic
    @Column(name = "power")
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Basic
    @Column(name = "charge_level")
    public int getChargeLevel() {
        return chargeLevel;
    }

    public void setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
    }

    @Basic
    @Column(name = "panel_id")
    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanelData that = (PanelData) o;
        return id == that.id &&
                angle == that.angle &&
                power == that.power &&
                chargeLevel == that.chargeLevel &&
                panelId == that.panelId &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, angle, power, chargeLevel, panelId);
    }
}
