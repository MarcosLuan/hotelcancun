package br.com.hotel.resource;

import br.com.hotel.dto.RegisterUserDTO;
import br.com.hotel.entity.UserEntity;
import br.com.hotel.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/save")
    public UserEntity reserve(@RequestBody RegisterUserDTO userData) {
        return userService.userSave(userData);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<UserEntity> reserve() {
        return userService.listUsers();
    }
}

