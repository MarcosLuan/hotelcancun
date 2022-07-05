package br.com.hotel.mapper;

import br.com.hotel.dto.RegisterReserveDTO;
import br.com.hotel.entity.ReserveEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReserveMapper {

    public ReserveEntity toEntity(RegisterReserveDTO bookRoom) {
        ReserveEntity reserveEntity = new ReserveEntity();
        reserveEntity.setUserName(bookRoom.getUserName());
        reserveEntity.setUserDocument(bookRoom.getUserDocument());
        reserveEntity.setPhoneUser(bookRoom.getPhoneUser());
        reserveEntity.setEntryDate(bookRoom.getEntryDate());
        reserveEntity.setDepartureDate(bookRoom.getDepartureDate());
        return reserveEntity;
    }

}
