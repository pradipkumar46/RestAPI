package com.spring.service;

import com.spring.model.User;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User userAdd(User user){
        return repository.save(user);
    }

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }
    @CachePut(value = "cache",key = "#id")
    public User updateUser(User user, Long id){
        Optional<User> user1=repository.findById(id);

        return repository.save(user);
    }
    @Cacheable(value = "cache")
    public List<User> getAllUser(){
        return repository.findAll();
    }

    @CacheEvict(value = "cache",key = "#id")
    public void deleteUser(User user, Long id){
         repository.deleteById(id);
    }
    @Cacheable(value = "cache")
    public Optional<User> getUser(Long id){
        return repository.findById(id);    }

        @CacheEvict(value = "cache")
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
