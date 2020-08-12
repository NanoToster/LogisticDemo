package ru.toster.services;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.toster.domain.Cargo;
import ru.toster.domain.TimeAndPlace;
import ru.toster.domain.TransportRequest;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Ivan Rovenskiy
 * 12 August 2020
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransportSystemServiceTest {
    @Autowired
    private TransportSystemService transportSystemService;
    @Autowired
    private TransportRequestService transportRequestService;

    private static TransportRequest testTransportRequest;

    @BeforeClass
    public static void beforeClass() {
        testTransportRequest = new TransportRequest(
                "kek",
                new Cargo("cargo1", 123d, 34d, 456d),
                new TimeAndPlace("moscow", LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new TimeAndPlace("moscow", LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)));
    }

    @Test
    public void checkCreateTransportRequestWithNewCargo() {
        final TransportRequest transportRequestWithNewCargo = transportSystemService.createTransportRequestWithNewCargo(
                testTransportRequest.getCargo().getName(),
                testTransportRequest.getCargo().getPrice(),
                testTransportRequest.getCargo().getWidth(),
                testTransportRequest.getCargo().getHeight(),
                testTransportRequest.getComment(),
                testTransportRequest.getFromTimeAndPlace(),
                testTransportRequest.getToTimeAndPlace()
        );

        final Optional<TransportRequest> resultTransportRequest = transportRequestService.findById(transportRequestWithNewCargo.getId());

        Assertions.assertThat(resultTransportRequest.isPresent()).isTrue();
        Assertions.assertThat(resultTransportRequest.get())
                .usingRecursiveComparison()
                .ignoringFields("id", "cargo.id")
                .isEqualTo(testTransportRequest);
    }
}