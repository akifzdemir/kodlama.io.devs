package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.business.requests.ProgramingLanguageAddRequest;
import kodlama.io.devs.business.requests.ProgramingLanguageUpdateRequest;
import kodlama.io.devs.business.responses.GetAllProgramingLanguageResponse;
import kodlama.io.devs.business.responses.GetByIdProgramingLanguageResponse;
import kodlama.io.devs.business.rules.ProgramingLanguageBusinessRules;
import kodlama.io.devs.core.utilities.mappers.ModelMapperManager;
import kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramingLanguageManager implements ProgramingLanguageService {
    ProgramingLanguageRepository programingLanguageRepository;
    ModelMapperManager modelMapperManager;
    ProgramingLanguageBusinessRules programingLanguageBusinessRules;
    @Override
    public List<GetAllProgramingLanguageResponse> getAll() {
        List<ProgramingLanguage> languages = programingLanguageRepository.findAll();

       return languages.stream().map(language->this.modelMapperManager.forResponse()
                       .map(language,GetAllProgramingLanguageResponse.class))
               .collect(Collectors.toList());
    }

    @Override
    public GetByIdProgramingLanguageResponse getResponseById(int id) {
        ProgramingLanguage programingLanguage = programingLanguageRepository.findById(id);
        return modelMapperManager.forResponse().map(programingLanguage, GetByIdProgramingLanguageResponse.class);
    }

    @Override
    public ProgramingLanguage getById(int id) {
        return programingLanguageRepository.findById(id);
    }

    @Override
    public void add(ProgramingLanguageAddRequest languageRequest){
        programingLanguageBusinessRules.checkIfProgramingLanguageExists(languageRequest.getName());
        ProgramingLanguage programingLanguage = this.modelMapperManager.forRequest().map(languageRequest,ProgramingLanguage.class);
        programingLanguageRepository.save(programingLanguage);
    }

    @Override
    public void delete(int id)  {
        programingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(ProgramingLanguageUpdateRequest languageRequest){
        programingLanguageBusinessRules.checkIfProgramingLanguageExists(languageRequest.getName());
        ProgramingLanguage programingLanguage = this.modelMapperManager.forRequest()
                        .map(languageRequest,ProgramingLanguage.class);

        programingLanguageRepository.save(programingLanguage);
    }

}
