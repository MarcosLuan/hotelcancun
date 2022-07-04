package br.com.hotel.repository;

import br.com.hotel.entity.ReserveEntity;
import br.com.hotel.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

//    public List<UserEntity> listByDocument(String document) {
//        return find("document", Sort.descending("id"), document).list();
//    }
}
