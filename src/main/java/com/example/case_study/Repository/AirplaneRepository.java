package com.example.case_study.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.case_study.Model.Airplane;

public interface AirplaneRepository extends CrudRepository<Airplane, Integer> {}
