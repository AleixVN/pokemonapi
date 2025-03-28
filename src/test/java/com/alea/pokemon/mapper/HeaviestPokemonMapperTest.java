package com.alea.pokemon.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;

import static com.alea.pokemon.testbuilder.PokemonTestBuilder.BULBASAUR;
import static com.alea.pokemon.testbuilder.PokemonTestBuilder.PIKACHU;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaviestPokemonMapperTest {

    private HeaviestPokemonMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(HeaviestPokemonMapper.class);
    }

    @Test
    public void testToHeaviestPokemon() {
        var pokemon = PIKACHU;

        var result = mapper.toHeaviestPokemon(pokemon);

        assertEquals(pokemon.name(), result.name());
        assertEquals(pokemon.weight(), result.weight());
    }

    @Test
    public void testToHeaviestPokemonList() {
        var pokemonList = Arrays.asList(PIKACHU, BULBASAUR);

        var heaviestPokemonList = mapper.toHeaviestPokemonList(pokemonList);

        assertEquals(pokemonList.size(), heaviestPokemonList.size());

        assertEquals(pokemonList.get(0).name(), heaviestPokemonList.get(0).name());
        assertEquals(pokemonList.get(0).weight(), heaviestPokemonList.get(0).weight());
        assertEquals(pokemonList.get(1).name(), heaviestPokemonList.get(1).name());
        assertEquals(pokemonList.get(1).weight(), heaviestPokemonList.get(1).weight());
    }

    @Test
    public void testToHeaviestPokemonResponse() {
        var pokemonList = Arrays.asList(PIKACHU, BULBASAUR);

        var result = mapper.toHeaviestPokemonResponse(pokemonList);

        assertEquals(pokemonList.get(0).name(), result.pokemon().get(0).name());
        assertEquals(pokemonList.get(0).weight(), result.pokemon().get(0).weight());
        assertEquals(pokemonList.get(1).name(), result.pokemon().get(1).name());
        assertEquals(pokemonList.get(1).weight(), result.pokemon().get(1).weight());
    }
}