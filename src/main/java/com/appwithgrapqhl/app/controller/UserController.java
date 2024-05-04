package com.appwithgrapqhl.app.controller;

import com.appwithgrapqhl.app.Entiy.UserData;
import com.appwithgrapqhl.app.Entiy.User;
import com.appwithgrapqhl.app.resolvers.UserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserController {

    private final UserResolver userResolver;

    @Autowired
    public UserController(UserResolver userResolver){
        this.userResolver = userResolver;
    }


    @MutationMapping
    public Mono<User> saveUser(@Argument String name, @Argument String email, @Argument Integer edad){
        System.out.println("!!Guardando nuevo usuario. --------------------------------------------------");
        UserData data = new UserData(name,email,edad);
        return userResolver.saveUserResolver(data);
    }

    @QueryMapping
    public Mono<User> findUserById(@Argument String  id){
        System.out.println("!!Retornando todos los usuarios, ----------------------------------------------");
        return userResolver.getUserResolver(id);
    }

    @QueryMapping
    public Flux<User> findAllUsers(){
        return userResolver.allUsersResolver();
    }
}
