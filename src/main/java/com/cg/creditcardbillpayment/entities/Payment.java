package com.cg.creditcardbillpayment.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	@Id
	private Long paymentId;
	private Double amount;
	private String status;
	@ManyToOne
	private CreditCard card;
	
	
	
	@OneToMany
	private Set<Statement> payment;

	public Payment() {
		super();
	}

	public Payment(Long paymentId, Double amount, String status, CreditCard card) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.status = status;
		this.card = card;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double type) {
		this.amount = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + amount + ", status=" + status + ", card=" + card + "]";
	}
}
