package br.com.jl.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jl.api.security.AuthenticationRequest;
import br.com.jl.api.security.CustomAuthenticateProvider;
import br.com.jl.api.security.JwtTokenProvider;
import br.com.jl.entity.Role;
import br.com.jl.entity.RoleName;
import br.com.jl.entity.User;
import br.com.jl.service.CustomDetailService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private CustomAuthenticateProvider customAuthenticateProvider;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private CustomDetailService customDetailService;
	
	@PostMapping("/signin")
	public ResponseEntity signin(@RequestBody AuthenticationRequest data) {
		
		try {
			
			Role role = new Role();
			role.setId(1L);
			role.setRoleName(RoleName.ROLE_ADMIN);
			
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			
			String username = data.getUsername();
			customAuthenticateProvider.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
			String token = jwtTokenProvider.createToken(username,   Arrays.asList("ADMIN"));
			
			Map<Object, Object> model = new HashMap<>();
			model.put("username", username);
			model.put("token", token);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(token);			
		} catch (Exception e) {
			throw new BadCredentialsException("INVALID USERNAME ");	
		}
	}

}
