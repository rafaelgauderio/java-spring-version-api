package com.rafaeldeluca.movie.controllers;

import com.rafaeldeluca.movie.entities.dto.MovieDTO;
import com.rafaeldeluca.movie.entities.dto.MovieGenreDTO;
import com.rafaeldeluca.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;



@RestController
@RequestMapping(value = "v1/movies")
public class MovieControllerV1 {
	
	@Autowired
	private MovieService service;

	@GetMapping
	public Page<MovieGenreDTO> findAll(Pageable pageable) {
		return service.findAllWithGenre(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public MovieGenreDTO findById(@PathVariable Long id) {
		return service.findByIdWithGenre(id);
	}

	@PostMapping
	public ResponseEntity<MovieGenreDTO> insert(@RequestBody MovieGenreDTO movieGenreDTO) {
		movieGenreDTO = service.insertWithGenre(movieGenreDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movieGenreDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(movieGenreDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> update (@RequestBody MovieDTO movieDTO,@PathVariable Long id) {
		movieDTO = service.update(movieDTO, id);
		return ResponseEntity.ok().body(movieDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> delete (@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
