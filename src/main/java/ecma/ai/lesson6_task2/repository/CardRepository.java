package ecma.ai.lesson6_task2.repository;

import ecma.ai.lesson6_task2.entity.Card;
import ecma.ai.lesson6_task2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findAllByActiveIsFalse();

Optional<Card> findByNumber(@Size(min = 16, max = 16) String number);

List<Card> findAllByUserId(Integer user_id);
}
