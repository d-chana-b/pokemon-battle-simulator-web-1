package com.pokemonsimulator.demo.service;

import java.util.List;
import java.util.Optional;

import com.pokemonsimulator.demo.model.Pokemon;
import com.pokemonsimulator.demo.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    
    @Autowired
    PokemonRepository pokemonRepo;

    public Pokemon savePokemon(Pokemon pokemon){
        return pokemonRepo.save(pokemon);
    }

    public List<Pokemon> getAllPokemon(){
        return pokemonRepo.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long id){
        return pokemonRepo.findById(id);
    }
}

