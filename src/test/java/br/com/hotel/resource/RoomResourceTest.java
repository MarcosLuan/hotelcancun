package br.com.hotel.resource;

import br.com.hotel.dto.RegisterRoomDTO;
import br.com.hotel.service.RoomService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@Transactional
class RoomResourceTest {

    @Test
    void roomSave() {
        RegisterRoomDTO dto = new RegisterRoomDTO();
        dto.setHotelName("Hotel Cancun");
        dto.setNumber(123);

        given().contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/room/save")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    void listRoom() {
        given()
                .when()
                .get("/room")
                .then()
                .statusCode(200);
    }
}