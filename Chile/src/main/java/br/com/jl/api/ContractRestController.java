package br.com.jl.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jl.entity.Contract;
import br.com.jl.repository.ContractRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/contracts")
@Api(value="GESTÃO DE CONTRATOS")
public class ContractRestController {
	
	@Autowired
	ContractRepository repo;

	@PutMapping(value="/addContract")
	public ResponseEntity<String> addContract(@RequestBody Contract contract){
		
		ObjectMapper mapper = new ObjectMapper();
		
		repo.addContract(contract);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getContracts")
	public ResponseEntity<String> getContracts() {
		
		List<Contract> contracts = repo.getContract();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
		
			return ResponseEntity.status(HttpStatus.OK)
			        .body(mapper.writeValueAsString(contracts));
		
		} catch (JsonProcessingException e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			        .body("ERRO AO RETORNAR CONSULTA");
			
		}
	}
}
