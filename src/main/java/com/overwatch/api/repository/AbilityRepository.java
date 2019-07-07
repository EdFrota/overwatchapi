package com.overwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overwatch.api.model.Ability;

/**
 * Repository to deal with {@link Ability}
 * 
 * @author edmundofrota
 */
public interface AbilityRepository extends JpaRepository<Ability, Integer> {

	/**
	 * Find list of {@link Ability} filtered by hero id.
	 * 
	 * @param heroId {@link Hero} id
	 * @return List of {@link Ability} filtered by hero id.
	 */
	List<Ability> findByHeroId(int heroId);

}
