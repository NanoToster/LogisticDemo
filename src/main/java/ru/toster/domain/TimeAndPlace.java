package ru.toster.domain;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * @author Ivan Rovenskiy
 * 12 August 2020
 */
@Embeddable
public class TimeAndPlace {
    private String place;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;
    // TODO [RIP]: 12/08/2020 local timezone everywhere

    public TimeAndPlace() {
    }

    public TimeAndPlace(String place, LocalDateTime fromTime, LocalDateTime toTime) {
        this.place = place;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public String getPlace() {
        return place;
    }

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public LocalDateTime getToTime() {
        return toTime;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setFromTime(LocalDateTime fromTime) {
        this.fromTime = fromTime;
    }

    public void setToTime(LocalDateTime toTime) {
        this.toTime = toTime;
    }
}