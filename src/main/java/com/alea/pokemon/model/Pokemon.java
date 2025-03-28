package com.alea.pokemon.model;

import lombok.Builder;

@Builder
public record Pokemon(
        String name,
        Integer weight,
        Integer height,
        Integer baseXp) {}
