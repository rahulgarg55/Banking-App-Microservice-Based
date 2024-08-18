package com.banking.loanservice.service;

import com.banking.loanservice.model.Loan;
import com.banking.loanservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Loan applyForLoan(Loan loan) {
        loan.setStatus("PENDING");
        Loan savedLoan = loanRepository.save(loan);
        kafkaTemplate.send("loan-applied", savedLoan.getUserId());
        return savedLoan;
    }

    public List<Loan> getLoansByUserId(String userId) {
        return loanRepository.findByUserId(userId);
    }
}