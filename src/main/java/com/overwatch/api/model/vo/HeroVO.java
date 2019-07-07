package com.overwatch.api.model.vo;

import com.overwatch.api.model.Hero;

/**
 * View object to retrieve {@link Hero} data from the API.
 * 
 * @author edmundofrota
 */
public class HeroVO {

	private int id;
	
	private String name;

	private String description;

	private Integer health;

	private Integer armour;

	private Integer shield;

	private String realName;

	private Integer age;

	private Integer height;

	private String affiliation;

	private String baseOperations;

	private Integer difficulty;

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

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Integer getArmour() {
		return armour;
	}

	public void setArmour(Integer armour) {
		this.armour = armour;
	}

	public Integer getShield() {
		return shield;
	}

	public void setShield(Integer shield) {
		this.shield = shield;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public String getBaseOperations() {
		return baseOperations;
	}

	public void setBaseOperations(String baseOperations) {
		this.baseOperations = baseOperations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
