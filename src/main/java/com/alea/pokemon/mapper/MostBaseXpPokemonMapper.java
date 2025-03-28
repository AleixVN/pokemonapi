package com.alea.pokemon.mapper;

import com.alea.pokemon.model.Pokemon;
import com.alea.pokemon.dto.MostBaseXpPokemon;
import com.alea.pokemon.dto.MostBaseXpPokemonResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MostBaseXpPokemonMapper {

    MostBaseXpPokemon toMostBaseXpPokemon(Pokemon pokemon);

    List<MostBaseXpPokemon> toMostBaseXpPokemonList(List<Pokemon> pokemonList);

    default MostBaseXpPokemonResponse toMostBaseXpPokemonResponse(List<Pokemon> pokemonList) {
        return new MostBaseXpPokemonResponse(toMostBaseXpPokemonList(pokemonList));
    }

}
