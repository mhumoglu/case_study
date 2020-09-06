package com.example.case_study.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.case_study.Model.Airplane;
import com.example.case_study.Model.Airport;
import com.example.case_study.Repository.AirplaneRepository;

@Service
public class AirplaneService {
	
	@Autowired
	AirplaneRepository airplaneRepository;

    public List<Airplane> getAllAirplane() {
        List<Airplane> airplanes = new ArrayList<Airplane>();
        airplaneRepository.findAll().forEach(airplane -> airplanes.add(airplane));
        return airplanes;
    }

    public Airplane getAirplaneById(int id) {
        return airplaneRepository.findById(id).get();
    }

    public void saveOrUpdate(Airplane airplane) {
    	airplaneRepository.save(airplane);
    }

    public void delete(int id) {
    	airplaneRepository.deleteById(id);
    }

	public Airplane getAirportByName(String name) {
		List<Airplane> airplanes=getAllAirplane();
    	for (Airplane airplane : airplanes) {
            if (airplane.getAirplane_name().equals(name)) {
                return airplane;
            }
        }
    	
        return null;
	}

}
