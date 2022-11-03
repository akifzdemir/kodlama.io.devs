package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.TechnologyRequest;
import kodlama.io.devs.business.responses.TechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;
import kodlama.io.devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository technologyRepository;
    private ProgramingLanguageService programingLanguageService;

    public TechnologyManager(TechnologyRepository technologyRepository, ProgramingLanguageService programingLanguageService) {
        this.technologyRepository = technologyRepository;
        this.programingLanguageService = programingLanguageService;
    }

    @Override
    public List<TechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<TechnologyResponse> responses = new ArrayList<>();
        for (Technology technology: technologies){
            TechnologyResponse technologyResponse = new TechnologyResponse();
            technologyResponse.setName(technology.getName());
            technologyResponse.setProgramingLanguageId(technology.getProgramingLanguage().getId());
            technologyResponse.setId(technology.getId());
            technologyResponse.setProgramingLanguageName(technology.getProgramingLanguage().getName());
            responses.add(technologyResponse);
        }
        return responses;
    }

    @Override
    public void add(TechnologyRequest technologyRequest) {
        Technology technology = new Technology();
        ProgramingLanguage programingLanguage = programingLanguageService.getById(technologyRequest.getProgramingLanguageId());
        technology.setName(technologyRequest.getName());
        technology.setProgramingLanguage(programingLanguage);
        technologyRepository.save(technology);
    }

    @Override
    public void update(TechnologyRequest technologyRequest,int id) {
        Technology updateTechnology = technologyRepository.findById(id);
        ProgramingLanguage updateProgramingLanguageId = programingLanguageService.getById(technologyRequest.getProgramingLanguageId());
        updateTechnology.setName(technologyRequest.getName());
        updateTechnology.setProgramingLanguage(updateProgramingLanguageId);
        technologyRepository.save(updateTechnology);
    }

    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }
}
