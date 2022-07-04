package br.com.hotel.resource;

import br.com.hotel.dto.RegisterRoomDTO;
import br.com.hotel.service.RoomService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@Transactional
class RoomResourceTest {

    @Inject
    RoomService roomService;

    @Test
    void room() {
        RegisterRoomDTO dto = new RegisterRoomDTO();
        dto.setHotelName("Hotel Cancun");
        dto.setNumber(123);

        Assertions.assertNotNull(roomService.roomSave(dto));
    }

    @Test
    void listRoom() {
        Assertions.assertNotNull(roomService.listRoom());
    }
}