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
import com.overwatch.api.model.vo.AbilityVO;
import com.overwatch.api.service.AbilityService;

@RestController
@RequestMapping("/api/v1/abilities")
public class AbilityRestController {

	private Log log = LogFactory.getLog(AbilityRestController.class);
	
	@Autowired
	private AbilityService abilityService;
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping(path = "/")
	public @ResponseBody ResponseEntity<List<AbilityVO>> getAbilities() {
		try {
			log.info("List all abilities.");
			List<Ability> abilities = abilityService.findAllAbilities();
			
			ResponseEntity<List<AbilityVO>> responseEntity;
			if (!abilities.isEmpty()) {
				List<AbilityVO> abilityVOs = new ArrayList<>(abilities.size());
				abilities.forEach(ability -> abilityVOs.add(convertToVo(ability)));
				
				log.info(String.format("Found %s abilities.", abilities.size()));
				responseEntity = new ResponseEntity<>(abilityVOs, HttpStatus.OK);
			} else {
				log.warn("No abilities found.");
				responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return responseEntity;
		} catch (Exception e) {
			log.error("Error to list all abilities.", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{abilityId}")
	public @ResponseBody ResponseEntity<AbilityVO> getAbility(@PathVariable int abilityId) {
		try {
			log.info("Find ability by id: " + abilityId);
			Ability ability = abilityService.getAbility(abilityId);
			
			ResponseEntity<AbilityVO> responseEntity;
			if (ability != null) {
				log.info(String.format("Ability name %s found.", ability.getName()));
				
				responseEntity = new ResponseEntity<>(convertToVo(ability), HttpStatus.OK);
			} else {
				log.warn(String.format("Ability id %s not found.", abilityId));
				responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return responseEntity;
		} catch (Exception e) {
			log.error("Error to find Ability filtering by id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private AbilityVO convertToVo(Ability ability) {
		return modelMapper.map(ability, AbilityVO.class);
	}
	
}
