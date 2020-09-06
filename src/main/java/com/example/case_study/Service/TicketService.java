package com.example.case_study.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.case_study.Model.Route;
import com.example.case_study.Model.Ticket;
import com.example.case_study.Repository.RouteRepository;
import com.example.case_study.Repository.TicketRepository;

public class TicketService {
	@Autowired
	TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        ticketRepository.findAll().forEach(ticket -> tickets.add(ticket));
        return tickets;
    }

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).get();
    }

    public void saveOrUpdate(Ticket ticket) {
    	ticketRepository.save(ticket);
    }

    public void delete(int id) {
    	ticketRepository.deleteById(id);
    }

}
