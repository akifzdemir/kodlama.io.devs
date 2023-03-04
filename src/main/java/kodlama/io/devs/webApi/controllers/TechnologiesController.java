package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.TechnologyAddRequest;
import kodlama.io.devs.business.requests.TechnologyUpdateRequest;
import kodlama.io.devs.business.responses.GetAllTechnologyResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

    private TechnologyService technologyService;

    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public List<GetAllTechnologyResponse> getAll(){
        return technologyService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody @Valid TechnologyAddRequest technologyAddRequest){
        technologyService.add(technologyAddRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid TechnologyUpdateRequest technologyUpdateRequest){
        technologyService.update(technologyUpdateRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        technologyService.delete(id);
    }

}
