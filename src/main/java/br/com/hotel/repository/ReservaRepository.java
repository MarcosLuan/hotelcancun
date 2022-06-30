package br.com.hotel.repository;

import br.com.hotel.entity.Reserva;
import utils.CrudBase;

import java.util.Optional;

public interface ReservaRepository extends CrudBase<Reserva> {

    public Optional<Reserva> buscarPorIdReserva(Long id);
}
