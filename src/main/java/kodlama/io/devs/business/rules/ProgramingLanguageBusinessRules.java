package kodlama.io.devs.business.rules;

import kodlama.io.devs.core.utilities.exceptions.BusinessException;
import kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProgramingLanguageBusinessRules {
    private ProgramingLanguageRepository programingLanguageRepository;

    public void checkIfProgramingLanguageExists(String name){
            if (programingLanguageRepository.existsProgramingLanguageByName(name)){
                throw new BusinessException("Programing Language already exist.");
            }
    }

}
