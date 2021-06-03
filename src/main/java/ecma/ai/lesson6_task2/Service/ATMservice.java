package ecma.ai.lesson6_task2.Service;

import ecma.ai.lesson6_task2.entity.ATM;
import ecma.ai.lesson6_task2.payload.ApiResponse;
import ecma.ai.lesson6_task2.repository.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ATMservice {
    @Autowired
    ATMRepository atmRepository;

    public ApiResponse getBanknotes(Integer id){
        Optional<ATM> byId = atmRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("ATM not found",false);
        ATM atm = byId.get();
        List<Object> banknotes=new ArrayList<>();
        banknotes.add(atm.getBanknoteCountUSD());
        banknotes.add(atm.getBanknoteCountUZS());
        return new ApiResponse("Banknotes",true,banknotes);
    }
}
