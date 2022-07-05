package br.com.hotel.repository;

import br.com.hotel.entity.RoomEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoomRepository implements PanacheRepository<RoomEntity> {

}
