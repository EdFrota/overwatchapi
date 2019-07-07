package com.overwatch.api.model.vo;

import com.overwatch.api.model.Ability;

/**
 * View object to retrieve {@link Ability} data from the API.
 * 
 * @author edmundofrota
 */
public class AbilityVO {

	private int id;
	
	private String name;

	private String description;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
