package br.com.hotel.service;

import br.com.hotel.dto.RegisterReserveDTO;
import br.com.hotel.entity.ReserveEntity;
import br.com.hotel.repository.ReserveRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ReserveService {

    @Inject
    ReserveRepository reserveRepository;

    public ReserveEntity bookingData(RegisterReserveDTO bookdata) {

        ReserveEntity reserveEntity = new ReserveEntity();
        reserveEntity.setUserName(bookdata.getUserName());
        reserveEntity.setUserDocument(bookdata.getUserDocument());
        reserveEntity.setPhoneUser(bookdata.getPhoneUser());
        reserveEntity.setEntryDate(bookdata.getEntryDate());
        reserveEntity.setDepartureDate(bookdata.getDepartureDate());

        reserveRepository.persist(reserveEntity);
        return reserveEntity;
    }

    public List<ReserveEntity> listBookingData() {
        return reserveRepository.listAll();
    }

    public List<ReserveEntity> listBookingDataByDocument(RegisterReserveDTO bookdata) {
        return reserveRepository.listByDocument(bookdata.getUserDocument());
    }
}
