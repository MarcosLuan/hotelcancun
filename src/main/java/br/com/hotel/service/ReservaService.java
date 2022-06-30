package br.com.hotel.service;

import br.com.hotel.entity.Reserva;
import br.com.hotel.repository.ReservaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ReservaService {

    @Inject
    ReservaRepository reservaRepository;

    public Long reservar(Reserva dadosReserva) {
        Reserva reserva = new Reserva();
        reserva.setNomeUsuario(dadosReserva.getNomeUsuario());
        reserva.setCpfUsuario(dadosReserva.getCpfUsuario());
        reserva.setTelefoneUsuario(dadosReserva.getTelefoneUsuario());
        reserva.setDataEntrada(dadosReserva.getDataEntrada());
        reserva.setDataSaida(dadosReserva.getDataSaida());

        reservaRepository.salvar(reserva);
        return reserva.getId();
    }
}
