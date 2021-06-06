package ecma.ai.lesson6_task2.Service;

import ecma.ai.lesson6_task2.entity.Card;
import ecma.ai.lesson6_task2.repository.CardRepository;
import ecma.ai.lesson6_task2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyAuthService implements UserDetailsService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String number) throws UsernameNotFoundException {
        Optional<Card> optionalCard = cardRepository.findByNumber(number);
        return optionalCard.orElse(null);
    }
}
