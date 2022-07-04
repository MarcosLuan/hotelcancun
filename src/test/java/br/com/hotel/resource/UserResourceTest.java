package br.com.hotel.resource;

import br.com.hotel.dto.RegisterUserDTO;
import br.com.hotel.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

class UserResourceTest {

    @Inject
    UserService userService;

    @Test
    void userSave() {
        RegisterUserDTO dto = new RegisterUserDTO();
        dto.setDocument("123456789");
        dto.setName("Name Test");
        dto.setPhone("+55123123132");

        Assertions.assertNotNull(userService.userSave(dto));
    }

    @Test
    void listUser() {
        Assertions.assertNotNull(userService.listUsers());
    }
}