package com.alea.pokemon.mapper;

import com.alea.pokemon.model.Pokemon;
import com.alea.pokemon.dto.HeaviestPokemon;
import com.alea.pokemon.dto.HeaviestPokemonResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface HeaviestPokemonMapper {

    HeaviestPokemon toHeaviestPokemon(Pokemon pokemon);

    List<HeaviestPokemon> toHeaviestPokemonList(List<Pokemon> pokemonList);

    default HeaviestPokemonResponse toHeaviestPokemonResponse(List<Pokemon> pokemonList) {
        return new HeaviestPokemonResponse(toHeaviestPokemonList(pokemonList));
    }

}

