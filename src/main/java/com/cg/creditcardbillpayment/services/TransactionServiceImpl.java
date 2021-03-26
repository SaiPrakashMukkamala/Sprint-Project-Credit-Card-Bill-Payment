package com.cg.creditcardbillpayment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.TransactionRepository;
import com.cg.creditcardbillpayment.entities.Transaction;
import com.cg.creditcardbillpayment.exceptions.TransactionServiceException;

/****************************************************************************************************************************************
 *          @author          M.V.Sai Prakash
 *          Description      It is a service class that provides the services to add a
           					 transaction, remove a transaction,update a transaction
         					 and view transactions 
  *         Version             1.0
  *         Created Date     24-03-2021
 ***************************************************************************************************************************************/


@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	/***********************************************************************************************************************************
	 * Method 									:addTransaction
     *Description 								:To add the transaction to the Database
	 * @param transaction      					- transaction to be added to the Database
	 * @returns Transaction                  	- returns transaction after adding the account to Database
	 * @throws TransactionServiceException 		- It is raised when transaction already exists in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 23-03-2021                          
	 
	 ***********************************************************************************************************************************/



	@Override
	public Transaction addTransaction(Transaction transaction) {
		
		Optional<Transaction> transaction1=transactionRepository.findById(transaction.getRefNo());
		if(transaction1.isEmpty()) {
		transactionRepository.saveAndFlush(transaction);
		return transaction;
		}
		else {
			throw new TransactionServiceException("Transaction Already Exists With Given Reference Number");
		}
	}

	/************************************************************************************
	 * Method 									: removeTransaction
     *Description 								: To remove the transaction from the Database
	 * @param refNo      					 	- Reference number of transaction to be deleted
	 * @returns void                  			- returns void
	 * @throws TransactionServiceException 		- It is raised when transaction does not exist in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 23-03-2021                          
	 
	 ************************************************************************************/
	@Override
	public void removeTransaction(String refno)  {
		
		Optional<Transaction> transaction = transactionRepository.findById(refno);
		if (!transaction.isEmpty())
			transactionRepository.delete(transaction.get());
		else
			throw new TransactionServiceException("Statement Does not exist to delete ");	
	}
	/************************************************************************************
	 * Method 									: updateTransaction
     *Description 								: To update the transaction in the Database
	 * @param transaction      					- transaction to be updated
	 * @returns Transaction                  	- returns updated transaction
	 * @throws TransactionServiceException 		- It is raised when transaction does not exist in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 23-03-2021                          
	 
	 ************************************************************************************/

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		
		Optional<Transaction> transaction1=transactionRepository.findById(transaction.getRefNo());
		if(!transaction1.isEmpty()) {
		transactionRepository.save(transaction);
		return transaction;
		}
		else
			throw new TransactionServiceException("Statement Does not exist to Update");
	}
	
	/************************************************************************************
	 * Method 									: getTransactionDetails
     *Description 								: To fetch the transaction from the Database
	 * @param refno      						- reference number of the transaction to be fetched
	 * @returns Transaction                  	- returns transaction
	 * @throws TransactionServiceException 		- It is raised when transaction does not exist in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 23-03-2021                          
	 
	 ************************************************************************************/

	@Override
	public Transaction getTransactionDetails(String refno)  {
		
		Optional<Transaction> transaction = transactionRepository.findById(refno);
		if(!transaction.isEmpty())
			return transaction.get();
		else 
			throw new TransactionServiceException("Statement  does not exist");
	}
	
	/************************************************************************************
	 * Method 									: getAllTransactions
     *Description 								: To fetch all the transactions from the Database
	 * @returns List<Transaction>               - returns the list of transactions
	 * @throws TransactionServiceException 		- It is raised when transactions does not exist in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 23-03-2021                          
	 ************************************************************************************/

	@Override
	public List<Transaction> getAllTransactions() {
	

		List<Transaction> transaction=transactionRepository.findAll();
		if(transaction.isEmpty())
			throw new TransactionServiceException("No Statements Found");
		else
			return transaction;
	}

}
