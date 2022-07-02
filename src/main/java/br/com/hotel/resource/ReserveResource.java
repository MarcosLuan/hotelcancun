package br.com.hotel.resource;

import br.com.hotel.dto.RegisterReserveDTO;
import br.com.hotel.entity.ReserveEntity;
import br.com.hotel.service.ReserveService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookroom")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReserveResource {

    @Inject
    ReserveService reserveService;

    @POST
    public ReserveEntity reserve(RegisterReserveDTO bookdata) {
        return reserveService.bookingData(bookdata);
    }

    @GET
    public List<ReserveEntity> reserve() {
        return reserveService.listBookingData();
    }
}

