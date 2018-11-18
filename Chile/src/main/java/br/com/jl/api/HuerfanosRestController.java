package br.com.jl.api;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/huerfanos")
@Api(value="INTERAÇÃO COM FILA")
public class HuerfanosRestController {
	
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@Autowired
    private Queue queue;
	
	@GetMapping(value="/info")
	public ResponseEntity<String> retrieveInfo(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value="/sendQueue")
	public ResponseEntity<String> sendToQueue(){
		
		try {
			
			rabbitTemplate.convertAndSend(this.queue.getName(), "Hola Jonathas");
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
