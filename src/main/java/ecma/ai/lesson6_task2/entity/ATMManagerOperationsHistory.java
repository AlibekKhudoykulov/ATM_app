package ecma.ai.lesson6_task2.entity;

import ecma.ai.lesson6_task2.entity.enums.ATMOperationType;
import ecma.ai.lesson6_task2.entity.enums.UZSBankNoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ATMManagerOperationsHistory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date date;

    @ManyToOne
    private User user;

    @ManyToOne
    private ATM atm;

    @Enumerated(value = EnumType.STRING)
    private ATMOperationType operationType;

    @OneToMany(mappedBy = "atm",cascade = CascadeType.ALL)
    private List<BanknoteCountUZS> banknoteCountUZS;

    @OneToMany(mappedBy = "atm",cascade = CascadeType.ALL)
    private List<BanknoteCountUSD> banknoteCountUSD;

}
