package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.ProgramingLanguageRequest;
import kodlama.io.devs.business.responses.ProgramingLanguageResponse;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;

import java.util.List;

public interface ProgramingLanguageService {
    List<ProgramingLanguageResponse> getALL();
    ProgramingLanguageResponse getById(int id);
    void add(ProgramingLanguageRequest languageRequest) throws Exception;
    void delete(int id);
    void update(ProgramingLanguageRequest languageRequest,int id) throws Exception;
}
