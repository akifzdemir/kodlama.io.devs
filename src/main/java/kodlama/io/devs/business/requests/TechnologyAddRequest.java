package kodlama.io.devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyAddRequest {
    @NotNull
    private int programingLanguageId;
    @NotNull
    private String name;
}
