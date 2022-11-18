package Kodlama.io.Devs.programmingLanguages.business.requests.technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnologyRequest {
	
	private String technologyName;
	private int languageId;
	
}
