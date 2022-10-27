package kodlama.io.devs.dataAccess.abstracts;

import kodlama.io.devs.entities.concretes.ProgramingLanguage;

import java.util.List;

public interface ProgramingLanguageRepository {
    List<ProgramingLanguage> getALL();
    ProgramingLanguage getById(int id) throws Exception;
    void add(ProgramingLanguage programingLanguage) throws Exception;
    void delete(ProgramingLanguage programingLanguage) throws Exception;
    void update(ProgramingLanguage programingLanguage) throws Exception;
}
