package br.com.hotel.service;

import br.com.hotel.dto.RegisterReserveDTO;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;

@QuarkusTest
@Transactional
class ReserveServiceTest {

    @Inject
    ReserveService reserveService;

    @Test
    void bookroomSave() {

    }

    @Test
    void listBookingData() {
        Assertions.assertNotNull(reserveService.listBookingData());
    }

    @Test
    void listBookingDataByDocument() {
        Assertions.assertNotNull(reserveService.listBookingDataByDocument("1234567890"));
    }
}