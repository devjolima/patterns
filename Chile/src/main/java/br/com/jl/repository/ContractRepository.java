package br.com.jl.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import br.com.jl.entity.Contract;

@Repository
public class ContractRepository {

	private static final String KEY = "contratos";
	private static final String KEY_RESP = "responsaveis";

	@Autowired
	private RedisTemplate<String, Object> template;

	public void addContract(Contract contract) {

		template.opsForList().leftPush(KEY_RESP, contract.getOwner());
		template.opsForList().leftPush(KEY, contract);
	}

	public Contract getContract() {
		
		List<Object> retorno = template.opsForList().range("contratos", 0, -1);
		
		return (Contract) retorno.get(0);
	}

}
