package ecma.ai.lesson6_task2.repository;

import ecma.ai.lesson6_task2.entity.Operation;
import ecma.ai.lesson6_task2.entity.enums.ATMOperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {

    List<Operation> findAllByAtmId(Integer atm_id);
    List<Operation> findAllByAtmIdAndDateAndOperationType(Integer atm_id, LocalDate date, ATMOperationType operationType);
}
