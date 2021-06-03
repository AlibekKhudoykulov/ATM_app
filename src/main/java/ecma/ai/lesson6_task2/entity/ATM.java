package ecma.ai.lesson6_task2.entity;

import ecma.ai.lesson6_task2.entity.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ATM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    private List<CardType> cardTypes;

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "atm",cascade = CascadeType.ALL)
    private List<BanknoteCountUZS> banknoteCountUZS;

    @OneToMany(mappedBy = "atm",cascade = CascadeType.ALL)
    private List<BanknoteCountUSD> banknoteCountUSD;

    private double balanceUZS;
    private double balanceUSD;
    private double maxWithdrawal; //Maksimum yechish mumkin bo'lgan summa
    private double alertAmount; //minimum - shunga yetib kelganda bank hodimiga message boradi
    private String address;





}


