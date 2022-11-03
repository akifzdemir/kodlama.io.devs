package kodlama.io.devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyResponse {
    private int id;
    private int programingLanguageId;
    private String programingLanguageName;
    private String name;
}
