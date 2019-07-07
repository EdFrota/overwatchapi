package com.overwatch.api.externaloverwatchapi;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.overwatch.api.externaloverwatchapi.vo.AbilityVO;
import com.overwatch.api.externaloverwatchapi.vo.HeroVO;
import com.overwatch.api.externaloverwatchapi.vo.ListAbilityVO;
import com.overwatch.api.externaloverwatchapi.vo.ListHeroVO;
import com.overwatch.api.model.Ability;
import com.overwatch.api.model.Hero;
import com.overwatch.api.service.AbilityService;
import com.overwatch.api.service.HeroService;

/**
 * Import from external source Heroes and Abilities data.
 * 
 * @author edmundofrota
 */
@Component
public class ImportOverwatchData {

	private Log log = LogFactory.getLog(ImportOverwatchData.class);
	
	@Autowired
    private ModelMapper modelMapper;
	@Autowired
	private HeroService heroService;
	@Autowired
	private AbilityService abilityService;
	
	@Value("${external.overwatchapi.user-agent}")
	private String userAgent;
	
	private static final String ENDPOINT_LIST_HERO = "https://overwatch-api.net/api/v1/hero/";
	private static final String ENDPOINT_LIST_ABILITY = "https://overwatch-api.net/api/v1/ability/";
	
	@PostConstruct
	public void importData() {
		log.info("Importing data from external overwatch API");
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");
		httpHeaders.add("User-Agent", userAgent);
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			log.info("Importing Hero data...");
			requestHero(restTemplate, httpHeaders);
			log.info("Import of Hero data done.");
		} catch (Exception e) {
			log.error("Error to import Hero data", e);
		}
		
		try {
			log.info("Importing Ability data...");
			requestAbility(restTemplate, httpHeaders, 1);
			log.info("Import of Ability data done.");
		} catch (Exception e) {
			log.error("Error to import Ability data", e);
		}
		
		log.info("Import done.");
	}
	
	/**
	 * Request to external source Hero data.
	 * 
	 * @param restTemplate
	 * @param httpHeaders
	 */
	private void requestHero(RestTemplate restTemplate, HttpHeaders httpHeaders) {
		ResponseEntity<ListHeroVO> response = restTemplate.exchange(
				ENDPOINT_LIST_HERO, HttpMethod.GET, new HttpEntity<>(httpHeaders), ListHeroVO.class);
		
		ListHeroVO listHeroVO = response.getBody();
		
		if (listHeroVO != null) {
			createUpdateHero(listHeroVO);
			
			if (StringUtils.isNotBlank(listHeroVO.getNextPage())) {
				requestHero(restTemplate, httpHeaders);
			}
		}
	}
	
	/**
	 * Request to external source Ability data.
	 * 
	 * @param restTemplate
	 * @param httpHeaders
	 */
	private void createUpdateHero(ListHeroVO heroVOs) {
		heroVOs.getHeroVOs().forEach(heroVO -> heroService.saveHero(convertToEntity(heroVO)));
	}
	
	/**
	 * 
	 * @param restTemplate
	 * @param httpHeaders
	 * @param page
	 */
	private void requestAbility(RestTemplate restTemplate, HttpHeaders httpHeaders, int page) {
		ResponseEntity<ListAbilityVO> response = restTemplate.exchange(
				String.format("%s?page=%s", ENDPOINT_LIST_ABILITY, page), HttpMethod.GET, 
				new HttpEntity<>(httpHeaders), ListAbilityVO.class);
		
		ListAbilityVO listAbilityVO = response.getBody();
		
		if (listAbilityVO != null) {
			createUpdateAbility(listAbilityVO);
			
			if (StringUtils.isNotBlank(listAbilityVO.getNextPage())) {
				requestAbility(restTemplate, httpHeaders, ++page);
			}
		}
	}
	
	/**
	 * Store on DB the collected Abilities.
	 * 
	 * @param abilityVOs {@link ListHeroVO} containing the data to be stored.
	 */
	private void createUpdateAbility(ListAbilityVO abilityVOs) {
		abilityVOs.getAbilityVOs().forEach(abilityVO -> abilityService.saveAbility(convertToEntity(abilityVO)));
	}
	
	private Hero convertToEntity(HeroVO heroVO) {
		return modelMapper.map(heroVO, Hero.class);
	}
	
	private Ability convertToEntity(AbilityVO abilityVO) {
		return modelMapper.map(abilityVO, Ability.class);
	}
}
