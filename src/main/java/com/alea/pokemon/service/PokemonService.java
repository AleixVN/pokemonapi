package com.alea.pokemon.service;

import com.alea.pokemon.model.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getHeaviestPokemon();

    List<Pokemon> getHighestPokemon();

    List<Pokemon> getMostBaseXpPokemon();

}
