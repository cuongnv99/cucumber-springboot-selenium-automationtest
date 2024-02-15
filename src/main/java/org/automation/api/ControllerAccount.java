package org.automation.api;

import org.automation.entity.Account;
import org.automation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerAccount {
    @Autowired
    private AccountService accountService;

    @Value("${app.version}")
    private String APPLICATION_VERSION;

    @GetMapping("/version")
    public String getVersion() {
        return Optional.ofNullable(APPLICATION_VERSION).orElse("N/A");
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable(name = "id") Long accountId) {
        return accountService.getAccount(accountId);
    }

    @GetMapping("/accounts")
    public List<Account> getAccount() {
        return accountService.getAllAccount();
    }
}
