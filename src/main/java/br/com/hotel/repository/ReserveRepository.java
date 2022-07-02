package br.com.hotel.repository;

import br.com.hotel.entity.ReserveEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ReserveRepository implements PanacheRepository<ReserveEntity> {

    public List<ReserveEntity> listByDocument(String document) {
        return find("user_document", Sort.descending("id"), document).list();
    }
}
