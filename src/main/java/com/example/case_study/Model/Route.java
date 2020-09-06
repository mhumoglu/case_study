package com.example.case_study.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
    private int id;
	
	@ManyToOne
    @JoinColumn(name="from_airport_id", nullable=false)
    private Airport from_airport_id;
	
	@ManyToOne
	@JoinColumn(name="to_airport_id", nullable=false)
	private Airport to_airport_id;
	
	@OneToMany(mappedBy = "route_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Fly> route_id= new HashSet<>();
	
	public Set<Fly> getRoute_id() {
		return route_id;
	}
	public void setRoute_id(Set<Fly> route_id) {
		this.route_id = route_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Airport getFrom_airport_id() {
		return from_airport_id;
	}
	public void setFrom_airport_id(Airport from_airport_id) {
		this.from_airport_id = from_airport_id;
	}
	public Airport getTo_airport_id() {
		return to_airport_id;
	}
	public void setTo_airport_id(Airport to_airport_id) {
		this.to_airport_id = to_airport_id;
	}
	
	
}