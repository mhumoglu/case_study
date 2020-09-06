package com.example.case_study.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.case_study.Model.Airport;
import com.example.case_study.Repository.AirportRepository;

@Service
public class AirportService {
	@Autowired
	AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList<Airport>();
        airportRepository.findAll().forEach(airport -> airports.add(airport));
        return airports;
    }

    public Airport getAirportById(int id) {
        return airportRepository.findById(id).get();
    }
    
    public Airport getAirportByName(String name) {
    	List<Airport> airports=getAllAirports();
    	for (Airport airport : airports) {
            if (airport.getAirport_name().equals(name)) {
                return airport;
            }
        }
    	
        return null;
    }

    public void saveOrUpdate(Airport airport) {
    	airportRepository.save(airport);
    }

    public void delete(int id) {
    	airportRepository.deleteById(id);
    }

}
