package com.appwithgrapqhl.app.controller;

import com.appwithgrapqhl.app.Entiy.User;
import com.appwithgrapqhl.app.Entiy.userDataDos;
import com.appwithgrapqhl.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/userkafka")
public class UserControllerKafka {

    private final KafkaTemplate<String, User> kafkaTemplate;
    private final UserRepository userRepository;


    @Autowired
    public UserControllerKafka(KafkaTemplate<String,User> tmp, UserRepository repo){
        this.userRepository = repo;
        this.kafkaTemplate = tmp;
    }
    @PostMapping //metodo bloequeante no reactivo.
    public Mono<ResponseEntity<User>> registerUser(@RequestBody User user) { //It send User object to topoic
        System.out.println("registrando solicitud");
        return Mono.just(userRepository.save(user)).doOnSuccess(savedUser -> kafkaTemplate.send("user-registrations",
                savedUser))
                .map(ResponseEntity::ok);
    }

}
