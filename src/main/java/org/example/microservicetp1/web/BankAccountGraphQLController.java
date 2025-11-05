package org.example.microservicetp1.web;

import org.example.microservicetp1.dto.BankAccountRequestDTO;
import org.example.microservicetp1.dto.BankAccountResponseDTO;
import org.example.microservicetp1.entities.BankAccount;
import org.example.microservicetp1.entities.Customer;
import org.example.microservicetp1.repositories.BankAccountRepository;
import org.example.microservicetp1.repositories.CustomerRepository;
import org.example.microservicetp1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping; // <- ajoute ceci

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount BankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id, bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);

    }
    @QueryMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }
}
/*
record BankAccountDTO(Double balance, String type, String currency){


}
*/
