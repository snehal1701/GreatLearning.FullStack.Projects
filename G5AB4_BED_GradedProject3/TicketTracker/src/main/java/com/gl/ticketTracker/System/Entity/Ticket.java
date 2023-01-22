package com.gl.ticketTracker.System.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "title", nullable = false)
	private String ticketTitle;

	@Column(name = "shortDescription")
	private String ticketShortDescription;

	@Column(name = "ticketContent", length = 1000)
	private String  ticketContent;
	@Column(name = "createdOn")
	private LocalDate ticketCreatedOn;
	@Column(name = "updatedOn")
	private LocalDate ticketUpdatedOn;

}
