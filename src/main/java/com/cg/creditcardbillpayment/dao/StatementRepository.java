package com.cg.creditcardbillpayment.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cg.creditcardbillpayment.entities.Statement;

public interface StatementRepository extends JpaRepository<Statement, String> {



}
