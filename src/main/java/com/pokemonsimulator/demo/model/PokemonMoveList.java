// package com.pokemonsimulator.demo.model;

// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToMany;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
// import javax.persistence.Table;

// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity
// @Getter
// @Setter
// @NoArgsConstructor
// public class PokemonMoveList {

//     @Id
//     private Long id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "pokemon_id", referencedColumnName = "pokemonId")
//     private Pokemon pokemon;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "move_id", referencedColumnName = "moveId")
//     private Move move;

//     private String moveCategory;

// }
