package br.com.jl.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/users")
@Api(value="GESTÃO DE USUARIOS")
public class UserController {
	
	@GetMapping("/doPermit")
	public ResponseEntity doPermit(@AuthenticationPrincipal UserDetails user) {
		
		Map<Object, Object> model = new HashMap<Object, Object>();
		
		model.put("username", user.getUsername());
		
		return new ResponseEntity<>(HttpStatus.OK).ok(model);
	}

}
