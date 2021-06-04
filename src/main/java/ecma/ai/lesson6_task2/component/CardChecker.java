package ecma.ai.lesson6_task2.component;

import ecma.ai.lesson6_task2.entity.Card;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class CardChecker {
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    public boolean check(Card card){
        Date expireDate = card.getExpireDate();
        LocalDate expireLocalDate = convertToLocalDateViaInstant(expireDate);
        LocalDate localDate = LocalDate.now();
        return localDate.isBefore(expireLocalDate);
    }
}
