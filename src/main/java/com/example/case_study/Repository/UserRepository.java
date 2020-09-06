package com.example.case_study.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.case_study.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {}
