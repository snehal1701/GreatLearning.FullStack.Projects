package com.gl.ticketTracker.System.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.ticketTracker.System.Entity.Ticket;
import com.gl.ticketTracker.System.Service.TicketService;

@Controller

public class TicketController {

	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}

	// handler method to handle list tickets and return mode and view
	@GetMapping("/tickets")
	public String listtickets(Model model) {
		model.addAttribute("tickets", ticketService.getAllTickets());
		model.addAttribute("header", "List Tickets");
		return "tickets";
	}

	@GetMapping("/tickets/new")
	public String createticketForm(Model model) {

		// create ticket object to hold ticket form data
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";

	}

	@PostMapping("/tickets")
	public String saveTickets(@ModelAttribute("ticket") Ticket ticket) {

		ticketService.saveTicket(ticket);

		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editticketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}
	@GetMapping("/tickets/search")
	public String searchTicket(Ticket ticket,Model model,String keyword) {
		List<Ticket> list = ticketService.findByKeyword(keyword);
		model.addAttribute("tickets", list);
		model.addAttribute("keyword", keyword);
		model.addAttribute("header", "Search Results");
		return "tickets";
	}
	@PostMapping("/tickets/{id}")
	public String updatetickets(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket, Model model) {

		// get ticket from database by no
		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setTicketTitle(ticket.getTicketTitle());
		existingTicket.setTicketShortDescription(ticket.getTicketShortDescription());
		existingTicket.setTicketContent(ticket.getTicketContent());

		// save updated ticket object
		ticketService.updateTicket(existingTicket);
		return "redirect:/tickets";
	}

	// handler method to handle delete ticket request

	@GetMapping("/tickets/{id}")
	public String viewticket(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "view_ticket";
	}

	@GetMapping("/tickets/delete/{id}")
	public String deleteticket(@PathVariable Long id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}

}
