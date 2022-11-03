package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.TechnologyRequest;
import kodlama.io.devs.business.responses.TechnologyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

    private TechnologyService technologyService;

    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public List<TechnologyResponse> getAll(){
        return technologyService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody TechnologyRequest technologyRequest){
        technologyService.add(technologyRequest);
    }
    @PutMapping("/update/{id}")
    public void update(@RequestBody TechnologyRequest technologyRequest,@PathVariable int id){
        technologyService.update(technologyRequest,id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        technologyService.delete(id);
    }

}
