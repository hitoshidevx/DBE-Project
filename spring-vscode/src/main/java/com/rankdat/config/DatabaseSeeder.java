package com.rankdat.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rankdat.models.Account;
import com.rankdat.repository.AccountRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    
    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        
        accountRepository.saveAll(List.of(
            new Account(1L, "toshi", "curto programar!", "toshi.jpeg"),
            new Account(2L, "lucas", "curto futebol sei la!", "lucas.jpeg"),
            new Account(3L, "joao", "curto dar aula acho!", "joaopiggy.jpeg")
        ));
        
    }
}
