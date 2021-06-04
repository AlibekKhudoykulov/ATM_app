package ecma.ai.lesson6_task2.entity;

import ecma.ai.lesson6_task2.entity.enums.ATMOperationType;
import ecma.ai.lesson6_task2.entity.enums.USDBankNoteType;
import ecma.ai.lesson6_task2.entity.enums.UZSBankNoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banknotes {

    @Id
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private USDBankNoteType usdBankNoteType;

    @Enumerated(value = EnumType.STRING)
    private UZSBankNoteType uzsBankNoteType;//10 000

    private Integer count;//5

}
