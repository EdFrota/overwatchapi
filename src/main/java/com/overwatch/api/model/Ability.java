package com.overwatch.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ability entity.
 * 
 * @author edmundofrota
 */
@Entity
@Table
public class Ability {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true, nullable = false)
	private String name;

	@Column(length = 3000, nullable = false)
	private String description;

	@Column(nullable = false)
	private boolean ultimate;
	
	@ManyToOne
	@JoinColumn(name = "hero_id", referencedColumnName = "id", nullable = false)
	private Hero hero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isUltimate() {
		return ultimate;
	}

	public void setUltimate(boolean ultimate) {
		this.ultimate = ultimate;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}
}
