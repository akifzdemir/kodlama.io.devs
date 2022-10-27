package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.entities.concretes.ProgramingLanguage;
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
    public List<ProgramingLanguage> getAll(){
        return  programingLanguageService.getALL();
    }
    @GetMapping("/getbyid")
    public ProgramingLanguage getById(@RequestParam int id) throws Exception {
        return  programingLanguageService.getById(id);
    }
    @PostMapping("/add")
    public void add(@RequestBody ProgramingLanguage programingLanguage) throws Exception {
        programingLanguageService.add(programingLanguage);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody ProgramingLanguage programingLanguage) throws Exception {
        programingLanguageService.delete(programingLanguage);
    }
    @PutMapping("/update")
    public void update(@RequestBody ProgramingLanguage programingLanguage) throws Exception {
        programingLanguageService.update(programingLanguage);
    }

}
