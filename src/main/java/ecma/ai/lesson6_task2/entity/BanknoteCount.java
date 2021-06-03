package ecma.ai.lesson6_task2.entity;

import ecma.ai.lesson6_task2.entity.enums.ATMOperationType;
import ecma.ai.lesson6_task2.entity.enums.USDBankNoteType;
import ecma.ai.lesson6_task2.entity.enums.UZSBankNoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BanknoteCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private USDBankNoteType usdBankNoteType;

    @Enumerated(value = EnumType.STRING)
    private UZSBankNoteType uzsBankNoteType;//10 000

    private Integer count;//5

    @Column
    private Date date;

    @ManyToOne
    private ATMHistory atmHistory;

    @Enumerated(value = EnumType.STRING)
    private ATMOperationType operationType;

    @ManyToOne
    private User user;
}
