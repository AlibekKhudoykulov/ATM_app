package ecma.ai.lesson6_task2.Service;

import ecma.ai.lesson6_task2.entity.ATM;
import ecma.ai.lesson6_task2.entity.ATMHistory;
import ecma.ai.lesson6_task2.payload.ApiResponse;
import ecma.ai.lesson6_task2.repository.ATMHistoryRepository;
import ecma.ai.lesson6_task2.repository.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static ecma.ai.lesson6_task2.entity.enums.ATMOperationType.PULKIRITAWAL;
import static ecma.ai.lesson6_task2.entity.enums.ATMOperationType.WITHDRAWAL;

@Service
public class ATMHistoryService {
    @Autowired
    ATMHistoryRepository atmHistoryRepository;
    @Autowired
    ATMRepository atmRepository;


    public ApiResponse getAtmHistory(Integer id) {
        Optional<ATM> byId = atmRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("ATM not found", false);
        ATM atm = byId.get();
        List<ATMHistory> allByAtmId = atmHistoryRepository.findAllByAtmId(atm.getId());
        return new ApiResponse("ATM buyicha kirim chiqim", true, allByAtmId);
    }

    public ApiResponse getDailyIncome(Integer id) {
        Optional<ATM> byId = atmRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("ATM not found", false);
        ATM atm = byId.get();
        LocalDate localDate = LocalDate.now();
        List<ATMHistory> allByAtmIdAndDateStartsWith = atmHistoryRepository.findAllByAtmIdAndDateAndOperationType(id, localDate,PULKIRITAWAL);
        return new ApiResponse("ATM buyicha kunlik kirim", true, allByAtmIdAndDateStartsWith);
    }
    public ApiResponse getDailyOutgoings(Integer id){
        Optional<ATM> byId = atmRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("ATM not found", false);
        ATM atm = byId.get();
        LocalDate localDate = LocalDate.now();
        List<ATMHistory> allByAtmIdAndDateStartsWith = atmHistoryRepository.findAllByAtmIdAndDateAndOperationType(id, localDate,WITHDRAWAL);
        return new ApiResponse("ATM buyicha kunlik chiqim", true, allByAtmIdAndDateStartsWith);
    }
}
