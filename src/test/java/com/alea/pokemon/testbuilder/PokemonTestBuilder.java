package com.alea.pokemon.testbuilder;

import com.alea.pokemon.model.Pokemon;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PokemonTestBuilder {

    public static Pokemon PIKACHU = pikachu().build();
    public static Pokemon BULBASAUR = bulbasaur().build();

    public static Pokemon.PokemonBuilder pikachu() {
        return Pokemon.builder()
                .name("Pikachu")
                .weight(60)
                .height(40)
                .baseXp(100);
    }

    public static Pokemon.PokemonBuilder bulbasaur() {
        return Pokemon.builder()
                .name("Bulbasaur")
                .weight(70)
                .height(50)
                .baseXp(120);
    }
}
