package br.com.jl.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/users")
@Api(value="GESTÃO DE USUARIOS")
public class UserController {
	
	@GetMapping("/doPermit")
	public Boolean doPermit() {
		return true;
	}

}
