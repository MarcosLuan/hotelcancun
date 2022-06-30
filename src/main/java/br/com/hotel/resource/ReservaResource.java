package br.com.hotel.resource;

import br.com.hotel.dto.ReservaDTO;
import br.com.hotel.entity.Reserva;
import br.com.hotel.service.ReservaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/reserva")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaResource {

    @Inject
    ReservaService reservaService;

    @POST
    @Path("/reservar")
    public Long reservar(Reserva dadosReserva) throws Exception {
        return reservaService.reservar(dadosReserva);
    }
}

