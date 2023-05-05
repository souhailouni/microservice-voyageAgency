package com.esprit.microservice.TicketService.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.TicketService.Entity.Ticket;
import com.esprit.microservice.TicketService.Repositories.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public Ticket addTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	public Ticket updateTicket(int id, Ticket newTicket) {
		if (ticketRepository.findById(id).isPresent()) {
			Ticket existingTicket = ticketRepository.findById(id).get();
			existingTicket.setReference(newTicket.getReference());
			existingTicket.setPrice(newTicket.getPrice());
			existingTicket.setDescription(newTicket.getDescription());
			existingTicket.setFlight(newTicket.getFlight());
			existingTicket.setClientId(newTicket.getClientId());

			return ticketRepository.save(existingTicket);
		} else
			return null;
	}
	public String deleteTicket(int id) {
		if (ticketRepository.findById(id).isPresent()) {
			ticketRepository.deleteById(id);
			return "Ticket deleted";
		} else
			return "Ticket can't be deleted";
	}

	public List<Ticket> getTickets() {
		return ticketRepository.findAll();
	}
}
