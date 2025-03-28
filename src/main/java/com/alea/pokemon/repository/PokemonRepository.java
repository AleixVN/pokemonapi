package com.alea.pokemon.repository;

import com.alea.pokemon.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {

    List<PokemonEntity> findTop5ByOrderByWeightDesc();

    List<PokemonEntity> findTop5ByOrderByHeightDesc();

    List<PokemonEntity> findTop5ByOrderByBaseXpDesc();
}
