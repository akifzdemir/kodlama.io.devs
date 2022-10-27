package kodlama.io.devs.dataAccess.concretes;

import kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryProgramingLanguageRepository implements ProgramingLanguageRepository {
    List<ProgramingLanguage> programingLanguages;

    public InMemoryProgramingLanguageRepository() {
        programingLanguages = new  ArrayList<ProgramingLanguage>();
        programingLanguages.add(new ProgramingLanguage(1,"C#"));
        programingLanguages.add(new ProgramingLanguage(2,"Java"));
        programingLanguages.add(new ProgramingLanguage(3,"Python"));

    }

    @Override
    public List<ProgramingLanguage> getALL() {
        return programingLanguages;
    }

    @Override
    public ProgramingLanguage getById(int id) throws Exception {
        for(ProgramingLanguage pl: programingLanguages){
            if (pl.getId()==id){
                return  pl;
            }
        }
        throw new Exception("Programing Language not exist");
    }

    @Override
    public void add(ProgramingLanguage programingLanguage) {
        programingLanguages.add(programingLanguage);
    }

    @Override
    public void delete(ProgramingLanguage programingLanguage) throws Exception {
        int index = programingLanguages.indexOf(getById(programingLanguage.getId()));
        programingLanguages.remove(index);
    }

    @Override
    public void update(ProgramingLanguage programingLanguage) throws Exception {
        int index = programingLanguages.indexOf(getById(programingLanguage.getId()));
        programingLanguages.set(index,programingLanguage);
    }
}
