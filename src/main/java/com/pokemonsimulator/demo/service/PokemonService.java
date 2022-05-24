package com.pokemonsimulator.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.pokemonsimulator.demo.model.Move;
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

    public Pokemon addMove(Pokemon currentPokemon, Move move){
        Pokemon pokemon = new Pokemon();
        pokemon.setPokemonId(currentPokemon.getPokemonId());
        pokemon.setPokedexNumber(currentPokemon.getPokedexNumber());
        pokemon.setPokemonName(currentPokemon.getPokemonName());
        pokemon.setType1(currentPokemon.getType1());
        pokemon.setType2(currentPokemon.getType2());
        pokemon.setAbility1(currentPokemon.getAbility1());
        pokemon.setAbility2(currentPokemon.getAbility2());
        pokemon.setHiddenAbility(currentPokemon.getHiddenAbility());
        pokemon.setMoves(Arrays.asList(move));
        pokemon.setBaseHp(currentPokemon.getBaseHp());
        pokemon.setBaseAtk(currentPokemon.getBaseAtk());
        pokemon.setBaseDef(currentPokemon.getBaseDef());
        pokemon.setBaseSpAtk(currentPokemon.getBaseSpAtk());
        pokemon.setBaseSpDef(currentPokemon.getBaseSpDef());
        pokemon.setBaseSpeed(currentPokemon.getBaseSpeed());
        pokemon.setImageName(currentPokemon.getImageName());
        return pokemonRepo.save(pokemon);
    }
}

