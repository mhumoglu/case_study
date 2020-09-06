package com.example.case_study.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.case_study.Model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {}
