package com.overwatch.api.service;

import java.util.List;

import com.overwatch.api.model.Hero;

public interface HeroService {

	List<Hero> findAllHeroes();
	
	Hero getHero(int id);
	
	Hero saveHero(Hero hero);

	Hero getHeroByName(String name);
}
