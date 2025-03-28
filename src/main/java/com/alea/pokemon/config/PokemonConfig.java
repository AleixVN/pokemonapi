package com.alea.pokemon.config;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PokemonConfig {

    @Bean
    public PokeApi pokeApi() {
        return new PokeApiClient();
    }

}
