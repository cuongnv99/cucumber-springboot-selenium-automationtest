package org.automation.service;

import org.automation.entity.Account;
import org.automation.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Long saveAccount(Account account) {
        return accountRepository.save(account).getId();
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }
    public void  deleteAccount(Long id) {
         accountRepository.deleteById(id);
    }
}
