package ecma.ai.lesson6_task2.entity;

import ecma.ai.lesson6_task2.entity.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Card{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 16)
    private String number;
    @Column(length = 3)
    private String cvv;

    @ManyToOne
    private Bank bank;
    @ManyToOne
    private User user;

    private String fullName;

    @Column(length = 4)
    private String pinCode;

    private Date expireDate;

    @Enumerated(EnumType.STRING)
    private CardType cardType;
    private boolean active = false; // xodim kimgadr cardni bermagancha active bo'lmaydi
    private boolean blocked = false; //blok
    private double balance;

    public Card(Integer id, String number, String cvv, Bank bank, String fullName, String pinCode, Date expireDate, CardType cardType, boolean active, boolean blocked, double balance) {
        this.id = id;
        this.number = number;
        this.cvv = cvv;
        this.bank = bank;
        this.fullName = fullName;
        this.pinCode = pinCode;
        this.expireDate = expireDate;
        this.cardType = cardType;
        this.active = active;
        this.blocked = blocked;
        this.balance = balance;
    }
}
