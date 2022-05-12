package com.pokemonsimulator.demo.service;

import java.util.List;

import com.pokemonsimulator.demo.model.Move;
import com.pokemonsimulator.demo.repository.MoveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveService {
    
    @Autowired
    MoveRepository moveRepo;

    public Move saveMove(Move move){
        return moveRepo.save(move);
    }

    public List<Move> getAllMoves(){
        return moveRepo.findAll();
    }

}
