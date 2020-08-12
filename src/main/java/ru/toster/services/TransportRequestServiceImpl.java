package ru.toster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.toster.domain.Cargo;
import ru.toster.domain.TimeAndPlace;
import ru.toster.domain.TransportRequest;
import ru.toster.repositories.TransportRequestRepository;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

/**
 * @author Ivan Rovenskiy
 * 12 August 2020
 */
@Service
public class TransportRequestServiceImpl implements TransportRequestService {
    private final TransportRequestRepository transportRequestRepository;

    @Autowired
    public TransportRequestServiceImpl(final TransportRequestRepository transportRequestRepository) {
        this.transportRequestRepository = transportRequestRepository;
    }

    @Override
    public TransportRequest saveTransportRequest(final String comment,
                                                 final Cargo cargo,
                                                 final TimeAndPlace startTimeAndPlace,
                                                 final TimeAndPlace endTimeAndPlace) {
        requireNonNull(comment, "comment can't be null");
        requireNonNull(cargo, "cargo can't be null");
        checkArgument(startTimeAndPlace.getFromTime().isBefore(startTimeAndPlace.getToTime()), "fromTime is after toTome in start time");
        checkArgument(endTimeAndPlace.getFromTime().isBefore(endTimeAndPlace.getToTime()), "fromTime is after toTome in end time");
        checkArgument(startTimeAndPlace.getToTime().isBefore(endTimeAndPlace.getFromTime()), "startToTime is after endFromTime");

        final TransportRequest transportRequest = new TransportRequest(comment, cargo, startTimeAndPlace, endTimeAndPlace);

        return transportRequestRepository.save(transportRequest);
    }

    @Override
    public List<TransportRequest> listAllTransportRequests() {
        return transportRequestRepository.findAll();
    }

    @Override
    public Optional<TransportRequest> findById(final long id) {
        return transportRequestRepository.findById(id);
    }

    @Override
    public void deleteById(final long id) {
        if (transportRequestRepository.existsById(id)) {
            transportRequestRepository.deleteById(id);
        }
    }
}