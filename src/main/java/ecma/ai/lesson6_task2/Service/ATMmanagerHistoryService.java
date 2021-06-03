package ecma.ai.lesson6_task2.Service;

import ecma.ai.lesson6_task2.entity.ATM;
import ecma.ai.lesson6_task2.payload.ApiResponse;
import ecma.ai.lesson6_task2.repository.ATMManagerHistoryRepository;
import ecma.ai.lesson6_task2.repository.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ATMmanagerHistoryService {
    @Autowired
    ATMManagerHistoryRepository atmManagerHistoryRepository;
    @Autowired
    ATMRepository atmRepository;
    public ApiResponse getHistory(Integer id){
        Optional<ATM> byId = atmRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("ATM not found",false);
        ATM atm = byId.get();
        List<ATMManagerHistoryRepository> allByAtmId = atmManagerHistoryRepository.findAllByAtmId(atm.getId());
        return new ApiResponse("Filled list",true,allByAtmId);
    }
}
