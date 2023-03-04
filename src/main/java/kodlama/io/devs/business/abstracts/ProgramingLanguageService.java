package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.ProgramingLanguageAddRequest;
import kodlama.io.devs.business.requests.ProgramingLanguageUpdateRequest;
import kodlama.io.devs.business.responses.GetAllProgramingLanguageResponse;
import kodlama.io.devs.business.responses.GetByIdProgramingLanguageResponse;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;

import java.util.List;

public interface ProgramingLanguageService {
    List<GetAllProgramingLanguageResponse> getAll();
    GetByIdProgramingLanguageResponse getResponseById(int id);
    ProgramingLanguage getById(int id);
    void add(ProgramingLanguageAddRequest languageRequest) ;
    void delete(int id);
    void update(ProgramingLanguageUpdateRequest languageRequest);
}
