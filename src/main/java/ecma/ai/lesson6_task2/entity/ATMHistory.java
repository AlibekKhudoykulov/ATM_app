package ecma.ai.lesson6_task2.entity;

import ecma.ai.lesson6_task2.entity.enums.ATMOperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ATMHistory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ATM atm;

    @Column
    private LocalDate date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Card card;

    @Column
    private double operationAmount;

    @Enumerated(value = EnumType.STRING)
    private ATMOperationType operationType;

}
