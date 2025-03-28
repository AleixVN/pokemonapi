package com.alea.pokemon.service;

import com.alea.pokemon.mapper.PokemonMapper;
import com.alea.pokemon.model.PokemonEntity;
import com.alea.pokemon.repository.PokemonRepository;
import com.alea.pokemon.service.impl.PokemonServiceImpl;
import com.alea.pokemon.testbuilder.PokemonTestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static com.alea.pokemon.testbuilder.PokemonEntityTestBuilder.BULBASAUR;
import static com.alea.pokemon.testbuilder.PokemonEntityTestBuilder.PIKACHU;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @Mock
    private PokemonRepository repository;

    @Mock
    private PokemonMapper mapper;

    private PokemonServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new PokemonServiceImpl(repository, mapper);
    }

    @Test
    void testGetHeaviestPokemon() {
        var pokemonEntities = Arrays.asList(BULBASAUR, PIKACHU);
        var expectedDtos = Arrays.asList(PokemonTestBuilder.BULBASAUR, PokemonTestBuilder.PIKACHU);

        when(repository.findTop5ByOrderByWeightDesc()).thenReturn(pokemonEntities);
        when(mapper.toDto(eq(pokemonEntities.getFirst()))).thenReturn(expectedDtos.getFirst());
        when(mapper.toDto(eq(pokemonEntities.getLast()))).thenReturn(expectedDtos.getLast());

        var result = service.getHeaviestPokemon();

        assertEquals(2, result.size());
        assertEquals("Bulbasaur", result.get(0).name());
        assertEquals("Pikachu", result.get(1).name());

        verify(repository).findTop5ByOrderByWeightDesc();
        verify(mapper, times(2)).toDto(any(PokemonEntity.class));
    }

    @Test
    void testGetHighestPokemon() {
        var pokemonEntities = Arrays.asList(BULBASAUR, PIKACHU);
        var expectedDtos = Arrays.asList(PokemonTestBuilder.BULBASAUR, PokemonTestBuilder.PIKACHU);

        when(repository.findTop5ByOrderByHeightDesc()).thenReturn(pokemonEntities);
        when(mapper.toDto(eq(pokemonEntities.getFirst()))).thenReturn(expectedDtos.getFirst());
        when(mapper.toDto(eq(pokemonEntities.getLast()))).thenReturn(expectedDtos.getLast());

        var result = service.getHighestPokemon();

        assertEquals(2, result.size());
        assertEquals("Bulbasaur", result.get(0).name());
        assertEquals("Pikachu", result.get(1).name());

        verify(repository).findTop5ByOrderByHeightDesc();
        verify(mapper, times(2)).toDto(any(PokemonEntity.class));
    }

    @Test
    void testGetMostBaseXpPokemon() {
        var pokemonEntities = Arrays.asList(BULBASAUR, PIKACHU);
        var expectedDtos = Arrays.asList(PokemonTestBuilder.BULBASAUR, PokemonTestBuilder.PIKACHU);

        when(repository.findTop5ByOrderByBaseXpDesc()).thenReturn(pokemonEntities);
        when(mapper.toDto(eq(pokemonEntities.getFirst()))).thenReturn(expectedDtos.getFirst());
        when(mapper.toDto(eq(pokemonEntities.getLast()))).thenReturn(expectedDtos.getLast());

        var result = service.getMostBaseXpPokemon();

        assertEquals(2, result.size());
        assertEquals("Bulbasaur", result.get(0).name());
        assertEquals("Pikachu", result.get(1).name());

        verify(repository).findTop5ByOrderByBaseXpDesc();
        verify(mapper, times(2)).toDto(any(PokemonEntity.class));
    }

}