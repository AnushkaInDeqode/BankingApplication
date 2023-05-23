package com.bankingApp.controller;

import com.bankingApp.model.User;
import com.bankingApp.repository.UserRepository;
import com.bankingApp.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private UserRepository userRepository;
    private TransactionService transactionService;

    public TransactionController(UserRepository userRepository, TransactionService transactionService) {
        this.userRepository = userRepository;
        this.transactionService = transactionService;
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdrawal(Principal principal, @RequestParam double amount) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        if (amount <= 0) {
            return ResponseEntity.badRequest().body("Invalid withdrawal amount");
        }

        double currentBalance = user.getBalance();
        if (currentBalance < amount) {
            return ResponseEntity.badRequest().body("Insufficient balance");
        }

        // Perform withdrawal transaction
        transactionService.withdrawal(user, amount);

        return ResponseEntity.ok("Withdrawal successful");
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(Principal principal, @RequestParam double amount) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        if (amount <= 0) {
            return ResponseEntity.badRequest().body("Invalid deposit amount");
        }

        // Perform deposit transaction
        transactionService.deposit(user, amount);

        return ResponseEntity.ok("Deposit successful");
    }
}