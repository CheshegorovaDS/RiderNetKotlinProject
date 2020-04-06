package com.example.ridernetkotlinproject.data;

import com.example.ridernetkotlinproject.data.repository.IUserRepository;
import com.example.ridernetproject.User;

import java.util.List;

public class UsersRepository implements IUserRepository {
    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public List<User> getByFullName(String fullName) {
        return null;
    }

    @Override
    public List<User> getByAge(int age) {
        return null;
    }
}
