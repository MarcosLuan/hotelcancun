package br.com.hotel.resource;

import br.com.hotel.dto.RegisterRoomDTO;
import br.com.hotel.entity.RoomEntity;
import br.com.hotel.service.RoomService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/room")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoomResource {

    @Inject
    RoomService roomService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/save")
    public RoomEntity roomSave(@RequestBody RegisterRoomDTO roomData) {
        return roomService.roomSave(roomData);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<RoomEntity> listRoom() {
        return roomService.listRoom();
    }
}

