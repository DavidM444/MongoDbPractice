package com.appwithgrapqhl.app.resolvers;

import com.appwithgrapqhl.app.Entiy.UserData;
import com.appwithgrapqhl.app.repository.UserRepository;
import com.appwithgrapqhl.app.Entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserResolver {

    private final UserRepository userRepository;
    @Autowired
    public UserResolver(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public Mono<User> getUserResolver(String id){
        User user = userRepository.findById(id).orElse(null);
        if (user==null){
           throw new RuntimeException("user is null");
        }
        return Mono.just(user);
    }

   public Flux<User> allUsersResolver(){
        List<User> users = userRepository.findAll();
        return Flux.fromIterable(users);
    }

    public Mono<User> saveUserResolver(UserData data){
        User user = userRepository.save(new User(data.name(), data.email(), data.edad()));
        System.out.println("user "+ user.toString());
        return Mono.just(user);
    }


}
