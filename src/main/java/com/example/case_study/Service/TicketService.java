package com.example.case_study.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.case_study.Model.Fly;
import com.example.case_study.Model.Route;
import com.example.case_study.Model.Ticket;
import com.example.case_study.Repository.FlyRepository;
import com.example.case_study.Repository.RouteRepository;
import com.example.case_study.Repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	FlyRepository flyRepository;

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        ticketRepository.findAll().forEach(ticket -> tickets.add(ticket));
        return tickets;
    }

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).get();
    }

    public void buyTicket(Ticket ticket) {
    	Fly dummy_fly= ticket.getFly_id();
    	dummy_fly.setRemaining_quota(dummy_fly.getRemaining_quota()-1);
    	int quato=dummy_fly.getQuota();
    	int Remaining_quota=dummy_fly.getRemaining_quota();
    	if(quato-quato/10==Remaining_quota)
    	{
    		double money=dummy_fly.getMoney();
    		dummy_fly.setQuota(Remaining_quota);
    		dummy_fly.setMoney((money+money/10));
    		
    	}
    	flyRepository.save(dummy_fly);
    	ticketRepository.save(ticket);
    }

    public void delete(int id) {
    	ticketRepository.deleteById(id);
    }

}
