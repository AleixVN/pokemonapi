package com.alea.pokemon.mapper;


import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokemonEntityMapperTest {

    private PokemonEntityMapper pokemonEntityMapper;

    @BeforeEach
    public void setUp() {
        pokemonEntityMapper = Mappers.getMapper(PokemonEntityMapper.class);
    }

    @Test
    public void testToEntity() {
        Pokemon pokemon = new Pokemon(
                1, "Pikachu", 112, 4, true, 1, 60, new NamedApiResource("", "", 1),
                List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), new PokemonSprites(null, null, null, null, null, null, null, null));


        var result = pokemonEntityMapper.toEntity(pokemon);

        assertEquals(pokemon.getName(), result.getName());
        assertEquals(pokemon.getWeight(), result.getWeight());
        assertEquals(pokemon.getHeight(), result.getHeight());
        assertEquals(pokemon.getBaseExperience(), result.getBaseXp());
    }

}