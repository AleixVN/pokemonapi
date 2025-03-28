package com.alea.pokemon.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;

import static com.alea.pokemon.testbuilder.PokemonTestBuilder.BULBASAUR;
import static com.alea.pokemon.testbuilder.PokemonTestBuilder.PIKACHU;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HighestPokemonMapperTest {

    private HighestPokemonMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(HighestPokemonMapper.class);
    }

    @Test
    public void testToHighestPokemon() {
        var pokemon = PIKACHU;

        var result = mapper.toHighestPokemon(pokemon);

        assertEquals(pokemon.name(), result.name());
        assertEquals(pokemon.height(), result.height());
    }

    @Test
    public void testToHighestPokemonList() {
        var pokemonList = Arrays.asList(PIKACHU, BULBASAUR);

        var heaviestPokemonList = mapper.toHighestPokemonList(pokemonList);

        assertEquals(pokemonList.size(), heaviestPokemonList.size());

        assertEquals(pokemonList.get(0).name(), heaviestPokemonList.get(0).name());
        assertEquals(pokemonList.get(0).height(), heaviestPokemonList.get(0).height());
        assertEquals(pokemonList.get(1).name(), heaviestPokemonList.get(1).name());
        assertEquals(pokemonList.get(1).height(), heaviestPokemonList.get(1).height());
    }

    @Test
    public void testToHighestPokemonResponse() {
        var pokemonList = Arrays.asList(PIKACHU, BULBASAUR);

        var result = mapper.toHighestPokemonResponse(pokemonList);

        assertEquals(pokemonList.get(0).name(), result.pokemon().get(0).name());
        assertEquals(pokemonList.get(0).height(), result.pokemon().get(0).height());
        assertEquals(pokemonList.get(1).name(), result.pokemon().get(1).name());
        assertEquals(pokemonList.get(1).height(), result.pokemon().get(1).height());
    }
}