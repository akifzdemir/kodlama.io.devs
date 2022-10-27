package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {
    ProgramingLanguageRepository programingLanguageRepository;

    public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository) {
        this.programingLanguageRepository = programingLanguageRepository;
    }

    @Override
    public List<ProgramingLanguage> getALL() {
        return programingLanguageRepository.getALL();
    }

    @Override
    public ProgramingLanguage getById(int id) throws Exception {
        return programingLanguageRepository.getById(id);
    }

    @Override
    public void add(ProgramingLanguage programingLanguage) throws Exception {
        List<ProgramingLanguage> programingLanguages =  programingLanguageRepository.getALL();
        for (ProgramingLanguage pl:programingLanguages) {
            if (pl.getName().equals(programingLanguage.getName())){
                throw new Exception("Programing Language already exist");
            }
        }
        if (programingLanguage.getName().isEmpty()){
            throw  new Exception("Name can't be empty");
        }
        programingLanguageRepository.add(programingLanguage);
    }

    @Override
    public void delete(ProgramingLanguage programingLanguage) throws Exception {
        programingLanguageRepository.delete(programingLanguage);
    }

    @Override
    public void update(ProgramingLanguage programingLanguage) throws Exception {
        programingLanguageRepository.update(programingLanguage);
    }
}
