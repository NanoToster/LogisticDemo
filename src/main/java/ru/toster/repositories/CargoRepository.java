package ru.toster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.toster.domain.Cargo;

/**
 * @author Ivan Rovenskiy
 * 11 August 2020
 */
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
