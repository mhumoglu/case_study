package com.example.case_study.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.case_study.Model.Airplane;
import com.example.case_study.Model.Fly;
import com.example.case_study.Model.Route;
import com.example.case_study.Service.AirplaneService;
import com.example.case_study.Service.AirportService;
import com.example.case_study.Service.FlyService;
import com.example.case_study.Service.RouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FlyController {
	@Autowired
	FlyService flyService;
	
	@Autowired
	AirplaneService airplaneService;
	
	@Autowired
	AirportService airportService;
	
	@Autowired
	RouteService routeService;
	
	
	@PostMapping("/addFly")
	public ResponseEntity<Fly> addFly(@RequestBody  String data) throws JsonMappingException, JsonProcessingException, ParseException {
		ObjectMapper objectMapper = new ObjectMapper();
    	JsonNode rootNode = objectMapper.readTree(data);
    	JsonNode airplane_name = rootNode.path("airplane_name");
    	JsonNode from_airport = rootNode.path("from_airport");
    	JsonNode to_airport = rootNode.path("to_airport");
    	JsonNode fly_date = rootNode.path("fly_date");
    	JsonNode fly_money = rootNode.path("fly_money");
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Fly fly=new Fly();
		Route rt=routeService.getRouteByName(from_airport.asText(),to_airport.asText());
		if(rt==null)
		{
			rt=new Route();
			rt.setTo_airport_id(airportService.getAirportByName(to_airport.asText()));
			rt.setFrom_airport_id(airportService.getAirportByName(from_airport.asText()));
			routeService.saveOrUpdate(rt);
			
		}
		fly.setRoute_id(rt);
		fly.setAirplane_id(airplaneService.getAirportByName(airplane_name.asText()));
		fly.setFly_date(formatter.parse(fly_date.asText()));
		fly.setMoney(fly_money.asDouble());
		flyService.saveOrUpdate(fly);
		return new ResponseEntity<>(fly, HttpStatus.OK);
	}
	
	@GetMapping("/getFly/")
	public ResponseEntity<List<Fly>> getFly(@PathParam(value = "data")  String data) throws JsonMappingException, JsonProcessingException {

		return new ResponseEntity<>(flyService.getRouteByName(data.split("-")[0],data.split("-")[1]), HttpStatus.OK);
	}

	@GetMapping("/getAllFly")
	public ResponseEntity<List<Fly>> getAllRoute() {
		return new ResponseEntity<>(flyService.getAllFlies(), HttpStatus.OK);
	}

}
