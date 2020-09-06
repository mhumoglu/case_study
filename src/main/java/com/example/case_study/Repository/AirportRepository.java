package com.example.case_study.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.case_study.Model.Airport;

public interface AirportRepository extends CrudRepository<Airport, Integer> {}
