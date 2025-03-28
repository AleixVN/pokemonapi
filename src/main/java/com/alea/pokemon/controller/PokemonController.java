package com.alea.pokemon.controller;


import com.alea.pokemon.dto.HeaviestPokemonResponse;
import com.alea.pokemon.dto.HighestPokemonResponse;
import com.alea.pokemon.dto.MostBaseXpPokemonResponse;
import com.alea.pokemon.mapper.HeaviestPokemonMapper;
import com.alea.pokemon.mapper.HighestPokemonMapper;
import com.alea.pokemon.mapper.MostBaseXpPokemonMapper;
import com.alea.pokemon.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService service;
    private final HeaviestPokemonMapper heaviestPokemonMapper;
    private final HighestPokemonMapper highestPokemonMapper;
    private final MostBaseXpPokemonMapper mostBaseXpPokemonMapper;

    @GetMapping(value = "/heaviest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HeaviestPokemonResponse> getHeaviestPokemon() {
        var pokemonList = service.getHeaviestPokemon();

        return ResponseEntity.ok(heaviestPokemonMapper.toHeaviestPokemonResponse(pokemonList));
    }

    @GetMapping(value = "/highest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HighestPokemonResponse> getHighestPokemon() {
        var pokemonList = service.getHighestPokemon();

        return ResponseEntity.ok(highestPokemonMapper.toHighestPokemonResponse(pokemonList));
    }

    @GetMapping(value = "/most-base-xp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MostBaseXpPokemonResponse> getMostBaseXpPokemon() {
        var pokemonList = service.getMostBaseXpPokemon();

        System.out.println("Filtered!");

        return ResponseEntity.ok(mostBaseXpPokemonMapper.toMostBaseXpPokemonResponse(pokemonList));
    }

}
