package com.cignex.rahul.springbootmongodb;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SpringBootMongodbApplication {

	@Autowired
	private CustomerRepository repository;

	@GetMapping
	public ArrayList<HashMap<String, String>> saveData() {
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			repository.save(new Customer("FirstName" + i, "LastName" + i));
		}
		
		for (Customer customer : repository.findAll()) {
			HashMap<String, String> map = new HashMap<>();
			map.put("firstname", customer.firstName);
			map.put("last", customer.lastName);
			list.add(map);
		}
		
		return list;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbApplication.class, args);
	}

}
