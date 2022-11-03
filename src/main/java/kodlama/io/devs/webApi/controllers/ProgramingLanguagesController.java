package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.business.requests.ProgramingLanguageRequest;
import kodlama.io.devs.business.responses.ProgramingLanguageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programinglanguages")
public class ProgramingLanguagesController {
    ProgramingLanguageService programingLanguageService;

    public ProgramingLanguagesController(ProgramingLanguageService programingLanguageService) {
        this.programingLanguageService = programingLanguageService;
    }

    @GetMapping("/getall")
    public List<ProgramingLanguageResponse> getAll(){
        return  programingLanguageService.getALL();
    }
    @GetMapping("/getbyid")
    public ProgramingLanguageResponse getById(@RequestParam int id){
        return  programingLanguageService.getResponseById(id);
    }
    @PostMapping("/add")
    public void add(@RequestBody ProgramingLanguageRequest languageRequest) throws Exception {
        programingLanguageService.add(languageRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        programingLanguageService.delete(id);
    }
    @PutMapping("/update/{id}")
    public void update(@RequestBody ProgramingLanguageRequest languageRequest,@PathVariable int id) throws Exception {
        programingLanguageService.update(languageRequest,id);
    }

}
