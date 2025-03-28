package com.alea.pokemon.mapper;

import com.alea.pokemon.model.Pokemon;
import com.alea.pokemon.model.PokemonEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PokemonMapper {

    Pokemon toDto(PokemonEntity pokemonEntity);

}
