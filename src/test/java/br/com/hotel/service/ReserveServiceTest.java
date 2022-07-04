package br.com.hotel.service;

import br.com.hotel.dto.RegisterReserveDTO;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@QuarkusTest
@Transactional
class ReserveServiceTest {

    @Inject
    ReserveService reserveService;

    @Test
    void bookroomSave() {
        RegisterReserveDTO dto = new RegisterReserveDTO();
//        dto.setId(1L);
        dto.setUserName("Marcos Luan");
        dto.setUserDocument("1234567890");
        dto.setPhoneUser("");
        dto.setEntryDate(LocalDate.now());
        dto.setDepartureDate(LocalDate.now().plusDays(2));

//        Assertions.assertNotNull(reserveService.bookroomSave(dto));
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