package com.example.case_study.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;

@Entity
public class Fly {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private int id;

	private Date fly_date;
    private double money;
    
	@ManyToOne
	@JoinColumn(name="airplane_id", nullable=false)
	private Airplane airplane_id;
	
	@ManyToOne
    @JoinColumn(name="route_id", nullable=false)
    private Route route_id;
	
	public Route getRoute_id() {
		return route_id;
	}
	public void setRoute_id(Route route_id) {
		this.route_id = route_id;
	}
	public Airplane getAirplane_id() {
		return airplane_id;
	}
	public void setAirplane_id(Airplane airplane_id) {
		this.airplane_id = airplane_id;
	}


	public Date getFly_date() {
		return fly_date;
	}
	public void setFly_date(Date fly_date) {
		this.fly_date = fly_date;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}