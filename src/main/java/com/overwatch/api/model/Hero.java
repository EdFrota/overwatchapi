package com.overwatch.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hero entity.
 * 
 * @author edmundofrota
 */
@Entity
@Table
public class Hero {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true, nullable = false)
	private String name;

	@Column(length = 3000)
	private String description;

	@Column(nullable = false)
	private Integer health;

	@Column(nullable = false)
	private Integer armour;

	@Column(nullable = false)
	private Integer shield;

	@Column(nullable = false)
	private String realName;

	@Column
	private Integer age;

	@Column
	private Integer height;

	@Column
	private String affiliation;

	@Column
	private String baseOperations;

	@Column
	private Integer difficulty;
	
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

	public String getBaseOperations() {
		return baseOperations;
	}

	public void setBaseOperations(String baseOperations) {
		this.baseOperations = baseOperations;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

}
