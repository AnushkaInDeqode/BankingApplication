package com.bankingApp.controller;

import com.bankingApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;


@RestController
@RequestMapping("/api/balance")
public class BalanceController {
    private UserService userService;

    public BalanceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getCurrentBalance(Principal principal) {
        String username = principal.getName();
        double balance = userService.getCurrentBalance(username);
        return ResponseEntity.ok(balance);
    }
}
