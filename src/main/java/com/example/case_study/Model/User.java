package com.example.case_study.Model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	private String name;	
	@OneToMany(mappedBy = "id" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Ticket> ticket_id= new HashSet<>();
	
	public Set<Ticket> getTicket_id() {
		return ticket_id;
	}


	public void setTicket_id(Set<Ticket> ticket_id) {
		this.ticket_id = ticket_id;
	}


	public User(String name)
	{
		this.name=name;
	}
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}