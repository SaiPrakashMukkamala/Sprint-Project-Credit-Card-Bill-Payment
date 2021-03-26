package com.cg.creditcardbillpayment.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.StatementRepository;
import com.cg.creditcardbillpayment.entities.Statement;
@Service
public class StatementServiceImpl implements StatementService{
	
	@Autowired
	private StatementRepository statementrepo;

	@Override
	public Statement addStatement(Statement statement) {
		// TODO Auto-generated method stub
		statementrepo.saveAndFlush(statement);
		return statement;
	}

	@Override
	public Statement removeStatement(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement updateStatement(String id, Statement statement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement getStatement(String id) {
		// TODO Auto-generated method stub
		Statement statement=statementrepo.getById(id);
		
		return statement;
	}

	@Override
	public List<Statement> getAllStatements() {
		// TODO Auto-generated method stub
		List<Statement> statements=statementrepo.findAll();
		return statements;
	}

	@Override
	public Statement getBilledStatement(Date duedate) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Statement getUnbilledStatement() {
		// TODO Auto-generated method stub
		return null;
	}

}
