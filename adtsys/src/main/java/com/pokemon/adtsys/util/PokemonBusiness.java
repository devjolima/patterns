package com.pokemon.adtsys.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pokemon.adtsys.ui.RetornoPokemon;

@Service
public class PokemonBusiness {
	
    private static final Logger logger = LogManager.getLogger(PokemonBusiness.class);

	@Autowired
	private RestTemplate restTemplate;

	private Double rate = 273.15;

	private String returnPokemonApi(Double temperature) {

		String api = "";

		if (temperature < 5) {
			api = "https://pokeapi.co/api/v2/type/ice";
		} else if (temperature > 5 && temperature < 10) {
			api = "https://pokeapi.co/api/v2/type/water";
		} else if (temperature > 12 && temperature < 15) {
			api = "https://pokeapi.co/api/v2/type/grass";
		} else if (temperature > 15 && temperature < 21) {
			api = "https://pokeapi.co/api/v2/type/ground";
		} else if (temperature > 23 && temperature < 27) {
			api = "https://pokeapi.co/api/v2/type/bug";
		} else if (temperature > 27 && temperature < 33) {
			api = "https://pokeapi.co/api/v2/type/rock";
		} else if (temperature > 33) {
			api = "https://pokeapi.co/api/v2/type/fire";
		} else {
			api = "https://pokeapi.co/api/v2/type/normal";
		}
		return api;
	}

	public List<RetornoPokemon> listPokeForCity(String url) {

		String json = restTemplate.exchange(url, HttpMethod.GET, mountHeadersRequisition(), String.class).getBody();
		JSONObject jsonResult = new JSONObject(json);
		
		if(!jsonResult.getJSONObject("main").isNull("temp")) {
			
			JSONObject data = jsonResult.getJSONObject("main");
			Double temperatura = (Double) data.get("temp");
			return searchPokemonData(temperatura);
			
		}else {
			
			logger.error("HUMMM, TEMPERATURE NOT FOUNDED");
			return null;
			
		}
	}

	public List<RetornoPokemon> searchPokemonData(Double temperature) {

		String apiUrl = returnPokemonApi(temperature - rate);
		String json = restTemplate.exchange(apiUrl, HttpMethod.GET, mountHeadersRequisition(), String.class).getBody();
		JSONObject jsonResult = new JSONObject(json);
		JSONArray data = jsonResult.getJSONArray("pokemon");
		List<RetornoPokemon> listPokemons = parseResultPoke(data, temperature);
		
		if(listPokemons.isEmpty()) {
			logger.error("HUMMM, A SOME PROBLEMS FOUNDED IN SEARCH POKEMONS..SORRY");
		}
		
		return listPokemons;

	}

	private List<RetornoPokemon> parseResultPoke(JSONArray data, Double temperature) {
		
		List<RetornoPokemon> listPokes = new ArrayList<RetornoPokemon>();
		
		for(int i=0; i<data.length(); i++) {
			
			RetornoPokemon poke = new RetornoPokemon();
			String pokeName = (String) data.getJSONObject(i).getJSONObject("pokemon").get("name");
			String pokeUrlDetails = (String) data.getJSONObject(i).getJSONObject("pokemon").get("url");
			
			String jsonImage = restTemplate.exchange(pokeUrlDetails, HttpMethod.GET, mountHeadersRequisition(), String.class).getBody();
			JSONObject jsonResult = new JSONObject(jsonImage);
			
			String dataImg = "";
			if(null!=jsonResult.getJSONObject("sprites") && !jsonResult.getJSONObject("sprites").isNull("front_default")) {
				dataImg = jsonResult.getJSONObject("sprites").getString("front_default").toString();
			}
			
			poke.nome = pokeName;
			poke.imagem = dataImg;
			poke.temperatura = temperature.intValue() - 273;
			listPokes.add(poke);
		}
		
		return listPokes;
	}

	@SuppressWarnings("rawtypes")
	private HttpEntity mountHeadersRequisition() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;

	}
}
