package ru.toster.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.toster.domain.TimeAndPlace;
import ru.toster.domain.TransportRequest;
import ru.toster.services.TransportRequestService;
import ru.toster.services.TransportSystemService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Ivan Rovenskiy
 * 11 August 2020
 */
@RestController
public class TransportRequestController {
    private static final Gson gson = new Gson();

    private final TransportSystemService transportSystemService;
    private final TransportRequestService transportRequestService;

    @Autowired
    public TransportRequestController(final TransportSystemService transportSystemService,
                                      final TransportRequestService transportRequestService) {
        this.transportSystemService = transportSystemService;
        this.transportRequestService = transportRequestService;
    }

    @PostMapping(path = "/transport_request_with_new_cargo")
    @ResponseBody
    public ResponseEntity<String> createTransportRequestWithNewCargo(
            @RequestParam(name = "cargoName") final String cargoName,
            @RequestParam(name = "cargoPrice") final Double cargoPrice,
            @RequestParam(name = "cargoWidth") final Double cargoWidth,
            @RequestParam(name = "cargoHeight") final Double cargoHeight,
            @RequestParam(name = "requestComment") final String requestComment) {
        final TransportRequest transportRequestWithNewCargo = transportSystemService.createTransportRequestWithNewCargo(
                cargoName,
                cargoPrice,
                cargoWidth,
                cargoHeight,
                requestComment,
                new TimeAndPlace("moskow", LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new TimeAndPlace("minsk", LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)));

        return new ResponseEntity<>(gson.toJson(transportRequestWithNewCargo), HttpStatus.CREATED);
    }

    @GetMapping(path = "/all_transport_requests")
    @ResponseBody
    public ResponseEntity<String> findAllTransportRequestList() {
        final List<TransportRequest> allTransportRequestList = transportRequestService.listAllTransportRequests();

        return new ResponseEntity<>(gson.toJson(allTransportRequestList), HttpStatus.OK);
    }

    @GetMapping(path = "/transport_request_by_id")
    @ResponseBody
    public ResponseEntity<String> findTransportRequestById(
            @RequestParam(name = "id") final long transportRequestId) {
        final Optional<TransportRequest> transportRequestOptional = transportRequestService.findById(transportRequestId);

        if (transportRequestOptional.isPresent()) {
            return new ResponseEntity<>(gson.toJson(transportRequestOptional), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/transport_request_by_id")
    @ResponseBody
    public ResponseEntity<String> deleteTransportRequestById(
            @RequestParam(name = "id") final long transportRequestId) {
        transportRequestService.deleteById(transportRequestId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}