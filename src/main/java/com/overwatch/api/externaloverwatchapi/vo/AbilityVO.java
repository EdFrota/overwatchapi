package com.overwatch.api.externaloverwatchapi.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * View object to import Ability data from external source.
 * 
 * @author edmundofrota
 */
public class AbilityVO {

	private String name;

	private String description;
	
	private HeroSimpleVO hero;

	@JsonSetter("is_ultimate")
	private boolean ultimate;

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

	public HeroSimpleVO getHero() {
		return hero;
	}

	public void setHero(HeroSimpleVO hero) {
		this.hero = hero;
	}
}
