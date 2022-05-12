package com.pokemonsimulator.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonsimulator.demo.model.Role;
import com.pokemonsimulator.demo.repository.RoleRepository;



@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepo;

    public Role show(Long id) {
        Optional<Role> optional = roleRepo.findById(id);
        Role role = null;
        if (optional.isPresent()) {
            role = optional.get();
        } else {
            throw new RuntimeException(" Role not found for id :: " + id);
        }
        return role;
    }
}
