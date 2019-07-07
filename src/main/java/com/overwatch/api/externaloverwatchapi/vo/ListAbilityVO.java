package com.overwatch.api.externaloverwatchapi.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * View object to import Ability paginated list data from external source.
 * 
 * @author edmundofrota
 */
public class ListAbilityVO {

	private int total;

	@JsonSetter("next")
	private String nextPage;

	@JsonSetter("data")
	private List<AbilityVO> abilityVOs;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public List<AbilityVO> getAbilityVOs() {
		return abilityVOs;
	}

	public void setAbilityVOs(List<AbilityVO> abilityVOs) {
		this.abilityVOs = abilityVOs;
	}

}
