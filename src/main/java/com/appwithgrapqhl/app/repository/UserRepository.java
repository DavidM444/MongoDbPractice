package com.appwithgrapqhl.app.repository;

import com.appwithgrapqhl.app.Entiy.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
