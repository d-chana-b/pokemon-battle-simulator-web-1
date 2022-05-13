package com.pokemonsimulator.demo.repository;

import com.pokemonsimulator.demo.model.Move;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository extends JpaRepository<Move,Long>{
    
}
