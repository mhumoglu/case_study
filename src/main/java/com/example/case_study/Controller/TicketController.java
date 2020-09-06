package com.example.case_study.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.case_study.Model.Airplane;
import com.example.case_study.Model.Airport;
import com.example.case_study.Model.Ticket;
import com.example.case_study.Service.AirplaneService;
import com.example.case_study.Service.FlyService;
import com.example.case_study.Service.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@Autowired
	FlyService flyService;
	
	@PostMapping("/buyTicket")
	public ResponseEntity<Ticket> buyTicket(@RequestBody  String data) throws ParseException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
    	JsonNode rootNode = objectMapper.readTree(data);
    	JsonNode credit_number = rootNode.path("credit_number");
    	JsonNode fly_id = rootNode.path("fly_id");
		Ticket tk=new Ticket(credit_number.asText());
		tk.setFly_id(flyService.getFlyById(fly_id.asInt()));
		ticketService.buyTicket(tk);
		return new ResponseEntity<Ticket>(tk, HttpStatus.OK);
	}
	@GetMapping("/getTicket/{ticketid}")
	public ResponseEntity<Ticket> getTicket(@PathVariable String ticketid) {
		return new ResponseEntity<Ticket>(ticketService.getTicketById(Integer.parseInt(ticketid)), HttpStatus.OK);
	}
	
	@GetMapping("/delTicket/{ticketid}")
	public ResponseEntity<String> delTicket(@PathVariable String ticketid) {
		ticketService.delete(Integer.parseInt(ticketid));
		return new ResponseEntity<>("Deleted!!", HttpStatus.OK);
	}
	
}
