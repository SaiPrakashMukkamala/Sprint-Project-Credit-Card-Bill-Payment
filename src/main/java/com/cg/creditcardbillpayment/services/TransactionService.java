package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.Transaction;
import com.cg.creditcardbillpayment.exceptions.TransactionServiceException;

public interface TransactionService {
	public Transaction addTransaction(Transaction transaction);

	public void removeTransaction(String refno) ;

	public Transaction updateTransaction(Transaction transaction);

	public Transaction getTransactionDetails(String  refno) ;

	public List<Transaction> getAllTransactions();
}
