package ru.toster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.toster.domain.Cargo;
import ru.toster.domain.TimeAndPlace;
import ru.toster.domain.TransportRequest;
import ru.toster.exceptions.BadParamsException;

import java.util.List;

/**
 * @author Ivan Rovenskiy
 * 12 August 2020
 */
@Service
public class TransportSystemServiceImpl implements TransportSystemService {
    private final CargoService cargoService;
    private final TransportRequestService transportRequestService;

    @Autowired
    public TransportSystemServiceImpl(final CargoService cargoService, final TransportRequestService transportRequestService) {
        this.cargoService = cargoService;
        this.transportRequestService = transportRequestService;
    }

    @Override
    public TransportRequest createTransportRequestWithNewCargo(final String cargoName,
                                                               final Double cargoPrice,
                                                               final Double cargoWidth,
                                                               final Double cargoHeight,
                                                               final String requestComment,
                                                               final TimeAndPlace requestStartTimeAndPlace,
                                                               final TimeAndPlace requestEndTimeAndPlace) {
        try {
            final Cargo createdCargo = cargoService.saveCargo(cargoName, cargoPrice, cargoWidth, cargoHeight);
            return transportRequestService.saveTransportRequest(
                    requestComment,
                    createdCargo,
                    requestStartTimeAndPlace,
                    requestEndTimeAndPlace);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new BadParamsException(ex.getMessage());
        }
    }
}
