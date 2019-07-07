package com.overwatch.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overwatch.api.model.Ability;
import com.overwatch.api.model.Hero;
import com.overwatch.api.repository.AbilityRepository;

@Service
public class AbilityServiceImpl implements AbilityService {

	@Autowired
	private AbilityRepository repository;
	@Autowired
	private HeroService heroService;

	@Override
	public List<Ability> findAllAbilities() {
		return repository.findAll();
	}

	@Override
	public Ability getAbility(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Ability saveAbility(Ability ability) {
		Hero foundHero = heroService.getHeroByName(ability.getHero().getName());
		ability.setHero(foundHero);
		return repository.save(ability);
	}

	@Override
	public List<Ability> getAbilitiesByHeroId(int heroId) {
		return repository.findByHeroId(heroId);
	}
	
}
