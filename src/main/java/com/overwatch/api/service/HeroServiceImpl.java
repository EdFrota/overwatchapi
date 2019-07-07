package com.overwatch.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overwatch.api.model.Hero;
import com.overwatch.api.repository.HeroRepository;

@Service
public class HeroServiceImpl implements HeroService {

	@Autowired
	private HeroRepository repository;
	
	@Override
	public List<Hero> findAllHeroes() {
		return repository.findAll();
	}

	@Override
	public Hero getHero(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Hero saveHero(Hero hero) {
		return repository.save(hero);
	}

	@Override
	public Hero getHeroByName(String name) {
		return repository.findByName(name);
	}

}
