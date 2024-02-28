package com.deecoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class BasicsOfSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicsOfSpringbootApplication.class, args);
	}

	@GetMapping("/base")
	public ResponseEntity<String> getRequestProcessor() {
		return ResponseEntity.ok().body("Processed get request.");
	}

}
