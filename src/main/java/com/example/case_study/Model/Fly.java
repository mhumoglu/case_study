package com.example.case_study.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Fly {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private int id;

	private String fly_date;
    private double money;
    private int quota;
    private int remaining_quota;
    
    public Fly() {}
	
	public int getRemaining_quota() {
		return remaining_quota;
	}
	public void setRemaining_quota(int remaining_quota) {
		this.remaining_quota = remaining_quota;
	}
	public Set<Fly> getFly_id() {
		return fly_id;
	}
	public void setFly_id(Set<Fly> fly_id) {
		this.fly_id = fly_id;
	}
	public int getQuota() {
		return quota;
	}
	public void setQuota(int quota) {
		this.quota = quota;
		this.remaining_quota=quota;
	}
	@ManyToOne
	@JoinColumn(name="airplane_id", nullable=false)
	private Airplane airplane_id;
	
	@ManyToOne
    @JoinColumn(name="route_id", nullable=false)
    private Route route_id;
	
    @OneToMany(mappedBy = "fly_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Fly> fly_id= new HashSet<>();
	
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


	public String getFly_date() {
		return fly_date;
	}
 	public void setFly_date() {
		LocalDateTime localDateTime = LocalDateTime.now();
		this.fly_date = localDateTime.toString();
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