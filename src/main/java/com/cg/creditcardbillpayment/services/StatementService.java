package com.cg.creditcardbillpayment.services;

import java.util.Date;
import java.util.List;

import com.cg.creditcardbillpayment.entities.Statement;

public interface StatementService {
	public Statement addStatement(Statement statement);

	public Statement removeStatement(String id);

	public Statement updateStatement(String id, Statement statement);

	public Statement getStatement(String id);

	public List<Statement> getAllStatements();

	public Statement getBilledStatement(Date duedate);

	public Statement getUnbilledStatement();
	
	
}
