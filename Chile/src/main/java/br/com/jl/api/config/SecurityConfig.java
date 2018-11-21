package br.com.jl.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.jl.service.CustomDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomDetailService customDetailService;
	
	 private static final String[] AUTH_WHITELIST = {
	            // -- swagger ui
	            "/v2/api-docs",
	            "/swagger-resources",
	            "/swagger-resources/**",
	            "/configuration/ui",
	            "/configuration/security",
	            "/swagger-ui.html",
	            "/webjars/**"
	            // other public endpoints of your API may be appended to this array
	    };


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                // ... here goes your custom security configuration
                authorizeRequests().
                	antMatchers(AUTH_WHITELIST).permitAll().  // whitelist Swagger UI resources
                // ... here goes your custom security configuration
                	
                anyRequest().authenticated();  // require authentication for any endpoint that's not whitelisted
    }

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
