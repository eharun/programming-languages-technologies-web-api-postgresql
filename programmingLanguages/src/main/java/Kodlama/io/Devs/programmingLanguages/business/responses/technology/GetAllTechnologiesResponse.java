package Kodlama.io.Devs.programmingLanguages.business.responses.technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologiesResponse {
	private int technologyId;
	private String technologyName;
	private int languageId;
	private String languageName;
}
