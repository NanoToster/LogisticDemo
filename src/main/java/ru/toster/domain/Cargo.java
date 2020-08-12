package ru.toster.domain;

import javax.persistence.*;

/**
 * @author Ivan Rovenskiy
 * 11 August 2020
 */

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "width", nullable = false)
    private Double width;

    @Column(name = "height", nullable = false)
    private Double height;

    public Cargo() {
    }

    public Cargo(String name, Double price, Double width, Double height) {
        this.name = name;
        this.price = price;
        this.width = width;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }
}
