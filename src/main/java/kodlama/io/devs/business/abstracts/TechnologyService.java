package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.TechnologyAddRequest;
import kodlama.io.devs.business.requests.TechnologyUpdateRequest;
import kodlama.io.devs.business.responses.GetAllTechnologyResponse;
import kodlama.io.devs.business.responses.GetByIdTechnologyResponse;

import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologyResponse> getAll();
    GetByIdTechnologyResponse getById(int id);
    void add(TechnologyAddRequest technologyAddRequest);
    void update(TechnologyUpdateRequest technologyUpdateRequest);
    void delete(int id);

}
