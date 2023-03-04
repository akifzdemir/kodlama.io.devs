package kodlama.io.devs.dataAccess.abstracts;

import kodlama.io.devs.entities.concretes.ProgramingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramingLanguageRepository extends JpaRepository<ProgramingLanguage,Integer> {
    ProgramingLanguage findById(int id);
    boolean existsProgramingLanguageByName(String name);
}
