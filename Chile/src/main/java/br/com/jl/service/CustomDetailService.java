package br.com.jl.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.jl.api.security.UserPrincipal;
import br.com.jl.entity.Role;
import br.com.jl.entity.RoleName;
import br.com.jl.entity.User;

@Service
public class CustomDetailService {
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		
		if("jonathaslima".equals(userName)) {
			Role role = new Role();
			role.setId(1L);
			role.setRoleName(RoleName.ROLE_ADMIN);
			
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			
			User user = new User(1L, "jonathas lima", "jonathaslima", "12345", "jonathas.o.lima@gmail.com",Arrays.asList("ADMIN"));
			return UserPrincipal.create(user);
		}else {
			return null;
		}
	}

}
