package br.com.hotel.service;

import br.com.hotel.dto.RegisterReserveDTO;
import br.com.hotel.entity.ReserveEntity;
import br.com.hotel.entity.RoomEntity;
import br.com.hotel.mapper.ReserveMapper;
import br.com.hotel.repository.ReserveRepository;
import br.com.hotel.repository.RoomRepository;
import exception.WebApplicationExceptionError;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
@Transactional
public class ReserveService {

    @Inject
    ReserveRepository reserveRepository;

    @Inject
    RoomRepository roomRepository;

    @Inject
    ReserveMapper reserveMapper;

    public ReserveEntity bookroomSave(RegisterReserveDTO bookdata) {

        if (bookdata==null) {
            throw new WebApplicationException("");
        }

        if (Boolean.TRUE.equals(checkAvailability(bookdata))) {
            RoomEntity hotel = roomRepository.findAll().firstResult();
            ReserveEntity reserve = reserveMapper.toEntity(bookdata);
            reserve.setHotel(hotel.getHotelName());
            reserve.setRoom(hotel.getNumberRoom());
            reserveRepository.persist(reserve);
            return reserve;
        }
        return null;
    }

    public ReserveEntity bookroomChange(RegisterReserveDTO bookdata) {
        ReserveEntity reserve = reserveRepository.findById(bookdata.getId());
        RoomEntity hotel = roomRepository.findAll().firstResult();
        if (reserve == null) {
            throw new WebApplicationExceptionError("Reservation not found!",
                    "Reservation not found!");
        }

        if (Boolean.TRUE.equals(checkAvailability(bookdata))) {
            reserve.setUserName(bookdata.getUserName());
            reserve.setPhoneUser(bookdata.getPhoneUser());
            reserve.setEntryDate(bookdata.getEntryDate());
            reserve.setDepartureDate(bookdata.getDepartureDate());
            reserve.setHotel(hotel.getHotelName());
            reserve.setRoom(hotel.getNumberRoom());
            reserveRepository.persist(reserve);
            return reserve;
        }

        throw new WebApplicationExceptionError("Error: not found!",
                "Error: not found!");
    }

    public List<ReserveEntity> listBookingData() {
        System.out.println(reserveRepository.listAll());
        return reserveRepository.listAll();
    }

    public List<ReserveEntity> listBookingDataByDocument(String document) {
        return reserveRepository.listByDocument(document);
    }

    public boolean deleteById(Long id) {
        return reserveRepository.deleteById(id);
    }

    public Boolean checkAvailability(RegisterReserveDTO bookdata) {
        List<ReserveEntity> bookingRoom = listBookingData();
        if (Objects.nonNull(bookingRoom)) {
            bookingRoom.forEach(data -> {
                if (((bookdata.getEntryDate().isAfter(data.getEntryDate()))
                        && (bookdata.getEntryDate().isBefore(data.getDepartureDate())))
                    || (bookdata.getDepartureDate().isAfter(data.getEntryDate())
                        && bookdata.getDepartureDate().isBefore(data.getDepartureDate()))
                    || (bookdata.getEntryDate().isEqual(data.getEntryDate())
                        || bookdata.getEntryDate().isEqual(data.getDepartureDate())
                        || bookdata.getDepartureDate().isEqual(data.getEntryDate()))) {
                    throw new WebApplicationExceptionError("There is already a reservation for that date!",
                            "There is already a reservation for that date!");
                }
                if (Objects.equals(bookdata.getUserDocument(), data.getUserDocument()) && bookdata.getId() == null) {
                    throw new WebApplicationExceptionError("Reservation already exists for this user!",
                            "Reservation already exists for this user!");
                }
            });
        }

        if (bookdata.getEntryDate().isBefore(LocalDate.now())) {
            throw new WebApplicationExceptionError("Booking date cannot be less than today!",
                    "Booking date cannot be less than today!");
        }

        if (bookdata.getEntryDate().isAfter(LocalDate.now().plusDays(30))) {
            throw new WebApplicationExceptionError("Booking date cannot be longer than 30 days!",
                    "Booking date cannot be longer than 30 days!");
        }

        if (bookdata.getDepartureDate().isAfter(bookdata.getEntryDate().plusDays(2))) {
            throw new WebApplicationExceptionError("The reservation period cannot be longer than 3 days!",
                    "The reservation period cannot be longer than 3 days!");
        }
        return true;
    }
}
