package com.example.case_study.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.case_study.Model.Fly;
import com.example.case_study.Model.Route;
import com.example.case_study.Repository.FlyRepository;

@Service
public class FlyService {
	@Autowired
	FlyRepository flyRepository;

    public List<Fly> getAllFlies() {
        List<Fly> flies = new ArrayList<Fly>();
        flyRepository.findAll().forEach(fly -> flies.add(fly));
        return flies;
    }

    public Fly getFlyById(int id) {
        return flyRepository.findById(id).get();
    }

    public void saveOrUpdate(Fly fly) {
    	flyRepository.save(fly);
    }

    public void delete(int id) {
    	flyRepository.deleteById(id);
    }

	public List<Fly> getRouteByName(String from_name, String to_name) {
		List<Fly> flies=getAllFlies();
     	for (Fly fly : flies) {
             if (!(fly.getRoute_id().getFrom_airport_id().getAirport_name().equals(from_name) && fly.getRoute_id().getTo_airport_id().getAirport_name().equals(to_name))) {
                 flies.remove(fly);
             }
         }
     	
         return flies;
	}

}
