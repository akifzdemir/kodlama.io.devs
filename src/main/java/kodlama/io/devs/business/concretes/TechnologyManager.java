package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.TechnologyAddRequest;
import kodlama.io.devs.business.requests.TechnologyUpdateRequest;
import kodlama.io.devs.business.responses.GetAllTechnologyResponse;
import kodlama.io.devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository technologyRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        return  technologies.stream().map(technology -> modelMapperService.forResponse().map(technology, GetAllTechnologyResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) {
        Technology technology = technologyRepository.findById(id);
        return modelMapperService.forResponse().map(technology,GetByIdTechnologyResponse.class);
    }

    @Override
    public void add(TechnologyAddRequest technologyAddRequest) {
        Technology technology = modelMapperService.forRequest().map(technologyAddRequest,Technology.class);
        technology.setId(0);
        technologyRepository.save(technology);
    }

    @Override
    public void update(TechnologyUpdateRequest technologyUpdateRequest) {
        Technology technology = modelMapperService.forRequest().map(technologyUpdateRequest,Technology.class);
        technologyRepository.save(technology);
    }


    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }
}
