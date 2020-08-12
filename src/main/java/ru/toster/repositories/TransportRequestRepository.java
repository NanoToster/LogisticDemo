package ru.toster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.toster.domain.TransportRequest;

/**
 * @author Ivan Rovenskiy
 * 12 August 2020
 */
public interface TransportRequestRepository extends JpaRepository<TransportRequest, Long> {
}
