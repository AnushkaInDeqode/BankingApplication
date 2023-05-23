package com.bankingApp.service;

import com.bankingApp.model.User;
import com.bankingApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionService {
    private UserRepository userRepository;

    public TransactionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void withdrawal(User user, double amount) {
        double currentBalance = user.getBalance();
        user.setBalance(currentBalance - amount);
        userRepository.save(user);
    }

    @Transactional
    public void deposit(User user, double amount) {
        double currentBalance = user.getBalance();
        user.setBalance(currentBalance + amount);
        userRepository.save(user);
    }
}