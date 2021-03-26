package com.cg.creditcardbillpayment.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.creditcardbillpayment.entities.Account;
import com.cg.creditcardbillpayment.entities.Statement;
import com.cg.creditcardbillpayment.entities.Transaction;
import com.cg.creditcardbillpayment.entities.Transaction;
import com.cg.creditcardbillpayment.entities.User;
import com.cg.creditcardbillpayment.exceptions.TransactionServiceException;
import com.cg.creditcardbillpayment.services.StatementService;
import com.cg.creditcardbillpayment.services.TransactionService;
import com.cg.creditcardbillpayment.services.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	/************************************************************************************
	 * Method 									: addTransaction
     *Description 								: To add the transaction to the Database
	 * @param transaction      					- transaction to be added to the Database
	 * @param RequestBody						- It maps the HttpRequest body to a transfer or domain object,
	  											  enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	 * @returns Transaction                  	- returns transaction
	 * @throws TransactionServiceException 		- It is raised when transaction already exists in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 24-03-2021                          
	 
	 ************************************************************************************/

	@PostMapping("/add")
	public  ResponseEntity<Transaction> addStatement(@RequestBody Transaction transaction) {
		transactionService.addTransaction(transaction);
		return new   ResponseEntity<Transaction>(transaction,HttpStatus.OK);

	}
	
	/************************************************************************************
	 * Method 									: getTransaction
     * Description 								: To fetch the transaction from the Database
	 * @param refno      						- Reference number of the transaction to be fetched
	 * @param PathVariable						- used to handle template variables in the request URI mapping,  
	 											  and use them as method parameters
	 * @returns Transaction                  	- returns transaction
	 * @throws TransactionServiceException 		- It is raised when transaction does not exist in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 24-03-2021                          
	 
	 ************************************************************************************/

	@GetMapping("/get/{refno}")
	public ResponseEntity<Transaction> getAccount(@PathVariable String refno) {
		
		Transaction transaction=transactionService.getTransactionDetails(refno);
		
		return new ResponseEntity<Transaction>(transaction,HttpStatus.OK);
	}
	
	/************************************************************************************
	 * Method 									: updateTransaction
     * Description 								: To update the transaction to the Database
	 * @param transaction      					- transaction to be updated in the Database
	 * @param RequestBody						- It maps the HttpRequest body to a transfer or domain object,
	  											  enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	 * @returns Transaction                  	- returns transaction
	 * @throws TransactionServiceException 		- It is raised when transaction does not exist in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 24-03-2021                          
	 
	 ************************************************************************************/
	
	@PutMapping("/update")
	public  ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
		
		transactionService.updateTransaction( transaction);
		return new ResponseEntity<Transaction>(transaction,HttpStatus.OK);
		
	}
	
	/************************************************************************************
	 * Method 									: deleteTransaction
     * Description 								: To delete the transaction from the Database
	 * @param refno      						- Reference number of the transaction to be deleted
	 * @param PathVariable						- used to handle template variables in the request URI mapping,  
	 											  and use them as method parameters
	 * @returns void                  			- Doesnot return value
	 * @throws TransactionServiceException 		- It is raised when transaction does not exist in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 24-03-2021                          
	 
	 ************************************************************************************/
	
	@DeleteMapping("/delete/{refno}")
	public void deleteTransaction(@PathVariable String refno)  {	

		transactionService.removeTransaction(refno); 
		
	}
	
	/************************************************************************************
	 * Method 									: getAllTransaction
     * Description 								: To fetch all the transactions from the Database
	 * @returns List<Transaction>               - returns all transactions in the Database
	 * @throws TransactionServiceException 		- It is raised when transactions does not exist in the Database
     *Created By                                - M.V.Sai Prakash
     *Created Date                              - 24-03-2021                          
	 
	 ************************************************************************************/
	
	@GetMapping("/getall")
	public  ResponseEntity<List<Transaction>> getAllTransaction() {
		
		List<Transaction> transactions=transactionService.getAllTransactions();
		return new  ResponseEntity<List<Transaction>>(transactions,HttpStatus.OK);

	}
	
	
}





/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */



