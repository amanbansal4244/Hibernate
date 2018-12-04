
package com.aman;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
	
	/****
	 * If ID is auto generated, its setter method should be private.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "MOVIE_ID")
	private Long id;
	
	@Column(name = "MOVIE_NAME")
	private String name;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(
            		name="Movie_Actor_Relationship",
            		joinColumns={@JoinColumn(name="movie_id")},
            		inverseJoinColumns={@JoinColumn(name="actor_id")}
    	)	
	private Set<Actor> actors = new HashSet<Actor>();	
	
	/****
	 * We must add a no argument constructor to the POJO class. When an entity is loaded from the database,
	 *  no argument constructor is called by the hibernate API.
	 */
	public Movie() {}
	
	public Movie(String name) {
		this.name = name;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}
	
}




