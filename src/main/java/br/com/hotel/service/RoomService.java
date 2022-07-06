package br.com.hotel.service;

import br.com.hotel.dto.RegisterRoomDTO;
import br.com.hotel.entity.RoomEntity;
import br.com.hotel.repository.RoomRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class RoomService {

    @Inject
    RoomRepository roomRepository;

    public RoomEntity roomSave(RegisterRoomDTO roomdata) {

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setHotelName(roomdata.getHotelName());
        roomEntity.setNumberRoom(roomdata.getNumber());

        roomRepository.persist(roomEntity);
        return roomEntity;
    }

    public List<RoomEntity> listRoom() {
        System.out.println(roomRepository.listAll());
        return roomRepository.listAll();
    }

}
