package com.cg.creditcardbillpayment.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.AccountRepository;
import com.cg.creditcardbillpayment.dao.PaymentRepository;
import com.cg.creditcardbillpayment.entities.Payment;
@Service
public class PaymentServiceImpl implements PaymentService{
	
	private PaymentRepository paymentrepo;

	@Override
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		paymentrepo.saveAndFlush(payment);
		return payment;
	}

	@Override
	public Payment removePayment(long id) {
		// TODO Auto-generated method stub
		Optional<Payment> payment=paymentrepo.findById(null);
		Payment payment1=payment.get();
		paymentrepo.delete(payment1);
		return null;
	}

	@Override
	public Payment updatePayment(long id, Payment payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment getPayment(long id) {
		// TODO Auto-generated method stub
		Payment payment1=paymentrepo.getById(id);
		return payment1;
	}

	@Override
	public void payPayment(Double amount) {
		// TODO Auto-generated method stub
		
	}

}
