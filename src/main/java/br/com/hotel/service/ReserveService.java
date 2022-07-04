package br.com.hotel.service;

import br.com.hotel.dto.RegisterReserveDTO;
import br.com.hotel.entity.ReserveEntity;
import br.com.hotel.repository.ReserveRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
@Transactional
public class ReserveService {

    @Inject
    ReserveRepository reserveRepository;

    public void bookroomSave(RegisterReserveDTO bookdata) {

        if (bookdata==null) {
            throw new RuntimeException("");
        }

        List<ReserveEntity> bookingRoom = listBookingData();
        if (Objects.nonNull(bookingRoom)) {
            bookingRoom.forEach(data -> {
                if ((bookdata.getEntryDate().isAfter(data.getEntryDate()))
                        && (bookdata.getEntryDate().isBefore(data.getDepartureDate()))) {
                    throw new RuntimeException("Já existe reserva para essa data!");
                } else if(bookdata.getDepartureDate().isAfter(data.getEntryDate())
                        && bookdata.getDepartureDate().isBefore(data.getDepartureDate())) {
                    throw new RuntimeException("Já existe reserva para essa data!");
                } else if (bookdata.getEntryDate().isEqual(data.getEntryDate())
                        || bookdata.getEntryDate().isEqual(data.getDepartureDate())
                        || bookdata.getDepartureDate().isEqual(data.getEntryDate())) {
                    throw new RuntimeException("Já existe reserva para essa data!");
                }
            });
        }

        if (bookdata.getEntryDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Data de reserva não pode menor que hoje!");
        }

        if (bookdata.getEntryDate().isAfter(LocalDate.now().plusDays(30))) {
            throw new RuntimeException("Data de reserva não pode ser maior que 30 dias!");
        }

        ReserveEntity reserveEntity = new ReserveEntity();
        reserveEntity.setUserName(bookdata.getUserName());
        reserveEntity.setUserDocument(bookdata.getUserDocument());
        reserveEntity.setPhoneUser(bookdata.getPhoneUser());
        reserveEntity.setEntryDate(bookdata.getEntryDate());
        reserveEntity.setDepartureDate(bookdata.getDepartureDate());

        reserveRepository.persist(reserveEntity);
    }

    public List<ReserveEntity> listBookingData() {
        System.out.println(reserveRepository.listAll());
        return reserveRepository.listAll();
    }

    public List<ReserveEntity> listBookingDataByDocument(String document) {
        System.out.println(reserveRepository.listByDocument(document));
        return reserveRepository.listByDocument(document);
    }
}
