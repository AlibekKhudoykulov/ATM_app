package ecma.ai.lesson6_task2.repository;

import ecma.ai.lesson6_task2.entity.BanknoteCountUSD;
import ecma.ai.lesson6_task2.entity.BanknoteCountUZS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankNoteCountUzsRepository extends JpaRepository<BanknoteCountUZS, Integer> {
}
