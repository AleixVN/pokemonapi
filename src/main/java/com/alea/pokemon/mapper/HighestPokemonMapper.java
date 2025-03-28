package com.alea.pokemon.mapper;

import com.alea.pokemon.model.Pokemon;
import com.alea.pokemon.dto.HighestPokemon;
import com.alea.pokemon.dto.HighestPokemonResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface HighestPokemonMapper {

    HighestPokemon toHighestPokemon(Pokemon pokemon);

    List<HighestPokemon> toHighestPokemonList(List<Pokemon> pokemonList);

    default HighestPokemonResponse toHighestPokemonResponse(List<Pokemon> pokemonList) {
        return new HighestPokemonResponse(toHighestPokemonList(pokemonList));
    }

}
