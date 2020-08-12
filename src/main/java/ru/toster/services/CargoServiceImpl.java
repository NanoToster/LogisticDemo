package ru.toster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.toster.domain.Cargo;
import ru.toster.repositories.CargoRepository;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

/**
 * @author Ivan Rovenskiy
 * 11 August 2020
 */
@Service
public class CargoServiceImpl implements CargoService {
    private final CargoRepository cargoRepository;

    @Autowired
    public CargoServiceImpl(final CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public Cargo saveCargo(final String name, final Double price, final Double width, final Double height) {
        requireNonNull(name, "name can't be null");
        checkArgument(price >= 0, "price must be positive");
        checkArgument(width >= 0, "width must be positive");
        checkArgument(height >= 0, "height must be positive");

        return cargoRepository.save(new Cargo(name, price, width, height));
    }
}