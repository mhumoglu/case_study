package com.example.case_study.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Airport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String airport_name;
	
	@OneToMany(mappedBy = "from_airport_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Route> from_airport_id= new HashSet<>();
	
    @OneToMany(mappedBy = "to_airport_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Route> to_airport_id= new HashSet<>();
    

	public Set<Route> getFrom_airport_id() {
		return from_airport_id;
	}
	public void setFrom_airport_id(Set<Route> from_airport_id) {
		this.from_airport_id = from_airport_id;
	}
	public Set<Route> getTo_airport_id() {
		return to_airport_id;
	}
	public void setTo_airport_id(Set<Route> to_airport_id) {
		this.to_airport_id = to_airport_id;
	}
	public String getAirport_name() {
		return airport_name;
	}
	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}
}