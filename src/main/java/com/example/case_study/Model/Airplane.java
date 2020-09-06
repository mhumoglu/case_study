package com.example.case_study.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Airplane {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	@OneToMany(mappedBy = "airplane_id")
	@JsonIgnore
	private Set<Fly> airplane_id = new HashSet<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String airplane_name;
	
	
	public String getAirplane_name() {
		return airplane_name;
	}
	public void setAirplane_name(String airplane_name) {
		this.airplane_name = airplane_name;
	}
	public Set<Fly> getAirplane_id() {
		return airplane_id;
	}
	public void setAirplane_id(Set<Fly> airplane_id) {
		this.airplane_id = airplane_id;
	}
	
}