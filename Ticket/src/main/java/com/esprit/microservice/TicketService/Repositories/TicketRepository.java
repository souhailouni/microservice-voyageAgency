package com.esprit.microservice.TicketService.Repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.microservice.TicketService.Entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	@Query("select t from Ticket t where t.reference like :reference")
	public Page<Ticket> getbilletByName(@Param("reference") String reference, Pageable pageable);
	   
}
