package com.example.case_study.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.case_study.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.case_study.Repository.UserRepository;


@Service
public class UserService {

	@Autowired
    UserRepository userRepository;

    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User getPersonById(int id) {
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate(User user) {
    	userRepository.save(user);
    }

    public void delete(int id) {
    	userRepository.deleteById(id);
    }
	
}
