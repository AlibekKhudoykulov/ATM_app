package ecma.ai.lesson6_task2.repository;

import ecma.ai.lesson6_task2.entity.Card;
import ecma.ai.lesson6_task2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findAllByActiveIsFalse();
}
