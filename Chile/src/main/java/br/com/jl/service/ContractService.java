package br.com.jl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jl.entity.Contract;
import br.com.jl.repository.ContractRepository;

@Service
public class ContractService {
	
	@Autowired
	private ContractRepository repo;
	
	public List<Contract> getAllContracts(String key){
		return repo.getAllRegisters(key);
	}

}
