package com.example.case_study.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.case_study.Model.Airport;
import com.example.case_study.Service.AirportService;

@RestController
public class AirportController {
	
	@Autowired
	AirportService airportService;
	
	@PostMapping("/addAirport")
	public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
		airportService.saveOrUpdate(airport);
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
	}
	@GetMapping("/getAirport/{name}")
	public ResponseEntity<Airport> getAirport(@PathVariable String name) {
		return new ResponseEntity<Airport>(airportService.getAirportByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/getAllAirport")
	public ResponseEntity<List<Airport>> getAllAirport() {
		return new ResponseEntity<>(airportService.getAllAirports(), HttpStatus.OK);
	}
}
