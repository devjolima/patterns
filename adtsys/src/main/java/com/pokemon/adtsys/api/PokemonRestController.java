package com.pokemon.adtsys.api;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.adtsys.ui.RetornoPokemon;
import com.pokemon.adtsys.util.PokemonBusiness;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Api("API de busca de pokemons")
public class PokemonRestController {

    private static final Logger logger = LogManager.getLogger(PokemonRestController.class);
	
	@Autowired
	private PokemonBusiness pokemonBusiness;

	@SuppressWarnings({ "static-access", "rawtypes" })
	@GetMapping("search/find/{cidade}")
	public ResponseEntity signin(@PathVariable String cidade) {
		
		logger.info("END POINT INVOKED");
		
		try {
			
			String url = "https://api.openweathermap.org/data/2.5/weather?q="+cidade+"&appid=ef1e8df553675223828dd580079831a8";
		
			List<RetornoPokemon> jsonPoke = pokemonBusiness.listPokeForCity(url);
			
			Collections.shuffle(jsonPoke);
			
			logger.info("END POINT INVOKED FINISHED");
			
			return new ResponseEntity<RetornoPokemon>(HttpStatus.OK).ok().body(jsonPoke);	
			
		} catch (Exception e) {
			
			if (e instanceof NullPointerException) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	       
			}else {
	        	
				RetornoPokemon retornoPokemon = new RetornoPokemon();
	        	retornoPokemon.erro = "try again.";
	        	return new ResponseEntity<RetornoPokemon>(HttpStatus.INTERNAL_SERVER_ERROR).ok().body(retornoPokemon);
	        	
	        }
			
		}

	}
	

}
