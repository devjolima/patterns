package br.com.jl.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().disable().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/auth/signin").permitAll()
				.antMatchers("/configuration/ui").permitAll()
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/swagger-ui.html").permitAll()
				.antMatchers("/swagger-resources/**").permitAll()
				.antMatchers("/configuration/security").permitAll()
				.antMatchers("/v2/api-docs").permitAll()
				.anyRequest().authenticated().and()
				.apply(new JwtConfigurer(jwtTokenProvider));

	}

}
