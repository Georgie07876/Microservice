package com.example.movie_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_service.model.Character;
import com.example.movie_service.repository.CharacterRepository;

@Service
public class CharacterService {
	@Autowired
	private CharacterRepository characterRepository;

	public List<Character> getAllCharacters() {
		return characterRepository.findAll();
	}

	public Character getCharacterById(Long id) {
		return characterRepository.findById(id).orElse(null);
	}

	public Character createCharacter(Character character) {
		return characterRepository.save(character);
	}

	public Character updateCharacter(Long id, Character character) {
		character.setId(id);
		return characterRepository.save(character);
	}

	public void deleteCharacter(Long id) {
		characterRepository.deleteById(id);
	}
}