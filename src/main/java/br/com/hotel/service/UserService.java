package br.com.hotel.service;

import br.com.hotel.dto.RegisterUserDTO;
import br.com.hotel.entity.UserEntity;
import br.com.hotel.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class UserService {

    @Inject
    UserRepository userRepository;

    public UserEntity userSave(RegisterUserDTO userdata) {

        UserEntity userEntity = new UserEntity();
        userEntity.setDocument(userdata.getDocument());
        userEntity.setName(userdata.getName());
        userEntity.setPhone(userdata.getPhone());

        userRepository.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> listUsers() {
        System.out.println(userRepository.listAll());
        return userRepository.listAll();
    }
}
