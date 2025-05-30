package br.com.invest.investControl.service;

import br.com.invest.investControl.controller.CreateUserDto;
import br.com.invest.investControl.entity.User;
import br.com.invest.investControl.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UUID createUser(CreateUserDto createUserDto) {

        //DTO converter pra entity
        var entity = new User(UUID.randomUUID(),
                            createUserDto.username(),
                            createUserDto.email(),
                            createUserDto.password(),
                            Instant.now(),
                            null);


        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    }
}