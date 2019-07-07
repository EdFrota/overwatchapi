package com.overwatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overwatch.api.model.Hero;

/**
 * Repository to deal with {@link Hero}
 * 
 * @author edmundofrota
 */
public interface HeroRepository extends JpaRepository<Hero, Integer> {

	/**
	 * Find {@link Hero} by name.
	 * 
	 * @param name hero name.
	 * @return {@link Hero} filtered by name.
	 */
	Hero findByName(String name);

}
