package com.alea.pokemon.mapper;

import com.alea.pokemon.model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static com.alea.pokemon.testbuilder.PokemonTestBuilder.BULBASAUR;
import static com.alea.pokemon.testbuilder.PokemonTestBuilder.PIKACHU;
import static org.junit.jupiter.api.Assertions.*;

class MostBaseXpPokemonMapperTest {


    private MostBaseXpPokemonMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(MostBaseXpPokemonMapper.class);
    }

    @Test
    public void testToMostBaseXpPokemon() {
        Pokemon pokemon = new Pokemon("Pikachu", 60, 40, 100);

        var result = mapper.toMostBaseXpPokemon(pokemon);

        assertEquals(pokemon.name(), result.name());
        assertEquals(pokemon.baseXp(), result.baseXp());
    }

    @Test
    public void testToMostBaseXpPokemonList() {
        var pokemonList = Arrays.asList(PIKACHU, BULBASAUR);

        var heaviestPokemonList = mapper.toMostBaseXpPokemonList(pokemonList);

        assertEquals(pokemonList.size(), heaviestPokemonList.size());

        assertEquals(pokemonList.get(0).name(), heaviestPokemonList.get(0).name());
        assertEquals(pokemonList.get(0).baseXp(), heaviestPokemonList.get(0).baseXp());
        assertEquals(pokemonList.get(1).name(), heaviestPokemonList.get(1).name());
        assertEquals(pokemonList.get(1).baseXp(), heaviestPokemonList.get(1).baseXp());
    }

    @Test
    public void testToMostBaseXpPokemonResponse() {
        var pokemonList = Arrays.asList(PIKACHU, BULBASAUR);

        var result = mapper.toMostBaseXpPokemonResponse(pokemonList);

        assertEquals(pokemonList.get(0).name(), result.pokemon().get(0).name());
        assertEquals(pokemonList.get(0).baseXp(), result.pokemon().get(0).baseXp());
        assertEquals(pokemonList.get(1).name(), result.pokemon().get(1).name());
        assertEquals(pokemonList.get(1).baseXp(), result.pokemon().get(1).baseXp());
    }

}