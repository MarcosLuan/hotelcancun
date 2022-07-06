package br.com.hotel.resource;

import br.com.hotel.dto.RegisterReserveDTO;
import br.com.hotel.dto.RegisterRoomDTO;
import br.com.hotel.dto.RegisterUserDTO;
import br.com.hotel.service.ReserveService;
import br.com.hotel.service.RoomService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MediaType;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@Transactional
class ReserveResourceTest {

    @Test
    void reserveSave() {
        RegisterReserveDTO dto = new RegisterReserveDTO();
        dto.setUserDocument("12345678901");
        dto.setUserName("User Test");
        dto.setPhoneUser("+5512345789");
        dto.setEntryDate(LocalDate.now());
        dto.setDepartureDate(LocalDate.now().plusDays(2));

        given().contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/bookroom/save")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void bookroomChange() {
        RegisterReserveDTO dto = new RegisterReserveDTO();
        dto.setId(3L);
        dto.setUserDocument("1234567890");
        dto.setUserName("User Test 2");
        dto.setPhoneUser("+55987654321");
        dto.setEntryDate(LocalDate.now().plusDays(23));
        dto.setDepartureDate(LocalDate.now().plusDays(24));

        given().contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .put("/bookroom/change")
                .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    void testReserve() {
        given()
                .when()
                .get("/bookroom")
                .then()
                .statusCode(200);
    }

    @Test
    void reserveByDocument() {
        given().pathParam("document", "1234567890")
                .when()
                .get("/bookroom/byDocument/{document}")
                .then()
                .statusCode(200);
    }

    @Test
    void deleteById() {
        given().pathParam("id", 1L)
                .when()
                .delete("/bookroom/deleteById/{id}")
                .then()
                .statusCode(200);
    }
}