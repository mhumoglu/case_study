package com.example.case_study.Model;

import javax.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private int id;
	private String created_date;
	private String card_number;
	
	@ManyToOne
    @JoinColumn(name="fly_id", nullable=false)
    private Fly fly_id;

public Ticket() {
	
}

	public Fly getFly_id() {
		return fly_id;
	}

	public void setFly_id(Fly fly_id) {
		this.fly_id = fly_id;
	}

	public Ticket(String card_number) throws ParseException {
		String tmp=card_number.replaceAll("[^a-zA-Z0-9]", "");
		LocalDateTime localDateTime = LocalDateTime.now();
		this.created_date= localDateTime.toString();
		this.card_number=tmp.substring(0,6)+"******"+tmp.substring(12);
	}
	
    public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

   
    public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		LocalDateTime localDateTime = LocalDateTime.now();
		this.created_date = localDateTime.toString();
	}
	
}