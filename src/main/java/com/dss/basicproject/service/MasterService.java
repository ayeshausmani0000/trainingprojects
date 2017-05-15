package com.dss.basicproject.service;

import com.dss.basicproject.model.ClientEntity;
import com.dss.basicproject.model.CountryEntity;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.model.SizeEntity;

public interface MasterService {
	public Iterable<SeasonEntity> findAllSeason();

	public Iterable<CountryEntity> findAllCountry();

	public Iterable<ClientEntity> findAllClient();
	
	public Iterable<SizeEntity> findAllSize();

	public SeasonEntity findSeasonById(Integer id);

	public CountryEntity findCountryById(Integer id);

	public ClientEntity findClientById(Integer id);
	
	public SizeEntity findSizeById(Integer id);

}
