package com.alea.pokemon.testbuilder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PokeApiPokemonTestBuilder {

    public static Pokemon pikachu() {
        return  new Pokemon(1, "Pikachu", 100, 40, true, 1, 60,
                new NamedApiResource("", "", 1), List.of(), List.of(), List.of(), List.of(),
                List.of(), List.of(), List.of(), new PokemonSprites(null, null, null,
                null, null, null, null, null));
    }

    public static Pokemon bulbasaur() {
        return  new Pokemon(2, "Bulbasaur", 120, 50, true, 1, 70,
                new NamedApiResource("", "", 1), List.of(), List.of(), List.of(), List.of(),
                List.of(), List.of(), List.of(), new PokemonSprites(null, null, null,
                null, null, null, null, null));
    }

    public static Pokemon charmander() {
        return  new Pokemon(3, "Charmander", 140, 40, true, 1, 20,
                new NamedApiResource("", "", 1), List.of(), List.of(), List.of(), List.of(),
                List.of(), List.of(), List.of(), new PokemonSprites(null, null, null,
                null, null, null, null, null));
    }

}
