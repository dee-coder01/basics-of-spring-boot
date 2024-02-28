package com.deecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@SpringBootApplication
@Controller
public class BasicsOfSpringbootApplication {
	@Autowired
	private SpringService service;

	public static void main(String[] args) {
		SpringApplication.run(BasicsOfSpringbootApplication.class, args);
	}

	@GetMapping("/base")
	public ResponseEntity<String> getRequestProcessor() {
		return ResponseEntity.ok().body("Processed get request.");
	}

	@PostMapping("/base")
	public ResponseEntity<String> getRequestProcessor(@RequestBody UserInfo userInfo) {
		if (service.complexUserCheck(userInfo))
			return ResponseEntity.ok().body("UserInfo Processed.");
		else
			return ResponseEntity.badRequest().body("Bad user data.");
	}

}

@Service
class SpringService {

	public boolean complexUserCheck(UserInfo userInfo) {
		// Performing some very complex user verification 🙃
		return true;
	}
}

@Entity
class UserInfo {
	@Id
	private int id;
	private String name;

	public UserInfo(int id, String name) {
		this.id = id;
		this.name = name;
	}

}

interface SpringRespository extends JpaRepository<UserInfo, Integer> {
}
