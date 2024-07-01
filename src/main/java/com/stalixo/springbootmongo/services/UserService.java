package com.stalixo.springbootmongo.services;

import com.stalixo.springbootmongo.domain.User;
import com.stalixo.springbootmongo.repository.UserRepository;
import com.stalixo.springbootmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);

        user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

        return user.get();
    }
}
