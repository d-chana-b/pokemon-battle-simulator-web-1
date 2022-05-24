package com.pokemonsimulator.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="move_data")
public class Move {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moveId;

//    @OneToMany(mappedBy = "move",cascade = CascadeType.ALL)
//    private List<PokemonMoveList> pokemonMoveLists;

    private String moveName;
    private String moveType;
    private String category;//physical or special
    private int basePower;
    private int accuracy;
}
