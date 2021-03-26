package com.cg.creditcardbillpayment.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.creditcardbillpayment.entities.Transaction;
import com.cg.creditcardbillpayment.exceptions.TransactionServiceException;
import com.cg.creditcardbillpayment.services.TransactionService;

/************************************************************************************
 *          @author          M.V.Sai Prakash
 *          Description      It is a test class that provides the testcases to test the 
                             TransactionService  class
  *         Version             1.0
  *         Created Date     22-03-2021
 ************************************************************************************/

@SpringBootTest
public class TransactionServiceTest {
	
	@Autowired
	private TransactionService transactionservice;
	
	Transaction transaction=new Transaction("4","yes",LocalDate.parse("2019-03-12"),LocalTime.parse("10:20:30"),"1000","prakash","9087",200.00,"Card");
	Transaction transaction1=new Transaction("1","no",LocalDate.parse("2019-03-12"),LocalTime.parse("10:00:40"),"1000","prakash","9087",200.00,"Card1");
	
	@Test
	void AddTransactionTest()  {
		
		
		assertThrows(TransactionServiceException.class,()->{
			transactionservice.addTransaction(transaction);
		});
		
	}
	@Test
	void AddTransactionTest1()  {
		
		assertEquals("1000",transactionservice.getTransactionDetails(transaction.getRefNo()).getCardNo());
	}
	@Test
	void getTransactionDetailsTest()  {
	
		assertEquals("9087",transactionservice.getTransactionDetails("1").getMobileNo());
	}
	@Test
	void getTransactionDetailsTest1() {
		assertEquals("1000",transactionservice.getTransactionDetails("1").getCardNo());
	}
	@Test
	void updateTransactionTest()  {
		transactionservice.updateTransaction( transaction1);
		assertEquals("no",transactionservice.getTransactionDetails("1").getStatus());
	}
	@Test
	void updateTransactionTest1()  {
	assertEquals("Card1",transactionservice.getTransactionDetails("1").getPayFrom());
	}

}
