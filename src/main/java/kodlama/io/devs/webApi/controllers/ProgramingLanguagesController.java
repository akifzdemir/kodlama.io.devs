package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.business.requests.ProgramingLanguageAddRequest;
import kodlama.io.devs.business.requests.ProgramingLanguageUpdateRequest;
import kodlama.io.devs.business.responses.GetAllProgramingLanguageResponse;
import kodlama.io.devs.business.responses.GetByIdProgramingLanguageResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/programinglanguages")
public class ProgramingLanguagesController {
    ProgramingLanguageService programingLanguageService;

    public ProgramingLanguagesController(ProgramingLanguageService programingLanguageService) {
        this.programingLanguageService = programingLanguageService;
    }

    @GetMapping("/getall")
    public List<GetAllProgramingLanguageResponse> getAll(){
        return  programingLanguageService.getAll();
    }
    @GetMapping("/getbyid")
    public GetByIdProgramingLanguageResponse getById(@RequestParam int id){
        return  programingLanguageService.getResponseById(id);
    }
    @PostMapping("/add")
    public void add(@RequestBody @Valid ProgramingLanguageAddRequest languageRequest)  {
        programingLanguageService.add(languageRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        programingLanguageService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid ProgramingLanguageUpdateRequest languageRequest)  {
        programingLanguageService.update(languageRequest);
    }

}
