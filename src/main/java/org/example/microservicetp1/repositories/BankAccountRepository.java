package org.example.microservicetp1.repositories;

import org.example.microservicetp1.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
