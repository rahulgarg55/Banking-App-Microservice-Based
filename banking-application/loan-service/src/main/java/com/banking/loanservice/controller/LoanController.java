package com.banking.loanservice.controller;

import com.banking.loanservice.model.Loan;
import com.banking.loanservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> applyForLoan(@RequestBody Loan loan) {
        return ResponseEntity.ok(loanService.applyForLoan(loan));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Loan>> getLoansByUserId(@PathVariable String userId) {
        List<Loan> loans = loanService.getLoansByUserId(userId);
        if (!loans.isEmpty()) {
            return ResponseEntity.ok(loans);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}