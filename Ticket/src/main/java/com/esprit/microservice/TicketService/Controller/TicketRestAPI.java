package com.esprit.microservice.TicketService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.TicketService.Entity.Ticket;
import com.esprit.microservice.TicketService.Services.TicketService;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketRestAPI {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/list")
	public List<Ticket> getTickets() {
		return ticketService.getTickets();
	}
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		return new ResponseEntity<>(ticketService.addTicket(ticket), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "id") int id,
    										@RequestBody Ticket ticket){
		return new ResponseEntity<>(ticketService.updateTicket(id, ticket), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteTicket(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(ticketService.deleteTicket(id), HttpStatus.OK);
	}
}
