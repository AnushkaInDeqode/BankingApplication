package com.bankingApp.controller;

import com.bankingApp.model.Transaction;
import com.bankingApp.model.User;
import com.bankingApp.repository.TransactionRepository;
import com.bankingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Transaction> transactions = transactionRepository.findByUserId(user.getId());
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/{userId}/deposit")
    public ResponseEntity<String> deposit(@PathVariable Long userId, @RequestBody BigDecimal amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAmount(amount);
        transaction.setTransactionDate(LocalDateTime.now());

        transactionRepository.save(transaction);

        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping("/{userId}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable Long userId, @RequestBody BigDecimal amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAmount(amount.negate());
        transaction.setTransactionDate(LocalDateTime.now());

        transactionRepository.save(transaction);

        return ResponseEntity.ok("Withdrawal successful");
    }
}
