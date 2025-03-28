package com.alea.pokemon.mapper;

import com.alea.pokemon.model.PokemonEntity;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PokemonEntityMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "baseXp", source = "baseExperience")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "weight", source = "weight")
    PokemonEntity toEntity(Pokemon pokemon);

}
