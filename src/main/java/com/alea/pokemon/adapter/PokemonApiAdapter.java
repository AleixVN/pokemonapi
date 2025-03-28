package com.alea.pokemon.adapter;

import com.alea.pokemon.mapper.PokemonEntityMapper;
import com.alea.pokemon.repository.PokemonRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class PokemonApiAdapter {

    private final PokemonRepository repository;
    private final PokemonEntityMapper mapper;
    private final PokeApi pokeApi;

    @PostConstruct
    public void populate() {
        var pokemonList = pokeApi.getPokemonList(0, 1302).getResults();

        log.info("Populating {} pokemon", pokemonList.size());

        var pokemonEntities = pokemonList.stream()
                .map(NamedApiResource::getId)
                .collect(Collectors.toSet())
                .stream()
                .map(pokeApi::getPokemon)
                .map(mapper::toEntity)
                .toList();
        repository.saveAll(pokemonEntities);

        log.info("Database populated. Go catch them all!");
    }

}
