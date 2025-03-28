package com.alea.pokemon.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static com.alea.pokemon.testbuilder.PokemonEntityTestBuilder.PIKACHU;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PokemonMapperTest {

    private PokemonMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(PokemonMapper.class);
    }

    @Test
    public void testToDto() {
        var pokemonEntity = PIKACHU;

        var result = mapper.toDto(pokemonEntity);

        assertEquals(pokemonEntity.getName(), result.name());
        assertEquals(pokemonEntity.getWeight(), result.weight());
        assertEquals(pokemonEntity.getHeight(), result.height());
        assertEquals(pokemonEntity.getBaseXp(), result.baseXp());
    }
}