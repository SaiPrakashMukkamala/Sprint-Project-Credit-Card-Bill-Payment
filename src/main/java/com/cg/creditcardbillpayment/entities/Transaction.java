package com.cg.creditcardbillpayment.entities;




import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/************************************************************************************
 *          @author          M.V.Sai Prakash
 *          Description      It is an Entity class that has various data members.
  *         Version          1.0
  *         Created Date     23-03-2021
 ************************************************************************************/

@Entity
public class Transaction {
	@Id
	private String refNo;
	private String status;
	@DateTimeFormat(style="dd-MM-yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private LocalDate transactionDate;
	
	@DateTimeFormat(style="HH:mm")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="HH:mm")
	private LocalTime time;
	private String cardNo;
	private String emailAddr;
	private String mobileNo;
	private Double paymentAmount;
	private String payFrom;

	public Transaction() {
		super();
	}

	public Transaction(String refNo, String status, LocalDate transactionDate, LocalTime  time, String cardNo, String emailAddr,
			String mobileNo, Double paymentAmount, String payFrom) {
		super();
		this.refNo = refNo;
		this.status = status;
		this.transactionDate = transactionDate;
		this.time = time;
		this.cardNo = cardNo;
		this.emailAddr = emailAddr;
		this.mobileNo = mobileNo;
		this.paymentAmount = paymentAmount;
		this.payFrom = payFrom;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate gettransactionDate() {
		return transactionDate;
	}

	public void settransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPayFrom() {
		return payFrom;
	}

	public void setPayFrom(String payFrom) {
		this.payFrom = payFrom;
	}

	@Override
	public String toString() {
		return "Transaction [refNo=" + refNo + ", status=" + status + ", TransactionDate=" + transactionDate + ", time=" + time
				+ ", cardNo=" + cardNo + ", emailAddr=" + emailAddr + ", mobileNo=" + mobileNo + ", paymentAmount="
				+ paymentAmount + ", payFrom=" + payFrom + "]";
	}
}
