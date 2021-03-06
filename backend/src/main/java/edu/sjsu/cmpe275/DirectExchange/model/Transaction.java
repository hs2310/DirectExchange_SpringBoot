package edu.sjsu.cmpe275.DirectExchange.model;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Entity
@Table(name = "Transacation")
public class Transaction implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JsonIgnoreProperties({ "matchingOffers", "counterOffers", "parentOffer", "holdOffer" })
	@JoinColumn(name = "main_offer", nullable = false)
	private Offer mainOffer;

	@OneToOne
	@JsonIgnoreProperties({ "matchingOffers", "counterOffers", "parentOffer", "holdOffer" })
	@JoinColumn(name = "other_offer", nullable = false)
	private Offer otherOffer;

	@Column(nullable = false)
	private Date transactionExpirationDate;

	@Column(nullable = false)
	private String status = "pending";

	@Column(nullable = false)
	private Boolean paid = false;

	public Offer getMainOffer() {
		return mainOffer;
	}

	public void setMainOffer(Offer mainOffer) {
		this.mainOffer = mainOffer;
	}

	public Offer getOtherOffer() {
		return otherOffer;
	}

	public void setOtherOffer(Offer otherOffer) {
		this.otherOffer = otherOffer;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public Date getTransactionExpirationDate() {
		return transactionExpirationDate;
	}

	public void setTransactionExpirationDate(Date transactionExpirationDate) {
		this.transactionExpirationDate = transactionExpirationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
