package net.libanto.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/home")
public class HomeController {
	@GetMapping("/")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("Hello from our API");
	}
}
