package com.appwithgrapqhl.app.Entiy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class User {
    @Id
    private String id;
    private String nombre;
    private String email;
    private Integer edad;

    public User(){}

    public User(String nombre, String email, Integer edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                '}';
    }
}