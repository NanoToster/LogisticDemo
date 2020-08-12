package ru.toster.domain;

import javax.persistence.*;

/**
 * @author Ivan Rovenskiy
 * 11 August 2020
 */

@Entity
public class TransportRequest {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "comment", nullable = false)
    private String comment;

    @OneToOne(cascade = CascadeType.MERGE) // TODO [RIP]: 12/08/2020 i think @OneToMany will be better...
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "place", column = @Column(name = "startPlace")),
            @AttributeOverride(name = "fromTime", column = @Column(name = "startFromTime")),
            @AttributeOverride(name = "toTime", column = @Column(name = "startToTime"))
    })
    private TimeAndPlace fromTimeAndPlace;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "place", column = @Column(name = "endPlace")),
            @AttributeOverride(name = "fromTime", column = @Column(name = "endFromTime")),
            @AttributeOverride(name = "toTime", column = @Column(name = "endToTime"))
    })
    private TimeAndPlace toTimeAndPlace;

    public TransportRequest() {
    }

    public TransportRequest(String comment, Cargo cargo, TimeAndPlace fromTimeAndPlace, TimeAndPlace toTimeAndPlace) {
        this.comment = comment;
        this.cargo = cargo;
        this.fromTimeAndPlace = fromTimeAndPlace;
        this.toTimeAndPlace = toTimeAndPlace;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public TimeAndPlace getFromTimeAndPlace() {
        return fromTimeAndPlace;
    }

    public TimeAndPlace getToTimeAndPlace() {
        return toTimeAndPlace;
    }
}
