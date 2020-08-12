package ru.toster.services;

import ru.toster.domain.Cargo;

/**
 * @author Ivan Rovenskiy
 * 11 August 2020
 */
public interface CargoService {
    Cargo saveCargo(String name, Double price, Double width, Double height);
}
