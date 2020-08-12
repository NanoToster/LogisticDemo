package ru.toster.services;

import ru.toster.domain.TimeAndPlace;
import ru.toster.domain.TransportRequest;
import ru.toster.exceptions.BadParamsException;

/**
 * @author Ivan Rovenskiy
 * 12 August 2020
 */
public interface TransportSystemService {
    TransportRequest createTransportRequestWithNewCargo(String cargoName,
                                                        Double cargoPrice,
                                                        Double cargoWidth,
                                                        Double cargoHeight,
                                                        String requestComment,
                                                        TimeAndPlace requestStartTimeAndPlace,
                                                        TimeAndPlace requestEndTimeAndPlace) throws BadParamsException;
}
