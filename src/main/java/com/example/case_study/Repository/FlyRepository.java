package com.example.case_study.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.case_study.Model.Fly;

public interface FlyRepository extends CrudRepository<Fly, Integer> {}
