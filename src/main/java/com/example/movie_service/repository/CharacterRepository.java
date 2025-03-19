package com.example.movie_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie_service.model.Character;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}