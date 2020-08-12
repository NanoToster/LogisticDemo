package ru.toster.services;

import ru.toster.domain.Cargo;
import ru.toster.domain.TimeAndPlace;
import ru.toster.domain.TransportRequest;

import java.util.List;
import java.util.Optional;

/**
 * @author Ivan Rovenskiy
 * 12 August 2020
 */
public interface TransportRequestService {
    TransportRequest saveTransportRequest(String comment,
                                          Cargo cargo,
                                          TimeAndPlace startTimeAndPlace,
                                          TimeAndPlace endTimeAndPlace);

    List<TransportRequest> listAllTransportRequests();

    Optional<TransportRequest> findById(long id);

    void deleteById(long id);
}
