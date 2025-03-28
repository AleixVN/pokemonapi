package com.alea.pokemon.testbuilder;

import com.alea.pokemon.model.PokemonEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PokemonEntityTestBuilder {

    public static PokemonEntity PIKACHU = pikachu().build();
    public static PokemonEntity BULBASAUR = bulbasaur().build();
    public static PokemonEntity CHARMANDER = charmander().build();

    public static PokemonEntity.PokemonEntityBuilder pikachu() {
        return PokemonEntity.builder()
                .id(1)
                .name("Pikachu")
                .weight(60)
                .height(40)
                .baseXp(100);
    }

    public static PokemonEntity.PokemonEntityBuilder bulbasaur() {
        return PokemonEntity.builder()
                .id(2)
                .name("Bulbasaur")
                .weight(70)
                .height(50)
                .baseXp(120);
    }

    public static PokemonEntity.PokemonEntityBuilder charmander() {
        return PokemonEntity.builder()
                .id(3)
                .name("Charmander")
                .weight(40)
                .height(20)
                .baseXp(140);
    }

}
