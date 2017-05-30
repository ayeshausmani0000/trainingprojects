package com.dss.basicproject.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.dss.basicproject.model.ClientEntity;
import com.dss.basicproject.model.CountryEntity;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.model.SizeEntity;
import com.dss.basicproject.repository.ClientRepository;
import com.dss.basicproject.repository.CountryRepository;
import com.dss.basicproject.repository.SeasonRepository;
import com.dss.basicproject.repository.SizeRepository;
import com.dss.basicproject.service.MasterService;

public class MasterServiceImpl implements MasterService {
	@Autowired
	private SeasonRepository seasonRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private SizeRepository sizeRepository;

	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Iterable<SeasonEntity> findAllSeason() {
		// TODO Auto-generated method stub
		return seasonRepository.findAll();
	}

	@Override
	public Iterable<CountryEntity> findAllCountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public Iterable<ClientEntity> findAllClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public SeasonEntity findSeasonById(Integer id) {
		// TODO Auto-generated method stub
		return seasonRepository.findOne(id);
	}

	@Override
	public CountryEntity findCountryById(Integer id) {
		// TODO Auto-generated method stub
		return countryRepository.findOne(id);
	}

	@Override
	public ClientEntity findClientById(Integer id) {
		// TODO Auto-generated method stub
		return clientRepository.findOne(id);
	}

	@Override
	public Iterable<SizeEntity> findAllSize() {
		// TODO Auto-generated method stub
		return sizeRepository.findAll();
	}

	@Override
	public SizeEntity findSizeById(Integer id) {
		// TODO Auto-generated method stub
		return sizeRepository.findOne(id);
	}
	
	
}
