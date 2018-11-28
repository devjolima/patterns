package br.com.jl.generic.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractRepository <T extends Serializable> {
	
	private Class<T> clazz;
	
	@Autowired
	protected RedisTemplate<String, Object> template;
	
	public final void setClazz(Class<T> clazzSet) {
		this.clazz = clazzSet;
	}
	
	public <T> void addEntity(String key, T obj) {

		template.opsForList().leftPush(key, obj);
		
	}

	public List<T> getAllRegisters(String key) {
		
		List<Object> list = template.opsForList().range(key, 0, -1);
		
		return (List<T>) list;
	}

}
