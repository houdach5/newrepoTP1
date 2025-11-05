package org.example.microservicetp1.service;

import org.example.microservicetp1.dto.BankAccountRequestDTO;
import org.example.microservicetp1.dto.BankAccountResponseDTO;
import org.example.microservicetp1.entities.BankAccount;
import org.example.microservicetp1.enums.AccountType;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);


    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
