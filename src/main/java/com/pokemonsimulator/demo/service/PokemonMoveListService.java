package com.pokemonsimulator.demo.service;

import java.util.List;
import java.util.Optional;

import com.pokemonsimulator.demo.model.Move;
import com.pokemonsimulator.demo.model.Pokemon;
import com.pokemonsimulator.demo.model.PokemonMoveList;
import com.pokemonsimulator.demo.repository.PokemonMoveListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonMoveListService {
    
    @Autowired
    PokemonMoveListRepository pokeMoveRepo;

    //hindi ko pa naaral panu gumawa ng custom query sa jpa repository
    public List<PokemonMoveList> getAllMovesByPokemonId(Pokemon id){
        return pokeMoveRepo.findAllByPokemon(id);
    }

    // public Optional<PokemonMoveList> checkExistingPokemonMoveList(PokemonMoveList pokeMoveEntity){
    //     List<PokemonMoveList> allMovesByPokemon = pokeMoveRepo.findAllPokemonMoveListByPokemonId(pokeMoveEntity.getId());
    //     PokemonMoveList temp = pokeMoveEntity;
    //     for (PokemonMoveList pokemonMoveEntity : allMovesByPokemon) {
    //         if(pokemonMoveEntity.getMove().equals(pokeMoveEntity.getMove())){
    //             temp = pokemonMoveEntity;
    //         }
    //     }
    //     return pokeMoveRepo.findById(temp.getId());
        
    // }

    public PokemonMoveList saveMoveToPokemon(Pokemon pokemon,Move move, String category){

        PokemonMoveList pokemonMoveList = new PokemonMoveList();
        pokemonMoveList.setPokemon(pokemon);
        pokemonMoveList.setMove(move);
        pokemonMoveList.setMoveCategory(category);

        return pokeMoveRepo.save(pokemonMoveList);
    }
}
