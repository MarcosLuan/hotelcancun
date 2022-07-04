package br.com.hotel.repository;

import br.com.hotel.entity.RoomEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RoomRepository implements PanacheRepository<RoomEntity> {

//    public List<RoomEntity> listByHotel(String hotelName) {
//        return find("hotel", Sort.descending("id"), hotelName).list();
//    }
}
