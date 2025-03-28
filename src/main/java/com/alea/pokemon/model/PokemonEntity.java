package com.alea.pokemon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pokemon")
public class PokemonEntity {

    @Id
    Integer id;

    @Column(unique = true)
    String name;

    Integer weight;
    Integer height;
    Integer baseXp;
}
