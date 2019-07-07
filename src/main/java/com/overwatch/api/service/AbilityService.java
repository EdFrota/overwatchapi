package com.overwatch.api.service;

import java.util.List;

import com.overwatch.api.model.Ability;
import com.overwatch.api.model.Hero;

/**
 * Service to deal with {@link Ability}.
 * 
 * @author edmundofrota
 */
public interface AbilityService {

	/**
	 * Find all abilities.
	 * 
	 * @return list of all abilities.
	 */
	List<Ability> findAllAbilities();
	
	/**
	 * Find ability filtered by id.
	 * 
	 * @param id ability id.
	 * @return {@link Ability} filtered by id.
	 */
	Ability getAbility(int id);
	
	/**
	 * Save ability.
	 * 
	 * @param ability to be saved.
	 * @return Saved {@link Ability}
	 */
	Ability saveAbility(Ability ability);

	/**
	 * Find abilities filtered by hero id.
	 * @param heroId {@link Hero} id
	 * @return List of {@link Ability} filtered by hero id.
 	 */
	List<Ability> getAbilitiesByHeroId(int heroId);
}
