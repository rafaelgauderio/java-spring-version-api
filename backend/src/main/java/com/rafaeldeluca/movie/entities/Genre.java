package com.rafaeldeluca.movie.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_genre")
public class Genre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Movie> movies = new ArrayList<Movie>();

    public Genre () {

    }

    public Genre (Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId () {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
