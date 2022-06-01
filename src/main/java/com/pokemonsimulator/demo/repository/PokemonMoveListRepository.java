package com.pokemonsimulator.demo.repository;

import java.util.List;

import com.pokemonsimulator.demo.model.Pokemon;
import com.pokemonsimulator.demo.model.PokemonMoveList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonMoveListRepository extends JpaRepository<PokemonMoveList,Long> {

    //public List<PokemonMoveList> findAllByMoveCategory(String moveCategory);

    public List<PokemonMoveList> findAllByPokemon(Pokemon Pokemon);
    
}
