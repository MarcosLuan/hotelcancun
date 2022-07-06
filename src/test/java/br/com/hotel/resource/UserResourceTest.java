package br.com.hotel.resource;

import br.com.hotel.dto.RegisterUserDTO;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

@QuarkusTest
@Transactional
class UserResourceTest {

    @Test
    void userSave() {
        RegisterUserDTO dto = new RegisterUserDTO();
        dto.setDocument("123456789");
        dto.setName("Name Test");
        dto.setPhone("+55123123132");

        given().contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/user/save")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void listUser() {
        given()
                .when()
                .get("/user")
                .then()
                .statusCode(200);
    }
}