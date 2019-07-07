package com.overwatch.api.externaloverwatchapi.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * View object to import Hero paginated list data from external source.
 * 
 * @author edmundofrota
 */
public class ListHeroVO {

	private int total;

	@JsonSetter("next")
	private String nextPage;

	@JsonSetter("data")
	private List<HeroVO> heroVOs;

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

	public List<HeroVO> getHeroVOs() {
		return heroVOs;
	}

	public void setHeroVOs(List<HeroVO> heroVOs) {
		this.heroVOs = heroVOs;
	}

}
