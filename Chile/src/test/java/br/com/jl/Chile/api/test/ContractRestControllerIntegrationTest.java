package br.com.jl.Chile.api.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.jl.api.ContractRestController;
import br.com.jl.api.security.JwtTokenProvider;
import br.com.jl.entity.Contract;
import br.com.jl.entity.Owner;
import br.com.jl.service.ContractService;
import br.com.jl.service.CustomDetailService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	List<Contract> contracts;
	
	@Value("${token.test}")
	private String TOKEN;
	
	@Autowired
	private CustomDetailService customDetailService;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Before
	public void initList() {
		
		this.contracts = new ArrayList<>();
		Owner owner = new Owner(1L, "JONATHAS", "F");
		Contract contract = new Contract(1L, owner, 999, new Date());
		contracts.add(contract);
		
	}
	
	@Test
	public void givenAllContracts() throws Exception {
		
		this.mvc.perform(MockMvcRequestBuilders.get("/contracts/getContracts").header("Authorization", "Bearer "+generateAuthToken()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	public String generateAuthToken() throws Exception {
		
		String token = jwtTokenProvider.createToken("jonathaslima",   Arrays.asList("TESTE"));
		assertNotNull(token);
		return token;
		
	}

}
