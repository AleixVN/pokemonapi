package com.alea.pokemon.adapter;

import com.alea.pokemon.mapper.PokemonEntityMapper;
import com.alea.pokemon.model.PokemonEntity;
import com.alea.pokemon.repository.PokemonRepository;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.alea.pokemon.testbuilder.PokeApiPokemonTestBuilder.bulbasaur;
import static com.alea.pokemon.testbuilder.PokeApiPokemonTestBuilder.charmander;
import static com.alea.pokemon.testbuilder.PokeApiPokemonTestBuilder.pikachu;
import static com.alea.pokemon.testbuilder.PokemonEntityTestBuilder.BULBASAUR;
import static com.alea.pokemon.testbuilder.PokemonEntityTestBuilder.CHARMANDER;
import static com.alea.pokemon.testbuilder.PokemonEntityTestBuilder.PIKACHU;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonApiAdapterTest {

    @Mock
    private PokemonRepository repository;

    @Mock
    private PokemonEntityMapper mapper;

    @Mock
    private PokeApi pokeApi;

    @InjectMocks
    private PokemonApiAdapter pokemonApiAdapter;


    @Test
    void testPopulate() {
        var idList = new NamedApiResourceList(2, null, null, List.of(
                new NamedApiResource("name", "category", 1),
                new NamedApiResource("name", "category", 2),
                new NamedApiResource("name", "category", 3)
        ));

        var pokemonList = List.of(pikachu(), bulbasaur(), charmander());

        var pokemonEntities = List.of(PIKACHU, BULBASAUR, CHARMANDER);


        when(pokeApi.getPokemonList(0, 1302)).thenReturn(idList);
        when(pokeApi.getPokemon(anyInt())).thenAnswer(invocation -> {
            int id = invocation.getArgument(0);
            return pokemonList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        });
        when(mapper.toEntity(any(Pokemon.class))).thenAnswer(invocation -> {
            Pokemon p = invocation.getArgument(0);
            return pokemonEntities.stream().filter(pk -> pk.getName().equals(p.getName())).findFirst().orElse(null);
        });


        pokemonApiAdapter.populate();

        verify(pokeApi, times(1)).getPokemonList(0, 1302);
        verify(pokeApi, times(3)).getPokemon(anyInt());

        verify(mapper, times(3)).toEntity(any(Pokemon.class));

        verify(repository, times(1)).saveAll(pokemonEntities);
    }
}