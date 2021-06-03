package ecma.ai.lesson6_task2.repository;

import ecma.ai.lesson6_task2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
