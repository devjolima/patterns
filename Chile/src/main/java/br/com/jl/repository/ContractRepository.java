package br.com.jl.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jl.entity.Contract;
import br.com.jl.generic.repository.AbstractRepository;

@Repository
public class ContractRepository extends AbstractRepository {

	private static final String KEY = "contratos";
	private static final String KEY_RESP = "responsaveis";

	@SuppressWarnings("unchecked")
	public void addContract(Contract contract) {
		
		addEntity(KEY_RESP, contract.getOwner());
		addEntity(KEY, contract);

	}

	@SuppressWarnings("unchecked")
	public List<Contract> getContract() {
		
		return getAllRegisters(KEY);
	}

}
