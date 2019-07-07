package com.overwatch.api.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.overwatch.api.model.Ability;
import com.overwatch.api.model.Hero;
import com.overwatch.api.model.vo.AbilityVO;
import com.overwatch.api.model.vo.HeroVO;
import com.overwatch.api.service.AbilityService;
import com.overwatch.api.service.HeroService;

@RestController
@RequestMapping("/api/v1/heros")
public class HeroRestController {

	private Log log = LogFactory.getLog(HeroRestController.class);
	
	@Autowired
	private HeroService heroService;
	@Autowired
	private AbilityService abilityService;
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping(path = "/")
	public @ResponseBody ResponseEntity<List<HeroVO>> getHeros() {
		try {
			log.info("List all heroes.");
			List<Hero> heroes = heroService.findAllHeroes();
			
			ResponseEntity<List<HeroVO>> responseEntity;
			if (!heroes.isEmpty()) {
				List<HeroVO> heroVOs = new ArrayList<>(heroes.size());
				heroes.forEach(hero -> heroVOs.add(convertToVo(hero)));
				
				log.info(String.format("Found %s heroes.", heroes.size()));
				responseEntity = new ResponseEntity<>(heroVOs, HttpStatus.OK);
			} else {
				log.warn("No heroes found.");
				responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{heroId}")
	public @ResponseBody ResponseEntity<HeroVO> getHero(@PathVariable int heroId) {
		try {
			log.info("Find hero by id: " + heroId);
			Hero hero = heroService.getHero(heroId);
			
			ResponseEntity<HeroVO> responseEntity;
			if (hero != null) {
				log.info(String.format("Hero name %s found.", hero.getName()));
				
				responseEntity = new ResponseEntity<>(convertToVo(hero), HttpStatus.OK);
			} else {
				log.warn(String.format("Hero id %s not found.", heroId));
				
				responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return responseEntity;
		} catch (Exception e) {
			log.error("Error to find Hero filtering by id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{heroId}/abilities")
	public @ResponseBody ResponseEntity<List<AbilityVO>> getHeroAbilities(@PathVariable int heroId) {
		try {
			log.info("List hero abilities, hero id: " + heroId);
			List<Ability> abilities = abilityService.getAbilitiesByHeroId(heroId);
			
			ResponseEntity<List<AbilityVO>> responseEntity;
			if (!abilities.isEmpty()) {
				List<AbilityVO> abilityVOs = new ArrayList<>(abilities.size());
				abilities.forEach(ability -> abilityVOs.add(convertToVo(ability)));
				log.info(String.format("Found %s abilities.", abilities.size()));
				
				responseEntity = new ResponseEntity<>(abilityVOs, HttpStatus.OK);
			} else {
				log.warn(String.format("Hero id %s, abilities not found.", heroId));
				
				responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return responseEntity;
		} catch (Exception e) {
			log.error("Error to list Hero abilities.", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private HeroVO convertToVo(Hero hero) {
		return modelMapper.map(hero, HeroVO.class);
	}
	
	private AbilityVO convertToVo(Ability ability) {
		return modelMapper.map(ability, AbilityVO.class);
	}
	
}
