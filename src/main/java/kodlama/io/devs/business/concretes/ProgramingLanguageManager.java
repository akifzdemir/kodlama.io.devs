package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.business.requests.ProgramingLanguageRequest;
import kodlama.io.devs.business.responses.ProgramingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {
    ProgramingLanguageRepository programingLanguageRepository;

    public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository) {
        this.programingLanguageRepository = programingLanguageRepository;
    }


    @Override
    public List<ProgramingLanguageResponse> getALL() {
        List<ProgramingLanguage> languages = programingLanguageRepository.findAll();
        List<ProgramingLanguageResponse> responses = new ArrayList<>();
        for(ProgramingLanguage programingLanguage: languages){
            ProgramingLanguageResponse responseItem = new ProgramingLanguageResponse();
            responseItem.setId(programingLanguage.getId());
            responseItem.setName(programingLanguage.getName());
            responses.add(responseItem);
        }
        return responses;
    }

    @Override
    public ProgramingLanguageResponse getById(int id) {
        ProgramingLanguage programingLanguage = programingLanguageRepository.findById(id);
        ProgramingLanguageResponse languageResponse = new ProgramingLanguageResponse();
        languageResponse.setName(programingLanguage.getName());
        languageResponse.setId(programingLanguage.getId());
        return languageResponse;
    }

    @Override
    public void add(ProgramingLanguageRequest languageRequest) throws Exception {
        checkNameValid(languageRequest.getName());
        ProgramingLanguage programingLanguage = new ProgramingLanguage();
        programingLanguage.setName(languageRequest.getName());
        programingLanguageRepository.save(programingLanguage);
    }

    @Override
    public void delete(int id)  {
        programingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(ProgramingLanguageRequest languageRequest,int id) throws Exception {
        checkNameValid(languageRequest.getName());
        ProgramingLanguage programingLanguage = programingLanguageRepository.findById(id);
        programingLanguage.setName(languageRequest.getName());
        programingLanguageRepository.save(programingLanguage);
    }
    private void checkNameValid(String name) throws Exception {
        ProgramingLanguage isExist = programingLanguageRepository.findByName(name);
        if (isExist != null){
            throw new Exception("This name already exist!");
        }
        if (name.isBlank()){
            throw new Exception("Name can't be null");
        }
    }
}
