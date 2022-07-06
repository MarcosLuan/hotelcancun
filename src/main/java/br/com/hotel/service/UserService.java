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

    public UserEntity userSave(RegisterUserDTO userData) {

        UserEntity userEntity = new UserEntity();
        userEntity.setDocument(userData.getDocument());
        userEntity.setName(userData.getName());
        userEntity.setPhone(userData.getPhone());

        userRepository.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> listUsers() {
        return userRepository.listAll();
    }
}
