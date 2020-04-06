package com.example.ridernetkotlinproject.data.repository;

import com.example.ridernetproject.User;

import java.util.List;

public interface IUserRepository {
    void addUser(User user);
    User getUser();
    void deleteUser(User user);
    void editUser(User user);

    List<User> getByFullName(String fullName);
    List<User> getByAge(int age);
}
