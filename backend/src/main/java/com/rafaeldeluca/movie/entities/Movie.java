package com.rafaeldeluca.movie.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="tb_movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	
	@OneToMany(mappedBy = "id.movie")
	private Set<Score> scores = new HashSet<>();

	@ManyToOne
	@JoinColumn(name="genre_id")
	private Genre genre;

	public Movie() {
		
	}
	
	public Movie(Long id, String title, Double score, Integer count, String image) {
		super();
		this.id = id;
		this.title = title;
		this.score = score;
		this.count = count;
		this.image = image;
	}

	public Movie(Long id, String title, Double score, Integer count, String image, Genre genre) {
		this.id = id;
		this.title = title;
		this.score = score;
		this.count = count;
		this.image = image;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	//Método para buscar os scores de um determinado filme e depois recalcular a media do score
	// um filme pode ter várias avaliações
	//id = chave do score
	//movie = atributo do ScorePK

	public Set<Score> getScores() {
		return scores;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
