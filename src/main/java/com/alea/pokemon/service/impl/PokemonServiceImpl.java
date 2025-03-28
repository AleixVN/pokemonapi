package com.alea.pokemon.service.impl;

import com.alea.pokemon.mapper.PokemonMapper;
import com.alea.pokemon.model.Pokemon;
import com.alea.pokemon.repository.PokemonRepository;
import com.alea.pokemon.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/** DECISIONS
 *  Several things:
 *  - Using Hex Architecture I should split this 3 functions into its own class, since it is a fairly simple
 *    exercise, I decided to keep it here *possible improvement point
 *  - Using a common function (passing a Comparator as parameter) to reuse code
 *    -> this was discarded because of separation of concerns
 *  - Possible improvement: find a mathematical algorithm using other structures than a List to sort the top N
 *    pokemon more efficiently
 */

@AllArgsConstructor
@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository repository;
    private final PokemonMapper mapper;

    @Override
    public List<Pokemon> getHeaviestPokemon() {
        return getTop5ByField("weight");
    }

    @Override
    public List<Pokemon> getHighestPokemon() {
        return getTop5ByField("height");
    }

    @Override
    public List<Pokemon> getMostBaseXpPokemon() {
        return getTop5ByField("baseXp");
    }

    private List<Pokemon> getTop5ByField(String orderByField) {
        var pokemonList = switch (orderByField) {
            case "weight" -> repository.findTop5ByOrderByWeightDesc();
            case "height" -> repository.findTop5ByOrderByHeightDesc();
            case "baseXp" -> repository.findTop5ByOrderByBaseXpDesc();
            default -> throw new IllegalArgumentException("Invalid field for sorting: " + orderByField);
        };

        return pokemonList.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
