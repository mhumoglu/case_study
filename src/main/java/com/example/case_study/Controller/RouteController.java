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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.case_study.Model.Airport;
import com.example.case_study.Model.Route;
import com.example.case_study.Service.RouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.case_study.Service.AirportService;

@RestController
public class RouteController {

	@Autowired
	RouteService routeService;
	
	@Autowired
	AirportService airportService;
	
	
	@PostMapping("/addRoute")
	public ResponseEntity<Route> addRoute(@RequestBody  String data) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
    	JsonNode rootNode = objectMapper.readTree(data);
    	JsonNode to_airport = rootNode.path("to_airport");
    	JsonNode from_airport = rootNode.path("from_airport");
		Route rt=new Route();
		rt.setTo_airport_id(airportService.getAirportByName(to_airport.asText()));
		rt.setFrom_airport_id(airportService.getAirportByName(from_airport.asText()));
		routeService.saveOrUpdate(rt);
		return new ResponseEntity<>(rt, HttpStatus.OK);
	}
	
	@GetMapping("/getRoute/")
	public ResponseEntity<Route> getRoute(@PathParam(value = "data")  String data) {
		return new ResponseEntity<Route>(routeService.getRouteByName(data.split("-")[0],data.split("-")[1]), HttpStatus.OK);
	}
	
	@GetMapping("/getFromRoute/{from_airport}")
	public ResponseEntity<Route> getFromRoute(@PathVariable("from_airport") String from_airport) {
		return new ResponseEntity<Route>(routeService.getFromRouteByName(from_airport), HttpStatus.OK);
	}
	@GetMapping("/getToRoute/{to_airport}")
	public ResponseEntity<Route> getToRoute(@PathVariable("to_airport") String to_airport) {
		return new ResponseEntity<Route>(routeService.getToRouteByName(to_airport), HttpStatus.OK);
	}
	
	@GetMapping("/getAllRoute")
	public ResponseEntity<List<Route>> getAllRoute() {
		return new ResponseEntity<>(routeService.getAllRoutes(), HttpStatus.OK);
	}
}
