package com.example.case_study.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.case_study.Model.Airplane;
import com.example.case_study.Model.Route;
import com.example.case_study.Repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<Route>();
        routeRepository.findAll().forEach(route -> routes.add(route));
        return routes;
    }

    public Route getRouteById(int id) {
        return routeRepository.findById(id).get();
    }

    public void saveOrUpdate(Route route) {
    	routeRepository.save(route);
    }

    public void delete(int id) {
    	routeRepository.deleteById(id);
    }
    public Route getFromRouteByName(String name) {
		List<Route> routes=getAllRoutes();
    	for (Route route : routes) {
            if (route.getFrom_airport_id().getAirport_name().equals(name)) {
                return route;
            }
        }
    	
        return null;
	}
    
    public Route getRouteByName(String from_name,String to_name) {
 		List<Route> routes=getAllRoutes();
     	for (Route route : routes) {
             if (route.getFrom_airport_id().getAirport_name().equals(from_name) && route.getTo_airport_id().getAirport_name().equals(to_name)) {
                 return route;
             }
         }
     	
         return null;
 	}
    
    public Route getToRouteByName(String name) {
 		List<Route> routes=getAllRoutes();
     	for (Route route : routes) {
             if (route.getTo_airport_id().getAirport_name().equals(name)) {
                 return route;
             }
         }
     	
         return null;
 	}
}
