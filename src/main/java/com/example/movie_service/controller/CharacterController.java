package com.example.movie_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_service.model.Character;
import com.example.movie_service.service.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {
	@Autowired
	private CharacterService characterService;

	@GetMapping
	public List<Character> getAllCharacters() {
		return characterService.getAllCharacters();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
		Character character = characterService.getCharacterById(id);
		if (character != null) {
			return ResponseEntity.ok(character);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Character createCharacter(@RequestBody Character character) {
		return characterService.createCharacter(character);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character) {
		Character updatedCharacter = characterService.updateCharacter(id, character);
		if (updatedCharacter != null) {
			return ResponseEntity.ok(updatedCharacter);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
		characterService.deleteCharacter(id);
		return ResponseEntity.noContent().build();
	}
}