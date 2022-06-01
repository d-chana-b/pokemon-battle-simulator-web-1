package com.pokemonsimulator.demo.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
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
@Table(name = "pokemon_data")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pokemonId;

    @OneToMany(mappedBy = "pokemon",cascade = CascadeType.ALL)
    private List<PokemonMoveList> pokemonMoveLists;

    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(name = "pokemon_move_list", joinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "pokemonId", nullable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "move_id", referencedColumnName = "moveId",nullable = false, updatable = false))
    // private Collection<Move> moves;

    @Column(name = "pokedex_number")
    private int pokedexNumber;
    @Column(name = "pokemon_name")
    private String pokemonName;
    private String type1, type2;
    // private String Abilities;//list na lang ba to?
    // ito muna sa ngayon
    private String ability1, ability2, hiddenAbility;
    private int baseHp, baseAtk, baseDef, baseSpAtk, baseSpDef, baseSpeed;
    private String imageName;

    // public Pokemon(int pokedexNumber, String pokemonName, String type1, String type2,
    //         String ability1, String ability2, String hiddenAbility, Collection<Move> moves, int baseHp, int baseAtk,
    //         int baseDef, int baseSpAtk,
    //         int baseSpDef,String imageName) {
    //     this.pokedexNumber = pokedexNumber;
    //     this.pokemonName = pokemonName;
    //     this.type1 = type1;
    //     this.type2 = type2;
    //     this.ability1 = ability1;
    //     this.ability2 = ability2;
    //     this.hiddenAbility = hiddenAbility;
    //     this.moves = moves;
    //     this.baseHp = baseHp;
    //     this.baseAtk = baseAtk;
    //     this.baseDef = baseDef;
    //     this.baseSpAtk = baseSpAtk;
    //     this.baseSpDef = baseSpDef;
    //     this.imageName = imageName;
    // }

}
