package com.dss.basicproject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "BASICSEQ", allocationSize = 1)
@Table(name = "style")
public class StyleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BASICSEQ")
	@Column(name = "style_id")
	private Integer id;

	@Column(name = "style_no")
	private String styleNo;

	@Column(name = "style_desc")
	private String desc;

	@ManyToOne
	@JoinColumn(name = "season_id")
	private SeasonEntity season;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private CountryEntity country;

	@OneToMany(mappedBy = "style", cascade = CascadeType.REMOVE,fetch=FetchType.EAGER)
	private Set<ItemEntity> items;

	@ManyToOne
	@JoinColumn(name="client_id")
	private ClientEntity client;

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public Set<ItemEntity> getItems() {
		return items;
	}

	public void setItems(Set<ItemEntity> items) {
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStyleNo() {
		return styleNo;
	}

	public void setStyleNo(String styleNo) {
		this.styleNo = styleNo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public SeasonEntity getSeason() {
		return season;
	}

	public void setSeason(SeasonEntity seasonId) {
		this.season = seasonId;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity countryid) {
		this.country = countryid;
	}

}