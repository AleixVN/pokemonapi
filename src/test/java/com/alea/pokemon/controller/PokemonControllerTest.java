package com.alea.pokemon.controller;

import com.alea.pokemon.dto.HeaviestPokemon;
import com.alea.pokemon.dto.HeaviestPokemonResponse;
import com.alea.pokemon.dto.HighestPokemon;
import com.alea.pokemon.dto.HighestPokemonResponse;
import com.alea.pokemon.dto.MostBaseXpPokemon;
import com.alea.pokemon.dto.MostBaseXpPokemonResponse;
import com.alea.pokemon.mapper.HeaviestPokemonMapper;
import com.alea.pokemon.mapper.HighestPokemonMapper;
import com.alea.pokemon.mapper.MostBaseXpPokemonMapper;
import com.alea.pokemon.model.Pokemon;
import com.alea.pokemon.service.PokemonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.alea.pokemon.testbuilder.PokemonTestBuilder.PIKACHU;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PokemonControllerTest {

    @Mock
    private PokemonService service;

    @Mock
    private HeaviestPokemonMapper heaviestPokemonMapper;

    @Mock
    private HighestPokemonMapper highestPokemonMapper;

    @Mock
    private MostBaseXpPokemonMapper mostBaseXpPokemonMapper;

    @InjectMocks
    private PokemonController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetHeaviestPokemon() throws Exception {
        var pokemonList = List.of(PIKACHU);
        var response = new HeaviestPokemonResponse(List.of(new HeaviestPokemon("Pikachu", 60)));

        when(service.getHeaviestPokemon()).thenReturn(pokemonList);
        when(heaviestPokemonMapper.toHeaviestPokemonResponse(pokemonList)).thenReturn(response);

        mockMvc.perform(get("/pokemon/heaviest")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.pokemon[0].name").value("Pikachu"))
                .andExpect(jsonPath("$.pokemon[0].weight").value(60));

        verify(service, times(1)).getHeaviestPokemon();
        verify(heaviestPokemonMapper, times(1)).toHeaviestPokemonResponse(pokemonList);
    }

    @Test
    void testGetHighestPokemon() throws Exception {
        var pokemonList = List.of(PIKACHU);
        var response = new HighestPokemonResponse(List.of(new HighestPokemon("Pikachu", 40)));

        when(service.getHighestPokemon()).thenReturn(pokemonList);
        when(highestPokemonMapper.toHighestPokemonResponse(pokemonList)).thenReturn(response);

        mockMvc.perform(get("/pokemon/highest")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.pokemon[0].name").value("Pikachu"))
                .andExpect(jsonPath("$.pokemon[0].height").value(40));

        verify(service, times(1)).getHighestPokemon();
        verify(highestPokemonMapper, times(1)).toHighestPokemonResponse(pokemonList);
    }

    @Test
    void testGetMostBaseXpPokemon() throws Exception {
        var pokemonList = List.of(PIKACHU);
        var response = new MostBaseXpPokemonResponse(List.of(new MostBaseXpPokemon("Pikachu", 100)));

        when(service.getMostBaseXpPokemon()).thenReturn(pokemonList);
        when(mostBaseXpPokemonMapper.toMostBaseXpPokemonResponse(pokemonList)).thenReturn(response);

        mockMvc.perform(get("/pokemon/most-base-xp")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.pokemon[0].name").value("Pikachu"))
                .andExpect(jsonPath("$.pokemon[0].baseXp").value(100));

        verify(service, times(1)).getMostBaseXpPokemon();
        verify(mostBaseXpPokemonMapper, times(1)).toMostBaseXpPokemonResponse(pokemonList);
    }
}