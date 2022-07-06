package br.com.hotel.service;

import br.com.hotel.dto.RegisterReserveDTO;
import exception.WebApplicationExceptionError;
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
    void bookroomSaveThrows() {
        Assertions.assertThrows(WebApplicationExceptionError.class, () -> {
            RegisterReserveDTO dto = new RegisterReserveDTO();
            dto.setUserName("Marcos Luan");
            dto.setUserDocument("1234567890");
            dto.setPhoneUser("123456");
            dto.setEntryDate(LocalDate.now().minusDays(1));
            dto.setDepartureDate(LocalDate.now().plusDays(1));
            dto.setHotel("Hotel Cancun");
            dto.setRoom(101);

            reserveService.bookroomSave(new RegisterReserveDTO());
        }, "Booking date cannot be less than today!");
    }
}