package br.com.hotel.resource;

import br.com.hotel.dto.RegisterReserveDTO;
import br.com.hotel.entity.ReserveEntity;
import br.com.hotel.service.ReserveService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookroom/")
public class ReserveResource {

    @Inject
    ReserveService reserveService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save/")
    public void reserve(RegisterReserveDTO bookData) {
        reserveService.bookroomSave(bookData);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ReserveEntity> reserve() {
        return reserveService.listBookingData();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/byDocument/{document}")
    public List<ReserveEntity> reserveByDocument(@PathParam("document") String document) {
        return reserveService.listBookingDataByDocument(document);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deleteById/{id}")
    public boolean deleteById(@PathParam("id") Long id) {
        return reserveService.deleteById(id);
    }

}

