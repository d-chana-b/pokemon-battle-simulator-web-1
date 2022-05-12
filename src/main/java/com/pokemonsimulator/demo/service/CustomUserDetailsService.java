package com.pokemonsimulator.demo.service;

import com.pokemonsimulator.demo.dto.UserRegistrationDto;
import com.pokemonsimulator.demo.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

//Custom user details service but interface lol
public interface CustomUserDetailsService extends UserDetailsService { //inherits the userdetails interface

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
