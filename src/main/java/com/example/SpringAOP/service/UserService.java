package com.example.SpringAOP.service;

import com.example.SpringAOP.aspects.TrackUserAction;
import com.example.SpringAOP.model.User;
import com.example.SpringAOP.repositories.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @TrackUserAction
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @TrackUserAction
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @TrackUserAction
    public void deleteById(int id){
        userRepository.deleteById(id);
    }
    public User getOne(int id){
        System.out.println("User service get id: " + id);
        return userRepository.getOne(id);
    }
    @TrackUserAction
    public User updateUser(User user){
        return userRepository.update(user);
    }
}
