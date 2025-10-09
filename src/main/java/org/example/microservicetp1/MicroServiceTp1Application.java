package org.example.microservicetp1;

import org.example.microservicetp1.entities.BankAccount;
import org.example.microservicetp1.enums.AccountType;
import org.example.microservicetp1.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroServiceTp1Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceTp1Application.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository ){
        return args ->{
            for (int i= 0; i<10; i++){
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVINGS_ACCOUNT)
                        .balance(10000+Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();

                bankAccountRepository.save(bankAccount);
            }
        };
    }
}
