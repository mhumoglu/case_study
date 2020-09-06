package com.example.case_study.Controller;

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
import com.example.case_study.Service.AirplaneService;

@RestController
public class AirplaneController {
	
	@Autowired
	AirplaneService airplaneService;
	
	@PostMapping("/addAirplane")
	public ResponseEntity<Airplane> addAirplane(@RequestBody Airplane airplane) {
		airplaneService.saveOrUpdate(airplane);
		return new ResponseEntity<Airplane>(airplane, HttpStatus.OK);
	}
	@GetMapping("/getAirplane/{name}")
	public ResponseEntity<Airplane> getAirplane(@PathVariable String name) {
		return new ResponseEntity<Airplane>(airplaneService.getAirportByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/getAllAirplane")
	public ResponseEntity<List<Airplane>> getAllAirPlane() {
		return new ResponseEntity<>(airplaneService.getAllAirplane(), HttpStatus.OK);
	}
}
